package ch.vanessen.menu.controller;

import ch.vanessen.menu.domain.Recipe;
import ch.vanessen.menu.entities.RecipeEntity;
import ch.vanessen.menu.mapper.RecipeEntityMapper;
import ch.vanessen.menu.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.157:3000"})
public class RecipeController {

    private final RecipeRepository recipeRepository;

    private final RecipeEntityMapper mapper;

    public RecipeController(RecipeRepository recipeRepository, RecipeEntityMapper mapper) {
        this.recipeRepository = recipeRepository;
        this.mapper = mapper;
    }

    @GetMapping("/api/recipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        var recipes = recipeRepository.findAll();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/api/recipes/recipe/{recipeId}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable UUID recipeId) {
        return new ResponseEntity<>(mapper.entityToDomain(recipeRepository.findById(recipeId).get()), HttpStatus.OK);
    }

    @PostMapping(value = "/api/recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        var createdRecipe = recipeRepository.save(mapper.domainToEntity(recipe));
        return new ResponseEntity<>(mapper.entityToDomain(createdRecipe), HttpStatus.OK);
    }

}
