package services;

import exceptions.InvalidCarException;
import exceptions.InvalidOrderException;
import models.Car;
import models.Order;
import repositories.CarRepository;
import repositories.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order insertOrder(Order order){
        if (order.getSuma() == null || order.getData() == null) {
            throw new InvalidOrderException("Invalid order!");
        }
        return orderRepository.saveOrder(order);
    }

    public Order updateOrder(Order order){
        if (order.getSuma() == null || order.getData() == null) {
            throw new InvalidOrderException("Invalid order!");
        }
        return orderRepository.updateOrder(order);
    }


    public String listAllOrders() {
        return orderRepository.findAll().toString();
    }
}
