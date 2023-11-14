package warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * The Application that starts the MOM sender OR receiver
 *
 * @author Manuel Fellner
 * @version 14.11.2023
 */
@SpringBootApplication
public class MOMApplication {

	public static void main(String[] args) {
		// We need to run this app on another port because the API from the warehouse is taking up port 8080
		SpringApplication app = new SpringApplication(MOMApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8081"));
		app.run(args);
	}
}
