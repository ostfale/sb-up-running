package de.ostfale.sb.restdemo.repository;

import de.ostfale.sb.restdemo.domain.Coffee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Java"),
                new Coffee("Cafe Crema"),
                new Coffee("Cafe Schwyzer Schümli"),
                new Coffee("Cafe Lareno")
        ));
    }
}
