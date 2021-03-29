package de.ostfale.sb.restdemo.controller;

import de.ostfale.sb.restdemo.domain.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {

    private final List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Cafe Java"),
                new Coffee("Cafe Crema"),
                new Coffee("Cafe Schwyzer Schümli"),
                new Coffee("Cafe Lareno")
        ));
    }

    // @RequestMapping(value = "/coffees", method = RequestMethod.GET)
    @GetMapping()
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping()
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee aCoffee) {
        int coffeeIndex = -1;

        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(coffee);
                coffees.set(coffeeIndex, aCoffee);
            }
        }
        return (coffeeIndex == -1) ?
                new ResponseEntity<>(postCoffee(aCoffee), HttpStatus.CREATED) :
                new ResponseEntity<>(aCoffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }
}
