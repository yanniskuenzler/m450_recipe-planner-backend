package ch.vanessen.menu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity(name = "RECIPES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String description;
    private String imageUrl;
//    @OneToMany(mappedBy="recipe")
//    private Set<IngredientEntity> ingredients;

}
