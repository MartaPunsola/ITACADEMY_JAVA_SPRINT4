package cat.itacademy.s04.t02.n01.service;

import cat.itacademy.s04.t02.n01.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit) throws FruitAlreadyExistsException {
        if(fruitRepository.existsByName(fruit.getName())) {
            throw new FruitAlreadyExistsException("The fruit " + fruit.getName() + " is already registered.");
        }
        return fruitRepository.save(fruit);
    }

    public Fruit getFruitById(int id) throws FruitNotFoundException {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isEmpty()) {
            throw new FruitNotFoundException("Fruit with id " + id + " not found.");
        }
        return optionalFruit.get();
    }

    public List<Fruit> getAllFruits() throws FruitNotFoundException {
        List<Fruit> fruits = fruitRepository.findAll();
        if(fruits.isEmpty()) {
            throw new FruitNotFoundException("There are no fruits at the moment.");
        }
        return fruits;
    }

    public void deleteFruit(int id) throws FruitNotFoundException{
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isEmpty()) {
            throw new FruitNotFoundException("Fruit with id " + id + " not found.");
        }
        fruitRepository.deleteById(id);
    }

}
