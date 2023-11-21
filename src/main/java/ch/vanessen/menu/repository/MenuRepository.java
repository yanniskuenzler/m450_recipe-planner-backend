package ch.vanessen.menu.repository;


import ch.vanessen.menu.entities.RecipeEntity;
import org.springframework.data.repository.CrudRepository;


public interface MenuRepository extends CrudRepository<RecipeEntity, Long> {
}
