package modelsDAO;

import models.Car;
import models.Client;
import models.Combustibil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDAO {

    Client saveClient (Client client);

    void removeClient(Client client);

    Client updateClient(Client client);


        Optional<Client> findByIdClient(UUID id_client);



        Optional<Client> findByNume(String nume);

        Optional<Client> findByCNP(String CNP);

        Optional<Client> findByTelefon(Integer telefon);

        List<Client> findAll();
    }


