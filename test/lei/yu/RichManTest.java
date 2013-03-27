package lei.yu;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RichManTest {
    @Test
    public void should_print_the_map() throws Exception {
        RichManMap map = new RichManMap();
        assertThat(map.getMap(),is("S0000000000000H0000000000000T" + '\n' +
                                   "$                           0" + '\n' +
                                   "$                           0" + '\n' +
                                   "$                           0" + '\n' +
                                   "$                           0" + '\n' +
                                   "$                           0" + '\n' +
                                   "$                           0" + '\n' +
                                   "M0000000000000P0000000000000G"));
    }
}
