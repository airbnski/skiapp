package airbnski.resort.generated.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InlineResponse404Test {
    @Test
    public void testEquals() {
        assertFalse((new InlineResponse404()).equals("42"));
        assertFalse((new InlineResponse404()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(31, (new InlineResponse404()).hashCode());
    }

    @Test
    public void testConstructor() {
        InlineResponse404 actualInlineResponse404 = new InlineResponse404();
        actualInlineResponse404.message("Not all who wander are lost");
        actualInlineResponse404.setMessage("Not all who wander are lost");
        assertEquals("Not all who wander are lost", actualInlineResponse404.getMessage());
        assertEquals("class InlineResponse404 {\n    message: Not all who wander are lost\n}",
                actualInlineResponse404.toString());
    }
}

