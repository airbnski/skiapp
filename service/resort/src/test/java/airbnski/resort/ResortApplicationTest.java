package airbnski.resort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResortApplicationTest {
    @Test
    public void testExitExceptionGetExitCode() {
        assertEquals(10, ((new ResortApplication()).new ExitException()).getExitCode());
    }

    @Test
    public void testRun() throws Exception {
        assertThrows(ResortApplication.ExitException.class, () -> (new ResortApplication()).run("exitcode", "foo", "foo"));
    }
}

