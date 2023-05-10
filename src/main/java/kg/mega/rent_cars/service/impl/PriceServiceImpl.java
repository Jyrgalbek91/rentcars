package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.PriceMapper;
import kg.mega.rent_cars.model.Price;
import kg.mega.rent_cars.model.dto.PriceDTO;
import kg.mega.rent_cars.repository.CarDao;
import kg.mega.rent_cars.repository.PriceDao;
import kg.mega.rent_cars.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PriceServiceImpl implements PriceService {
    private final PriceDao priceRepo;
    private final CarDao carRepo;
    @Override
    public PriceDTO savePrice(PriceDTO priceDTO) {
        Price price = PriceMapper.INSTANCE.toEntity(priceDTO);
        price.setCar(carRepo.findById(priceDTO.getCar().getId()).get());
        price.setStartDate(LocalDate.now());
        price.setEndDate(LocalDate.now().plusYears(10));
        Price priceSave = priceRepo.save(price);
        return PriceMapper.INSTANCE.toDTO(priceSave);
    }

    @Override
    public PriceDTO updatePrice(PriceDTO priceDTO) {
        Price price = priceRepo.findById(priceDTO.getId()).get();
        price.setPrice(priceDTO.getPrice());
        price.setStartDate(priceDTO.getStartDate());
        price.setEndDate(priceDTO.getEndDate());
        Price priceUpdate = priceRepo.save(price);
        return PriceMapper.INSTANCE.toDTO(priceUpdate);
    }

    @Override
    public List<PriceDTO> findAllPrice() {
        return PriceMapper.INSTANCE.toDTOList(priceRepo.findAll());
    }

    @Override
    public void deletePrice(Long id) {
        Price price = priceRepo.findById(id).get();
        priceRepo.delete(price);
    }

}
