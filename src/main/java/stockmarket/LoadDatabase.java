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
			repository.save(new User("user", "Oguzhan","Ulucay", "oguzhanulucay@gmail.com","password", new String[]{"ROLE_USER"}));
		    repository.save(new User("admin","AdminName","AdminLast", "admin@gmail.com","password",new String[] {"ROLE_USER","ROLE_ADMIN"}));
		    shareRepository.save(new Share("NETAS","NETAS TELEKOM"));
		    shareRepository.save(new Share("THY","TURK HAVA YOLLARI"));
		    shareHandler.createNewShareInfo("NETAS","NETAS TELEKOM");
		    shareHandler.createNewShareInfo("THY","TURK HAVA YOLLARI");
		};
	}
}
