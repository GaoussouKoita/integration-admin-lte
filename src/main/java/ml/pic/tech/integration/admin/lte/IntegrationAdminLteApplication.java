package ml.pic.tech.integration.admin.lte;

import ml.pic.tech.integration.admin.lte.entity.Role;
import ml.pic.tech.integration.admin.lte.entity.Utilisateur;
import ml.pic.tech.integration.admin.lte.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IntegrationAdminLteApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationAdminLteApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService) {
		return args -> {
			List roles = new ArrayList<Role>();
			roles.add(new Role(2L, "UTILISATEUR"));
			roles.add(new Role(1L, "ADMINISTRATEUR"));

			for (int i=0; i<roles.size(); i++){
				accountService.addRole(new Role(1L, "ADMINISTRATEUR"));
				accountService.addRole(new Role(2L, "UTILISATEUR"));
			}

			accountService.addUser(new Utilisateur(1L, "Gaoussou", "KOITA", "admin", "1234", roles));
			roles.remove(1);
			for (int i = 1; i < 35; i++) {
				accountService.addUser(new Utilisateur(1L+i, "User_"+i, "Ing_"+i, "user", "1234", roles));

			}
		};
	}
}
