package services;

import exceptions.InvalidCarException;
import repositories.CarRepository;
import models.*;

import javax.persistence.EntityTransaction;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car insertCar(Car car){
        if (car.getKilometraj() == null || car.getCombustibil() == null) {
            throw new InvalidCarException("Invalid car!");
        }
        return carRepository.saveCar(car);
    }

    public Car updateCar(Car car){
        if (car.getKilometraj() == null || car.getCombustibil() == null) {
            throw new InvalidCarException("Invalid car!");
        }
        return carRepository.updateCar(car);
    }


    public String listAllCars() {
        return carRepository.findAll().toString();
    }
}
