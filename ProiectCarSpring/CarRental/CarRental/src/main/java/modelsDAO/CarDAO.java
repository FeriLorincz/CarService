package modelsDAO;

import models.Car;
import models.Combustibil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDAO {

    Car saveCar(Car car);

    void removeCar(Car car);

    Car updateCar(Car car);

    Optional<Car> findBynrInmatriculare(String nrInmatriculare);

    Optional<Car> findByKilometraj(Integer kilometraj);

    Optional<Car> findByModel(String model);

    Optional<Car> findByCombustibil(Combustibil combustibil);

    List<Car> findAll();
}
