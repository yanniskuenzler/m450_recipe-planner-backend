package ch.vanessen.menu;

import ch.vanessen.menu.entities.Menu;
import ch.vanessen.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class MenuPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuPlannerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MenuRepository menuRepository) {
		return args -> {
			Stream.of("Jonas", "Patrick", "Yves", "Peter", "Ann").forEach(name -> {
				Menu user = new Menu(name, name.toLowerCase() + "@tbz.ch");
				menuRepository.save(user);
			});
			menuRepository.findAll().forEach(s -> log.info(s.toString()));
		};
	}

}
