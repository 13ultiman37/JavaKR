package ru.coursework.demo1.Domain;
import lombok.Data;


@Data
public class OrderForm {
    private long id;
    private String brand;
    private String model;
    private String request;
    private String notification;

    public Order toOrder(){
        Order order = new Order();
        order.setBrand(brand);
        order.setModel(model);
        order.setRequest(request);
        order.setNotification(notification);

        return order;
    }
}
