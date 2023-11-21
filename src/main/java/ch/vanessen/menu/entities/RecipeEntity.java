package ch.vanessen.menu.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "RECIPES")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    @OneToMany(mappedBy="recipe")
    private Set<IngredientEntity> ingredients;

    public RecipeEntity(String name, String description, String imageUrl, Set<IngredientEntity> ingredients) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
    }

    public RecipeEntity() {

    }
}
