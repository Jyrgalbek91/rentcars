package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO savePrice(PriceDTO priceDTO);
    PriceDTO updatePrice(PriceDTO priceDTO);
    List<PriceDTO> findAllPrice();
    void deletePrice(Long id);
}
