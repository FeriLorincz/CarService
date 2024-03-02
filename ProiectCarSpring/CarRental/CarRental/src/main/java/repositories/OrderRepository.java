package repositories;


import lombok.AllArgsConstructor;
import models.Client;
import models.Order;
import modelsDAO.OrderDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@AllArgsConstructor
public class OrderRepository implements OrderDAO {

    private EntityManager entityManager;
    EntityTransaction transaction = null;

    public OrderRepository(EntityManager entityManager, EntityTransaction transaction) {
        this.entityManager = entityManager;
        this.transaction = transaction;
    }


    @Override
    public Order saveOrder(Order order) {
        // EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

        @Override
        public void removeOrder (Order order){
            // EntityTransaction transaction = null;
            try {
                transaction = entityManager.getTransaction();
                if (!transaction.isActive()) {
                    transaction.begin();
                }

                entityManager.remove(order);
                transaction.commit();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }


    @Override
    public Order updateOrder(Order order) {
        //EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }
            Order newOrder = entityManager.merge(order);
            transaction.commit();
            return newOrder;
        } catch (Exception e){
            System.err.println(e.getMessage());
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public Optional<Order> findByIdComanda(UUID id_comanda) {
        return Optional.ofNullable(entityManager.find(Order.class, id_comanda));
    }

    @Override
    public Optional<Order> findBySuma(Double suma) {
        return Optional.ofNullable(entityManager.find(Order.class, suma));
    }

    @Override
    public Optional<Order> findByData(LocalDate data) {
        return Optional.ofNullable(entityManager.find(Order.class, data));
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
