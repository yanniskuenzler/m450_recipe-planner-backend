package ch.vanessen.menu.domain;


import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Recipe {

    private String name;
    private String description;
    private String imageUrl;
    private List<Ingredient> ingredients;
}
