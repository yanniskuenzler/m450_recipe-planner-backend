package ch.vanessen.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Ingredient {

    private String name;
    private String comment;
    private Unit unit;
    private int amount;

}
