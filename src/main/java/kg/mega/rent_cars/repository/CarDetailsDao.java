package kg.mega.rent_cars.repository;

import kg.mega.rent_cars.model.Car;
import kg.mega.rent_cars.model.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarDetailsDao extends JpaRepository<CarDetails, Long> {
    Optional<CarDetails> findByCar(Car car);
}
