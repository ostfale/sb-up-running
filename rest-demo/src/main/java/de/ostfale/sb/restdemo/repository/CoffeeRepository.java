package de.ostfale.sb.restdemo.repository;

import de.ostfale.sb.restdemo.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
