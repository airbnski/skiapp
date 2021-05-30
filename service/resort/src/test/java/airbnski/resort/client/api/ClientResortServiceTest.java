package airbnski.resort.client.api;

import airbnski.resort.client.model.ClientResort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@ContextConfiguration(classes = {ClientResortService.class})
@ExtendWith(SpringExtension.class)
public class ClientResortServiceTest {
    @Autowired
    private ClientResortService clientResortService;

    @Test
    public void testGetBaseUrl() {
        assertEquals("https://skimap.org/SkiAreas/view/", this.clientResortService.getBaseUrl());
    }

    @Test
    public void testReturnClass() {
        Class<ClientResort> actualReturnClassResult = this.clientResortService.returnClass();
        assertSame(ClientResort.class, actualReturnClassResult);
    }
}

