package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.CarDetailsDTO;

import java.util.List;

public interface CarDetailsService {
    CarDetailsDTO saveCarDetails(CarDetailsDTO carDetailsDTO);
    CarDetailsDTO updateCarDetails(CarDetailsDTO carDetailsDTO);
    List<CarDetailsDTO> findAllActive();
    void deleteCarDetails(Long id);

}
