package airbnski.resort.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SwissSkiServiceTest {
    @Test
    public void testConstructor() {
        assertEquals(264, (new SwissSkiService()).dataMap.size());
    }

    @Test
    public void testGetResortById() {
        assertNull((new SwissSkiService()).getResortById(1));
    }

    @Test
    void testGetResortByIdNull(){ assertNull(new SwissSkiService().getResortById(-1)); }

    @Test
    public void testGetAllValidResorts() { assertEquals(264, (new SwissSkiService()).getAllValidResorts().size()); }
}

