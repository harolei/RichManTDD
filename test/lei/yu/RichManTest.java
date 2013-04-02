package lei.yu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RichManTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private RichManGamer gamer;
    private RichManAction gamerAction;
    private RichManGamer newGamer;
    private NormalLand currentLand;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        gamer = new RichManGamer("A");
        gamerAction = new RichManAction();
        newGamer = new RichManGamer("Q");
        currentLand = (NormalLand)gamerAction.getLandsManager().getSpecifiedLandOnTheMap(6);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_print_the_map() throws Exception {
        gamerAction.getRichManMap().printMap();
        assertEquals("S0000000000000H0000000000000T" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "M0000000000000P0000000000000G" + '\n',outContent.toString());
    }

    @Test
    public void should_display_gamer_position_on_map() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6, gamer);
        gamerAction.getRichManMap().printMap();
        assertEquals("S00000A0000000H0000000000000T" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "M0000000000000P0000000000000G" + '\n',outContent.toString());
    }

    @Test
    public void should_change_the_land_owner_after_sold() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        gamerAction.buySpecifiedLand(6,gamer);
        assertEquals(gamer, currentLand.getLandOwner());
    }

    @Test
    public void should_refresh_the_map_when_the_gamer_keep_going() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6, gamer);
        gamerAction.removeGamerOnCurrentLandBeforeMove(gamer);
        gamerAction.setGamerMoveOnTheMap(2, gamer);
        gamerAction.getRichManMap().printMap();
        assertEquals("S0000000A00000H0000000000000T" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "M0000000000000P0000000000000G" + '\n',outContent.toString());
    }

    @Test
    public void should_upgrade_the_land_level_when_gamer_move_to_its_own_land_again() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        gamerAction.buySpecifiedLand(6,gamer);
        gamerAction.removeGamerOnCurrentLandBeforeMove(gamer);
        gamerAction.setGamerMoveOnTheMap(70,gamer);
        gamerAction.upgradeCurrentLand(gamer);
        assertEquals(1,currentLand.getLandLevel());
    }

    @Test
    public void should_check_if_the_gamer_is_on_its_own_land() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        gamerAction.buySpecifiedLand(6,gamer);
        gamerAction.removeGamerOnCurrentLandBeforeMove(gamer);
        gamerAction.setGamerMoveOnTheMap(70,gamer);
        assertEquals(true, gamerAction.checkIfTheGamerIsOnItOwnLand(gamer, currentLand));
    }

    @Test
    public void should_pay_money_when_gamer_move_to_other_gamers_land() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        gamerAction.buySpecifiedLand(6,gamer);
        gamerAction.setGamerMoveOnTheMap(6,newGamer);
        gamerAction.payTools(newGamer,currentLand);
        assertThat(newGamer.getBalance(),is(900.0));
    }

    @Test
    public void should_add_balance_of_gamer_if_other_gamer_payed_tolls() throws Exception {
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        gamerAction.buySpecifiedLand(6,gamer);
        gamerAction.setGamerMoveOnTheMap(6, newGamer);
        gamerAction.payTools(newGamer, currentLand);
        assertThat(gamer.getBalance(),is(900.0));

    }
}
