package cinema;

import cinema.dto.Cinema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "dto", basePackageClasses = Controller.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}
