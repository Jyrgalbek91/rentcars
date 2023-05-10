package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.PriceDTO;
import kg.mega.rent_cars.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/price")
public class PriceController {
    private final PriceService priceService;
    @PostMapping("/save")
    public PriceDTO save(@RequestBody PriceDTO priceDTO){
        return priceService.savePrice(priceDTO);
    }
    @PutMapping("/update")
    public PriceDTO update(@RequestBody PriceDTO priceDTO){
        return priceService.updatePrice(priceDTO);
    }
    @GetMapping("/find_all")
    public List<PriceDTO> findAll(){
        return priceService.findAllPrice();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        priceService.deletePrice(id);
    }
}
