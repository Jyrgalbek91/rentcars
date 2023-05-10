package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.DiscountMapper;
import kg.mega.rent_cars.model.Discount;
import kg.mega.rent_cars.model.dto.DiscountDTO;
import kg.mega.rent_cars.repository.CarDao;
import kg.mega.rent_cars.repository.DiscountDao;
import kg.mega.rent_cars.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DiscountServiceImpl implements DiscountService {
    private final DiscountDao discountRepo;
    private final CarDao carRepo;
    @Override
    public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
        Discount discount = DiscountMapper.INSTANCE.toEntity(discountDTO);
        discount.setCar(carRepo.findById(discountDTO.getCar().getId()).get());
        discount.setStartDate(LocalDate.now());
        discount.setEndDate(LocalDate.now().plusMonths(6));
        Discount discountSave = discountRepo.save(discount);
        return DiscountMapper.INSTANCE.toDTO(discountSave);
    }

    @Override
    public DiscountDTO updateDiscount(DiscountDTO discountDTO) {
        Discount discount = discountRepo.findById(discountDTO.getId()).get();
        discount.setDiscount(discountDTO.getDiscount());
        discount.setStartDate(discountDTO.getStartDate());
        discount.setEndDate(discountDTO.getEndDate());
        Discount discountUpdate = discountRepo.save(discount);
        return DiscountMapper.INSTANCE.toDTO(discountUpdate);
    }

    @Override
    public List<DiscountDTO> findAllDiscount() {
        return DiscountMapper.INSTANCE.toDTOList(discountRepo.findAll());
    }

    @Override
    public void deleteDiscount(Long id) {
        Discount discount = discountRepo.findById(id).get();
        discountRepo.delete(discount);
    }

}
