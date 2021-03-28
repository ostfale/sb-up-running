package de.ostfale.sb.restdemo.controller;

import de.ostfale.sb.restdemo.domain.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
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
    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/coffee/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee aCoffee) {
        int coffeeIndex = -1;

        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(coffee);
                coffees.set(coffeeIndex, aCoffee);
            }
        }
        return (coffeeIndex == -1) ? postCoffee(aCoffee) : aCoffee;
    }

    @DeleteMapping("/coffee/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }
}
