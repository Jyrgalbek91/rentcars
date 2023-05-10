package kg.mega.rent_cars.mapper;

import kg.mega.rent_cars.model.Address;
import kg.mega.rent_cars.model.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    Address toEntity(AddressDTO addressDTO);
    AddressDTO toDTO(Address address);
    List<Address> toEntityList(List<AddressDTO> addressDTOList);
    List<AddressDTO> toDTOList(List<Address> addressList);
}
