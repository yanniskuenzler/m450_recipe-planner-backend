package ch.vanessen.menu.repository;


import ch.vanessen.menu.entities.Menu;
import org.springframework.data.repository.CrudRepository;


public interface MenuRepository extends CrudRepository<Menu, Long> {
}
