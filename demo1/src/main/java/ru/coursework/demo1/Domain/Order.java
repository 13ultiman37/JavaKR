package ru.coursework.demo1.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String request;
    private boolean completed;
    private String name;
    private String phone;
    private String email;
    private String notification;
    private long userid;
}
