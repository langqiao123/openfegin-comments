package example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan({"example.springboot"})
public class FeginExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginExampleApplication.class, args);
    }
}
