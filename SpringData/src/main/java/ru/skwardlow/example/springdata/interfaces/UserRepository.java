package ru.skwardlow.example.springdata.interfaces;

import org.springframework.data.repository.CrudRepository;
import ru.skwardlow.example.springdata.entities.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByFio(String fio);
}
