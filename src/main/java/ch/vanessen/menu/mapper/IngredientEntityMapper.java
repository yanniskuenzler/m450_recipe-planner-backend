package ch.vanessen.menu.mapper;

import ch.vanessen.menu.domain.Ingredient;
import ch.vanessen.menu.entities.IngredientEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface IngredientEntityMapper {

    Ingredient entityToDomain(IngredientEntity ingredientEntity);

    IngredientEntity domainToEntity(Ingredient ingredient);
}
