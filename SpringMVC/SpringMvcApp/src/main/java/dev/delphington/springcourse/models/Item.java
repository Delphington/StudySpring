package dev.delphington.springcourse.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;


    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person owner;
    @Column(name = "item_name")
    String itemName;

    @Override
    public String toString() {
        return "Item{" +
               "id=" + id +
               ", ownerId=" + owner.getId() +
               ", itemName='" + itemName + '\'' +
               '}';
    }
}
