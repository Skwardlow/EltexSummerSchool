package ru.skwardlow.example.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.skwardlow.example.springdata.entities.User;
import ru.skwardlow.example.springdata.interfaces.UserRepository;

@SpringBootApplication
public class WebServerDataApplication {

	private static final Logger log = LoggerFactory.getLogger(WebServerDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebServerDataApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository crudRepository){
		return (args) ->{
			crudRepository.save(new User("Ivan", "900"));
			crudRepository.save(new User("Boris", "800"));
			for (User user : crudRepository.findAll()) {
				System.out.println(user.getFio());
			log.info(user.getFio());
			}

		};
	}


}
