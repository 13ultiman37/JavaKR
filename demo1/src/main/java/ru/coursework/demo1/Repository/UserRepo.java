package ru.coursework.demo1.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.coursework.demo1.Domain.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
