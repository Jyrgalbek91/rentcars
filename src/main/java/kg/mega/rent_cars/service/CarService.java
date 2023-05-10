package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO saveCar(CarDTO carDTO);
    CarDTO updateCar(CarDTO carDTO);
    List<CarDTO> findAllCar();
    void deleteCar(Long id);
}
