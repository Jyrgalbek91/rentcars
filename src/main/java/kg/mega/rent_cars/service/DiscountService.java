package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    DiscountDTO saveDiscount(DiscountDTO discountDTO);
    DiscountDTO updateDiscount(DiscountDTO discountDTO);
    List<DiscountDTO> findAllDiscount();
    void deleteDiscount(Long id);
}
