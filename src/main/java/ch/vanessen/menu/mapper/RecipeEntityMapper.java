package ch.vanessen.menu.mapper;

import ch.vanessen.menu.domain.Recipe;
import ch.vanessen.menu.entities.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class)
public interface RecipeEntityMapper {

    Recipe entityToDomain(RecipeEntity recipeEntity);

    RecipeEntity domainToEntity(Recipe recipe);


}
