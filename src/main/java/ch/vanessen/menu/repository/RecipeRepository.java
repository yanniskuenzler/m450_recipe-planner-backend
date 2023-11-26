package ch.vanessen.menu.repository;


import ch.vanessen.menu.entities.RecipeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findById(UUID id);

}
