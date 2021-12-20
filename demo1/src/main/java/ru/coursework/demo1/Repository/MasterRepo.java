package ru.coursework.demo1.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.coursework.demo1.Domain.Master;

public interface MasterRepo extends CrudRepository <Master, Long> {

}
