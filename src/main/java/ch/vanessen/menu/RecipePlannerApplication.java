package ch.vanessen.menu;

import ch.vanessen.menu.domain.Ingredient;
import ch.vanessen.menu.domain.Recipe;
import ch.vanessen.menu.domain.Unit;
import ch.vanessen.menu.mapper.RecipeEntityMapper;
import ch.vanessen.menu.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class RecipePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipePlannerApplication.class, args);
	}

	@Autowired
	RecipeEntityMapper mapper;

	@Bean
	CommandLineRunner init(RecipeRepository recipeRepository) {
		return args -> {
			Stream.of("Lasagne", "Bolo", "Rice", "Spaghetti", "Pommes").forEach(name -> {
				Recipe recipe = new Recipe(UUID.randomUUID(), name, name.toLowerCase(), "https://image-url.com", List.of(new Ingredient(UUID.randomUUID(), "Tomato", "The big ones", Unit.PIECE, 5)));
				var entity = mapper.domainToEntity(recipe);
				recipeRepository.save(entity);
			});
			recipeRepository.findAll().forEach(s -> log.info(s.toString()));
		};
	}

}
