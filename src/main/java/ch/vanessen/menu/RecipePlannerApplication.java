package ch.vanessen.menu;

import ch.vanessen.menu.domain.Ingredient;
import ch.vanessen.menu.domain.Recipe;
import ch.vanessen.menu.domain.Unit;
import ch.vanessen.menu.entities.IngredientEntity;
import ch.vanessen.menu.entities.RecipeEntity;
import ch.vanessen.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class RecipePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipePlannerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MenuRepository menuRepository) {
		return args -> {
			Stream.of("Lasagne", "Bolo", "Rice", "Spaghetti", "Pommes").forEach(name -> {
				Recipe recipe = new Recipe(name, name.toLowerCase(), "https://image-url.com", List.of(new Ingredient("Tomato", "The big ones", Unit.PIECE, 5)));

//				menuRepository.save(recipe);
			});
			menuRepository.findAll().forEach(s -> log.info(s.toString()));
		};
	}

}
