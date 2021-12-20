package ru.coursework.demo1.Domain;
import lombok.Data;


@Data
public class OrderForm {
    private long id;
    private String brand;
    private String model;
    private String request;
    private String notification;
    private long master_id;
    private long userid;

    public Order toOrder(User user){
        Order order = new Order();
        order.setBrand(brand);
        order.setModel(model);
        order.setRequest(request);
        order.setNotification(notification);
        order.setMaster_id(0);

        order.setUserid(user.getId());
        return order;
    }
}
