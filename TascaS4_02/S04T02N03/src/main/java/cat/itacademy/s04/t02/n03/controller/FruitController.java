package cat.itacademy.s04.t02.n03.controller;

import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<String> addFruit(@RequestBody Fruit fruit) {
        Fruit newFruit;
        newFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok().body("New fruit successfully added to the database.\nName: " + newFruit.getName() + ", Quantity in kilos: " + newFruit.getQuantityKg());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") int id) {
        return ResponseEntity.ok(fruitService.getFruitById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruit(@PathVariable("id") int id, @RequestBody Fruit fruit) {
        Fruit fruitFound;
        fruitFound = fruitService.getFruitById(id);
        fruitFound.setName(fruit.getName());
        fruitFound.setQuantityKg(fruit.getQuantityKg());
        fruitService.addFruit(fruitFound);
        return ResponseEntity.ok().body("The fruit with id " + id + " has been successfully updated." +
                "\nName: " + fruitFound.getName() + ", Quantity in kilos: " + fruitFound.getQuantityKg());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruitById(@PathVariable("id") int id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.ok().body("The fruit with id " + id + " has been successfully deleted.");
    }

}
