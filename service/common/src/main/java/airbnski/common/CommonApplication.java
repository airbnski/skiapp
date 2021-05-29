package airbnski.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"airbnski.common", "airbnski.common.client.api"})
public class CommonApplication {
    public static void main(String[] args) throws Exception {
        new SpringApplication(CommonApplication.class).run(args);
    }
}
