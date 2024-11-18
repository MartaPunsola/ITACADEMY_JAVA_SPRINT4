package cat.itacademy.s04.t02.n02.service;

import cat.itacademy.s04.t02.n02.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n02.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n02.model.Fruit;
import java.util.List;

public interface FruitService {

    Fruit addFruit(Fruit fruit) throws FruitAlreadyExistsException;
    Fruit getFruitById(int id);
    List<Fruit> getAllFruits() throws FruitNotFoundException;
    Fruit updateFruit(int id, Fruit fruit);
    void deleteFruit(int id);
}
