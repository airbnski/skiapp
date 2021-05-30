package airbnski.resort.generated.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockServletContext;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenAPIDocumentationConfigTest {
    @Test
    public void testApiInfo() {
        ApiInfo actualApiInfoResult = (new OpenAPIDocumentationConfig()).apiInfo();
        assertEquals("1.0", actualApiInfoResult.getVersion());
        assertEquals("This is the official REST API specification for AirBNSKI Resort Microservice. https://github.com"
                + "/airbnski/skiapp/wiki", actualApiInfoResult.getDescription());
        assertEquals("http://unlicense.org", actualApiInfoResult.getLicenseUrl());
        assertEquals("", actualApiInfoResult.getTermsOfServiceUrl());
        assertTrue(actualApiInfoResult.getVendorExtensions().isEmpty());
        assertEquals("AirBNSki Resort Microservice API", actualApiInfoResult.getTitle());
        assertEquals("", actualApiInfoResult.getLicense());
        Contact contact = actualApiInfoResult.getContact();
        assertEquals("", contact.getUrl());
        assertEquals("", contact.getName());
        assertEquals("", contact.getEmail());
    }

    @Test
    public void testBasePathAwareRelativePathProviderApplicationPath() {
        OpenAPIDocumentationConfig openAPIDocumentationConfig = new OpenAPIDocumentationConfig();
        assertEquals("/Base Path",
                (openAPIDocumentationConfig.new BasePathAwareRelativePathProvider(new MockServletContext(), "Base Path"))
                        .applicationPath());
    }

    @Test
    public void testBasePathAwareRelativePathProviderGetOperationPath() {
        OpenAPIDocumentationConfig openAPIDocumentationConfig = new OpenAPIDocumentationConfig();
        assertEquals("/Operation Path",
                (openAPIDocumentationConfig.new BasePathAwareRelativePathProvider(new MockServletContext(), "Base Path"))
                        .getOperationPath("Operation Path"));
    }

    @Test
    public void testBasePathAwareRelativePathProviderGetOperationPath2() {
        OpenAPIDocumentationConfig openAPIDocumentationConfig = new OpenAPIDocumentationConfig();
        assertEquals("/",
                (openAPIDocumentationConfig.new BasePathAwareRelativePathProvider(new MockServletContext(), "Base Path"))
                        .getOperationPath("Base Path"));
    }
}

