import jdk.jshell.spi.ExecutionControl;
import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import repositories.CarRepository;
import repositories.ClientRepository;
import repositories.OrderRepository;
import services.CarService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("task.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Car c1 = new Car("BH82AMD", "VW", 100000, Transmisie.MANUALA, Combustibil.DIESEL,null, null);
        Car c2 = new Car("AR12AAA", "BMW", 200000,Transmisie.AUTOMATA, Combustibil.BENZINA, null, null);
        Car c3 = new Car("TM12MMM", "AUDI", 75620, Transmisie.AUTOMATA, Combustibil.GAZ, null, null);
        Car c4 = new Car("B01BUC","FORD", 123123, Transmisie.MANUALA, Combustibil.HIBRID, null, null);
        Car c5 = new Car("SB10AAA","VW", 10000, Transmisie.MANUALA, Combustibil.CURENT, null, null);

        EntityManager entityManager = sessionFactory.createEntityManager();

        CarRepository carRepository = new CarRepository(entityManager, entityManager.getTransaction());

        carRepository.saveCar(c1);
        carRepository.saveCar(c2);
        carRepository.saveCar(c3);
        carRepository.saveCar(c4);
        carRepository.saveCar(c5);

        CarService carService = new CarService(carRepository);

       insertCarExample(carService);




        ClientRepository clientRepository = new ClientRepository(entityManager);

        Client client1 = new Client("Alex", "1751227051100",0744555666, "Romania",null, null);
        Client client2 = new Client("Adi", "1761227051100",0744555667, "Romania",null, null);
        Client client3 = new Client("Alin", "1771227051100",0745124124, "Romania",null, null);
        Client client4 = new Client("Balint", "1781227051100",0732123123, "Romania",null, null);
        Client client5 = new Client("Kalman", "1791227051100",0747474747, "Ungaria",null, null);
        Client client6 = new Client("Motzart", "1801227051100",0770123123, "Germania",null, null);


        clientRepository.saveClient(client1);
        clientRepository.saveClient(client2);
        clientRepository.saveClient(client3);
        clientRepository.saveClient(client4);
        clientRepository.saveClient(client5);
        clientRepository.saveClient(client6);


        OrderRepository orderRepository = new OrderRepository(entityManager, entityManager.getTransaction());
        Order order = new Order();

        Order order1 = new Order(1111.50, LocalDate.of(2024, 1, 11), null, null);
        Order order2 = new Order(1112.50, LocalDate.of(2024, 1, 12), null, null);
        Order order3 = new Order(1113.50, LocalDate.of(2024, 1, 13), null, null);
        Order order4 = new Order(1114.50, LocalDate.of(2024, 1, 14), null, null);
        Order order5 = new Order(1115.50, LocalDate.of(2024, 1, 15), null, null);
        Order order6 = new Order(1116.50, LocalDate.of(2024, 1, 16), null, null);
        Order order7 = new Order(1117.50, LocalDate.of(2024, 1, 17), null, null);


        orderRepository.saveOrder(order1);
        orderRepository.saveOrder(order2);
        orderRepository.saveOrder(order3);
        orderRepository.saveOrder(order4);
        orderRepository.saveOrder(order5);
        orderRepository.saveOrder(order6);
        orderRepository.saveOrder(order7);
    }



    private static void insertCarExample(CarService carService) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Numar inmatriculare: ");
        String nrInmatriculare = scanner.nextLine();

        System.out.println("Model masina: ");
        String model = scanner.nextLine();

        System.out.println("Kilometraj masina: ");
        Integer kilometraj = scanner.nextInt();

        System.out.println("Employee address street: ");
        String street = scanner.nextLine();

        System.out.println("Transmisie (MANUALA,\n" +
                "    AUTOMATA;): ");
        String transmisieInput = scanner.next();
        Transmisie transmisie = Transmisie.valueOf(transmisieInput.toUpperCase());

        System.out.println("Combustibil (BENZINA,\n" +
                "    DIESEL,\n" +
                "    HIBRID,\n" +
                "    GAZ,\n" +
                "    CURENT;): ");
        String combusitbilInput = scanner.next();
        Combustibil combustibil = Combustibil.valueOf(combusitbilInput.toUpperCase());



        Car carInsert = new Car();

        carInsert.setNrInmatriculare(nrInmatriculare);
        carInsert.setModel(model);
        carInsert.setKilometraj(kilometraj);
        carInsert.setTransmisie(transmisie);
        carInsert.setCombustibil(combustibil);


        carService.insertCar(carInsert);

    }
}
