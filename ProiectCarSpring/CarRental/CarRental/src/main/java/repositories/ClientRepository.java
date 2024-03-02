package repositories;

import models.Car;
import models.Client;
import modelsDAO.ClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientRepository implements ClientDAO {

    private EntityManager entityManager;

    public ClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Client saveClient(Client client) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(client);
            transaction.commit();
            return client;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public void removeClient(Client client) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(client);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public Client updateClient(Client client) {

        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Client newClient = entityManager.merge(client);
            transaction.commit();
            return newClient;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public Optional<Client> findByIdClient(UUID id_client) {
        return Optional.ofNullable(entityManager.find(Client.class, id_client));
    }


    @Override
    public Optional<Client> findByNume(String nume) {
        return Optional.ofNullable(entityManager.find(Client.class, nume));
    }

    @Override
    public Optional<Client> findByCNP(String CNP) {
        return Optional.ofNullable(entityManager.find(Client.class, CNP));
    }

    @Override
    public Optional<Client> findByTelefon(Integer telefon) {
        return Optional.ofNullable(entityManager.find(Client.class, telefon));
    }

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
