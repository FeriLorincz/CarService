package repositories;

import models.Combustibil;
import modelsDAO.CarDAO;
import lombok.AllArgsConstructor;
import models.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class CarRepository implements CarDAO {

    private EntityManager entityManager;
    EntityTransaction transaction = null;

    @Override
    public Car saveCar(Car car){
       // EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if(! transaction.isActive()){
                transaction.begin();
            }

            entityManager.persist(car);
            transaction.commit();
            return car;
        } catch (Exception e){
            System.err.println(e.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
            return  null;
        }
    }

    @Override
    public void removeCar(Car car){
       // EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }

            entityManager.remove(car);
            transaction.commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Car updateCar(Car car){
        //EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }
            Car newCar = entityManager.merge(car);
            transaction.commit();
            return newCar;
        } catch (Exception e){
            System.err.println(e.getMessage());
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public Optional<Car> findBynrInmatriculare(String nrInmatriculare) {
        return Optional.ofNullable(entityManager.find(Car.class, nrInmatriculare));
    }

    @Override
    public Optional<Car> findByKilometraj(Integer kilometraj){
        return Optional.ofNullable(entityManager.find(Car.class, kilometraj));
    }

    @Override
    public Optional<Car> findByModel(String model){
        return Optional.ofNullable(entityManager.find(Car.class, model));
    }

    public Optional<Car> findByCombustibil(Combustibil combustibil){
        return Optional.ofNullable(entityManager.find(Car.class, combustibil));
    }

    @Override
    public List<Car> findAll(){
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }


}
