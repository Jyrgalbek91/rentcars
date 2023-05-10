package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.CarMapper;
import kg.mega.rent_cars.model.Car;
import kg.mega.rent_cars.model.dto.CarDTO;
import kg.mega.rent_cars.repository.CarDao;
import kg.mega.rent_cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private final CarDao carRepo;
    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.toEntity(carDTO);
        Car carSave = carRepo.save(car);
        return CarMapper.INSTANCE.toDTO(carSave);
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        Car car = carRepo.findById(carDTO.getId()).get();
        car.setModel(carDTO.getModel());
        car.setMnfYear(carDTO.getMnfYear());
        car.setColor(carDTO.getColor());
        car.setPhoto(carDTO.getPhoto());
        car.setCategory(carDTO.getCategory());
        car.setEngineType(carDTO.getEngineType());
        car.setEngineVolume(carDTO.getEngineVolume());
        car.setTransmission(carDTO.getTransmission());
        car.setGasPer100(carDTO.getGasPer100());
        car.setIsAvailable(carDTO.getIsAvailable());
        Car updateCar = carRepo.save(car);
        return CarMapper.INSTANCE.toDTO(updateCar);
    }


    @Override
    public List<CarDTO> findAllCar() {
        return CarMapper.INSTANCE.toDTOList(carRepo.findAll());
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepo.findById(id).get();
        carRepo.delete(car);
    }
}
