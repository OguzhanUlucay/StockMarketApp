package main.java.stockmarket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import main.java.stockmarket.Repositories.*;
import main.java.stockmarket.Entities.*;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(UserRepository repository,ShareRepository shareRepository) {
		return args -> {
			repository.save(new User("Oguzhan","Ulucay", "oguzhanulucay@gmail.com","admin"));
		    repository.save(new User("User1","UserLast1","user1@gmail.com","user"));
		    shareRepository.save(new Share("NETAS","NETAS TELEKOM"));
		};
	}
}
