package services;

import exceptions.InvalidCarException;
import exceptions.InvalidClientException;
import models.Car;
import models.Client;
import repositories.CarRepository;
import repositories.ClientRepository;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client insertClient(Client client){
        if (client.getNume() == null || client.getCNP() == null) {
            throw new InvalidClientException("Invalid client!");
        }
        return clientRepository.saveClient(client);
    }

    public Client updateCar(Client client){
        if (client.getNume() == null || client.getCNP() == null) {
            throw new InvalidClientException("Invalid client!");
        }
        return clientRepository.updateClient(client);
    }

    public String listAllClient() {
        return clientRepository.findAll().toString();
    }

}
