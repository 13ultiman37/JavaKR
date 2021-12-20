package ru.coursework.demo1.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long master_id;

    private String master_name;
    private String speciality;
}
