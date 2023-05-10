package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.CarDetailsMapper;
import kg.mega.rent_cars.model.CarDetails;
import kg.mega.rent_cars.model.dto.CarDetailsDTO;
import kg.mega.rent_cars.repository.CarDao;
import kg.mega.rent_cars.repository.CarDetailsDao;
import kg.mega.rent_cars.repository.OrderDetailsDao;
import kg.mega.rent_cars.service.CarDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarDetailsServiceImpl implements CarDetailsService {
    private final CarDetailsDao carDetailsRepo;
    private final OrderDetailsDao orderDetailsRepo;
    private final CarDao carRepo;


    @Override
    public CarDetailsDTO saveCarDetails(CarDetailsDTO carDetailsDTO) {
        CarDetails carDetails = CarDetailsMapper.INSTANCE.toEntity(carDetailsDTO);
        carDetails.setCar(carRepo.findById(carDetailsDTO.getCar().getId()).get());
        carDetails.setReservedDates(carDetailsDTO.getReservedDates());
        CarDetails carDetailsSave = carDetailsRepo.save(carDetails);
        return CarDetailsMapper.INSTANCE.toDTO(carDetailsSave);
    }



    @Override
    public CarDetailsDTO updateCarDetails(CarDetailsDTO carDetailsDTO) {
        CarDetails carDetails = carDetailsRepo.findById(carDetailsDTO.getId()).get();
        carDetails.setCar(carDetailsDTO.getCar());
        carDetails.setReservedDates(carDetails.getReservedDates());
        return CarDetailsMapper.INSTANCE.toDTO(carDetails);
    }

    @Override
    public List<CarDetailsDTO> findAllActive() {
        return CarDetailsMapper.INSTANCE.toDTOList(carDetailsRepo.findAll());
    }

    @Override
    public void deleteCarDetails(Long id) {
        CarDetails carDetails = carDetailsRepo.findById(id).get();
        carDetailsRepo.delete(carDetails);
    }
}
