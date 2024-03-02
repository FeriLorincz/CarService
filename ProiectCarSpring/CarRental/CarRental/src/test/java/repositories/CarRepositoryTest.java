package repositories;

import models.*;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    private static EntityManager entityManager;
    private static CarRepository carRepository;

    @BeforeAll
    static void beforeAll() {
        entityManager = new Configuration()
                .configure("task.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory()
                .createEntityManager();
        carRepository = new CarRepository(entityManager, entityManager.getTransaction());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveCar() {
        Car car = carRepository.saveCar(new Car("BH11TTT", "Golf", 125589, Transmisie.MANUALA, Combustibil.CURENT, null, null));
        assertNotNull(car.getNrInmatriculare());
    }

    @Test
    void removeCar() {
        Car car = carRepository.saveCar(new Car("BH11TTT", "Golf", 125589, Transmisie.MANUALA, Combustibil.CURENT, null, null));

        carRepository.removeCar(car);
        Optional<Car> updatedCar = carRepository.findBynrInmatriculare("BH123");
        assertFalse(updatedCar.isPresent());
    }

    @Test
    void updateCar() {
        Car c1 = new Car("BH82AMD", "VW", 100000, Transmisie.MANUALA, Combustibil.DIESEL,null, null);

        c1.setKilometraj(150000);
        Car car = carRepository.updateCar(c1);

        Optional<Car> updatedCar = carRepository.findBynrInmatriculare("BH82AMD");
        assertTrue(updatedCar.isPresent());
        assertEquals(150000, updatedCar.get().getKilometraj());
    }

    @Test
    void findBynrInmatriculare() {
        Car c1 = carRepository.saveCar(new Car("BH82AMD", "VW", 100000, Transmisie.MANUALA, Combustibil.DIESEL,null, null));

        Optional<Car> car = carRepository.findBynrInmatriculare("BH82AMD");
        assertTrue(car.isPresent());
       // assertEquals(car.get(findBynrInmatriculare(), c1.getNrInmatriculare(car));
        //assertEquals(c1.getId(), car.get().getId());
    }

    @Test
    void findByKilometraj() {
    }

    @Test
    void findByModel() {
    }

    @Test
    void findByCombustibil() {
    }

    @Test
    void findAll() {
    }
}