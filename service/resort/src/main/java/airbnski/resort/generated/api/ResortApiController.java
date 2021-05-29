package airbnski.resort.generated.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-13T17:50:21.484022+02:00[Europe/Zurich]")

@Controller
@RequestMapping("${openapi.aPITitle.base-path:}")
public class ResortApiController implements ResortApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ResortApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
