package ch.vanessen.menu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String description;
    @Lob
    private byte[] pictureData;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Menu() {
        this.name = "";
        this.description = "";
    }
}
