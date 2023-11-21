package ch.vanessen.menu.entities;

import ch.vanessen.menu.domain.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name="INGREDIENTS")
@AllArgsConstructor
public class IngredientEntity {

    @Id
    private Long id;
    private String name;
    private String comment;
    private Unit unit;
    private int amount;
    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    private RecipeEntity recipeEntity;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
