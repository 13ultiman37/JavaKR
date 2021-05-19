package ru.coursework.demo1.Domain;
import lombok.Data;


@Data
public class OrderForm {
    private long id;
    private String brand;
    private String model;
    private String request;
    private String notification;
    private String email;
    private String name;
    private String phone;
    private long userid;

    public Order toOrder(User user){
        Order order = new Order();
        order.setBrand(brand);
        order.setModel(model);
        order.setRequest(request);
        order.setNotification(notification);
        order.setEmail(user.getEmail());
        order.setName(user.getName());
        order.setPhone(user.getPhone());
        order.setUserid(user.getId());
        return order;
    }
}
