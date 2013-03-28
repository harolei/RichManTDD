package lei.yu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RichManTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_print_the_map() throws Exception {
        RichManMap map = new RichManMap();
        map.printMap();
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
        RichManGamer gamer = new RichManGamer("A");
        RichManAction gamerAction = new RichManAction();
        gamerAction.setGamerMoveOnTheMap(6,gamer);
        RichManMap map = new RichManMap();
        map.printMap();
        assertEquals("S00000A0000000H0000000000000T" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "$                           0" + '\n' +
                     "M0000000000000P0000000000000G" + '\n',outContent.toString());

    }
}
