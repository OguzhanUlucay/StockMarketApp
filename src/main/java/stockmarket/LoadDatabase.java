package main.java.stockmarket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import main.java.stockmarket.Repositories.*;
import main.java.stockmarket.Entities.*;
import main.java.stockmarket.Handlers.ShareHandler;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(UserRepository repository,ShareRepository shareRepository, ShareHandler shareHandler) {
		return args -> {
			repository.save(new User("Oguzhan","Ulucay", "oguzhanulucay@gmail.com","admin"));
		    repository.save(new User("User1","UserLast1","user1@gmail.com","user"));
		    shareRepository.save(new Share("NETAS","NETAS TELEKOM"));
		    shareRepository.save(new Share("THY","TURK HAVA YOLLARI"));
		    shareHandler.createNewShareInfo("NETAS","NETAS TELEKOM");
		    shareHandler.createNewShareInfo("THY","TURK HAVA YOLLARI");
		};
	}
}
