package ru.coursework.demo1.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.coursework.demo1.Domain.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {
    Order findOrdersById(Long id);
    Iterable<Order> findAllByUserid(Long userid);
}
