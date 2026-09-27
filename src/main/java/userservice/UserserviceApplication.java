package userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(UserserviceApplication.class, args);
		ConfigurableEnvironment environment = run.getEnvironment();
		String[] activeProfiles = environment.getActiveProfiles();
		Arrays.stream(activeProfiles).forEach(System.out::println);

	}

}
