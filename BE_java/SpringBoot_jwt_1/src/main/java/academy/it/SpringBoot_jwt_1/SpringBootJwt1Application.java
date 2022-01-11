package academy.it.SpringBoot_jwt_1;

import academy.it.SpringBoot_jwt_1.entity.Role;
import academy.it.SpringBoot_jwt_1.entity.User;
import academy.it.SpringBoot_jwt_1.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootJwt1Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootJwt1Application.class, args);
	}

	// Al iniciar el projecte, inicialitzem el bean per codificar els passwords
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args ->{
			userService.saveRole(new Role(null, "ROLE_USER" ));
			userService.saveRole(new Role(null, "ROLE_MANAGER" ));
			userService.saveRole(new Role(null, "ROLE_ADMIN" ));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN" ));

			userService.saveUser(new User(null,"Joan Canet","jcanet","12345", new ArrayList<>()));
			userService.saveUser(new User(null,"Ona Calia","ocalia","23451", new ArrayList<>()));
			userService.saveUser(new User(null,"Anna Soler","asoler","34512", new ArrayList<>()));
			userService.saveUser(new User(null,"Pep Armengol","parmengol","45123", new ArrayList<>()));
			userService.saveUser(new User(null,"Rosa Mantú","rmantu","51234", new ArrayList<>()));

			userService.addRoleToUser("jcanet","ROLE_USER");
			userService.addRoleToUser("jcanet","ROLE_MANAGER");
			userService.addRoleToUser("ocalia","ROLE_MANAGER");
			userService.addRoleToUser("asoler","ROLE_ADMIN");
			userService.addRoleToUser("parmengol","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("parmengol","ROLE_ADMIN");
			userService.addRoleToUser("parmengol","ROLE_USER");

		};
	}
}
