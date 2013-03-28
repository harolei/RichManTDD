package lei.yu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RichManTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private RichManGamer gamer;
    private RichManAction gamerAction;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        gamer = new RichManGamer("A");
        gamerAction = new RichManAction();
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
        NormalLand soldLand = (NormalLand)gamerAction.getRichManMap().getSpecifiedLandOnTheMap(6);
        assertEquals(gamer, soldLand.getLandOwner());
    }
}
