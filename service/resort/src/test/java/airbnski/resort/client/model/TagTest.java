package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagTest {
    @Test
    public void testConstructor() {
        Tag actualTag = new Tag();
        actualTag.setId(123L);
        actualTag.setName("Name");
        assertEquals(123L, actualTag.getId().longValue());
        assertEquals("Name", actualTag.getName());
    }
}

