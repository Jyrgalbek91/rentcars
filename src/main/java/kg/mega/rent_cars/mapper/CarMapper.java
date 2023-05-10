package kg.mega.rent_cars.mapper;

import kg.mega.rent_cars.model.Car;
import kg.mega.rent_cars.model.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    Car toEntity(CarDTO carDTO);
    CarDTO toDTO(Car car);
    List<Car> toEntityList(List<CarDTO> carDTOList);
    List<CarDTO> toDTOList(List<Car> carList);
}
