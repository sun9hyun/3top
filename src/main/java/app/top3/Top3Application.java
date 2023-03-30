package app.top3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.Stream;

@EnableScheduling
@SpringBootApplication
public class Top3Application {

	public static void main(String[] args) {
		SpringApplication.run(Top3Application.class, args);

	}

}
