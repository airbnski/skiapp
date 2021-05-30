package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ClientResponseTest {
    @Test
    public void testConstructor() {
        ClientResponse actualClientResponse = new ClientResponse();
        actualClientResponse.setRegion(new Region[]{new Region()});
        ClientResort clientResort = new ClientResort();
        actualClientResponse.setResort(clientResort);
        assertSame(clientResort, actualClientResponse.getResort());
    }
}

