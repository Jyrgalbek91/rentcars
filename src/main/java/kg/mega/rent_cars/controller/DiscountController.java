package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.DiscountDTO;
import kg.mega.rent_cars.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discount")
public class DiscountController {
    private final DiscountService discountService;
    @PostMapping("/save")
    public DiscountDTO saveDiscount(@RequestBody DiscountDTO discountDTO){
        return discountService.saveDiscount(discountDTO);
    }
    @PutMapping("/update")
    public DiscountDTO updateDiscount(@RequestBody DiscountDTO discountDTO){
        return discountService.updateDiscount(discountDTO);
    }
    @GetMapping("/find_all")
    public List<DiscountDTO> findAll(){
        return discountService.findAllDiscount();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        discountService.deleteDiscount(id);
    }
}
