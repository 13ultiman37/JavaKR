package ru.coursework.demo1.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coursework.demo1.Repository.OrderRepo;
import ru.coursework.demo1.Repository.SearchRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Search {
    @Autowired
    private SearchRepo repo;

    public List<Order> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Order order){
        repo.save(order);
    }
}