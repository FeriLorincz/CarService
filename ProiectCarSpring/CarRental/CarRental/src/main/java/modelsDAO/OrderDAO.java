package modelsDAO;

import models.Car;
import models.Client;
import models.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDAO {

    Order saveOrder (Order order);

    void removeOrder(Order order);

    Order updateOrder(Order order);


    Optional<Order> findByIdComanda(UUID id_comanda);

    Optional<Order> findBySuma(Double suma);

    Optional<Order> findByData(LocalDate data);


    List<Client> findAll();

}
