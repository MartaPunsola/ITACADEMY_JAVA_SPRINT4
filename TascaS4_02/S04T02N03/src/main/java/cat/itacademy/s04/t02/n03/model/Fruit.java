package cat.itacademy.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fruit")
public class Fruit {

    @Id
    private int id;

    @Field(name = "fruit_name")
    private String name;

    @Field(name = "kg")
    private int quantityKg;

    public Fruit() {
    }

    public Fruit(int id, String name, int quantityKg) {
        this.id = id;
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKg=" + quantityKg +
                '}';
    }

}
