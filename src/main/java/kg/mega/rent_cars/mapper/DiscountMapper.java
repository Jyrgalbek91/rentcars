package kg.mega.rent_cars.mapper;

import kg.mega.rent_cars.model.Discount;
import kg.mega.rent_cars.model.dto.DiscountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
    Discount toEntity(DiscountDTO discountDTO);
    DiscountDTO toDTO(Discount discount);
    List<Discount> toEntityList(List<DiscountDTO> discountDTOList);
    List<DiscountDTO> toDTOList(List<Discount> discountList);
}
