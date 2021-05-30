package airbnski.resort.generated.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.NativeWebRequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {ResortApiController.class})
@ExtendWith(SpringExtension.class)
public class ResortApiControllerTest {
    @MockBean
    private NativeWebRequest nativeWebRequest;

    @Autowired
    private ResortApiController resortApiController;

    @Test
    public void testGetRequest() {
        assertTrue(this.resortApiController.getRequest().isPresent());
    }
}

