package kg.mega.rent_cars.mapper;

import kg.mega.rent_cars.model.CarDetails;
import kg.mega.rent_cars.model.dto.CarDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDetailsMapper {
    CarDetailsMapper INSTANCE = Mappers.getMapper(CarDetailsMapper.class);
    CarDetails toEntity(CarDetailsDTO carDetailsDTO);
    CarDetailsDTO toDTO(CarDetails carDetails);
    List<CarDetails> toEntityList(List<CarDetailsDTO> carDetailsDTOList);
    List<CarDetailsDTO> toDTOList(List<CarDetails> carDetails);

}
