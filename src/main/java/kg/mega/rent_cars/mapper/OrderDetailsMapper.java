package kg.mega.rent_cars.mapper;

import kg.mega.rent_cars.model.OrderDetails;
import kg.mega.rent_cars.model.dto.OrderDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);
    OrderDetails toEntity(OrderDetailsDTO orderDetailsDTO);
    OrderDetailsDTO toDTO(OrderDetails orderDetails);
    List<OrderDetails> toEntityList(List<OrderDetailsDTO> orderDetailsDTOList);
    List<OrderDetailsDTO> toDTOList(List<OrderDetails> orderDetailsList);
}
