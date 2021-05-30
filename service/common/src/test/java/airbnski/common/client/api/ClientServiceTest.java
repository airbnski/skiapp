package airbnski.common.client.api;

import airbnski.common.client.model.AbstractEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {ClientService.class})
@ExtendWith(SpringExtension.class)
public class ClientServiceTest {
    @Autowired
    private ClientService<Object> clientService;

    @Test
    public void testReturnClass() {
        Class<AbstractEntity> actualReturnClassResult = this.clientService.returnClass();
        assertSame(AbstractEntity.class, actualReturnClassResult);
    }

    @Test
    public void testConstructor() {
        ClientService<Object> actualClientService = new ClientService<Object>();
        actualClientService.setId(1);
        actualClientService.setLatitude(10.0);
        actualClientService.setLongitude(10.0);
        assertNull(actualClientService.getApiKey());
        assertNull(actualClientService.getBaseUrl());
        assertEquals(1, actualClientService.getId().intValue());
        assertEquals(10.0, actualClientService.getLatitude().doubleValue());
        assertEquals(10.0, actualClientService.getLongitude().doubleValue());
    }

    @Test
    public void testGenerateUrl() {
        assertEquals("nulllat=null&lon=null&appid=null", this.clientService.generateUrl());
    }
}

