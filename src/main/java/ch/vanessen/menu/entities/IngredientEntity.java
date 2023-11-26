package ch.vanessen.menu.entities;

import ch.vanessen.menu.domain.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="INGREDIENTS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private int amount;
}
