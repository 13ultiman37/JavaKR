package ru.coursework.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.coursework.demo1.Domain.Order;

import java.util.List;

public interface SearchRepo extends JpaRepository <Order, Long> {
    @Query("SELECT p FROM Order p WHERE CONCAT(p.request, ' ', p.brand, ' ', p.model) LIKE %?1%")
    public List<Order> findAll (String keyword);
}
