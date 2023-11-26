package ch.vanessen.menu.mapper;

import ch.vanessen.menu.domain.Ingredient;
import ch.vanessen.menu.entities.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonMapperConfig.class)
public interface IngredientEntityMapper {

    Ingredient entityToDomain(IngredientEntity ingredientEntity);

    IngredientEntity domainToEntity(Ingredient ingredient);

    List<Ingredient> entitiesToDomains(List<IngredientEntity> ingredientEntities);
    List<IngredientEntity> domainsToEntities(List<Ingredient> ingredients);
}
