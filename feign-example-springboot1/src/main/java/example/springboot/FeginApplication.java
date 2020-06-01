package example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class FeginApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginApplication.class, args);
    }
}
