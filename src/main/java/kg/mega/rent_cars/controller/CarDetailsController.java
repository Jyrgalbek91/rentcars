package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.CarDetailsDTO;
import kg.mega.rent_cars.service.CarDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car_details")
public class CarDetailsController {
    private final CarDetailsService carDetailsService;
    @PostMapping("/save")
    public CarDetailsDTO saveCarDetails(@RequestBody CarDetailsDTO carDetailsDTO){
        return carDetailsService.saveCarDetails(carDetailsDTO);
    }
    @PutMapping("/update")
    public CarDetailsDTO updateCarDetails(@RequestBody CarDetailsDTO carDetailsDTO){
        return carDetailsService.updateCarDetails(carDetailsDTO);
    }

    @GetMapping("/find_all")
    public List<CarDetailsDTO> findAll(){
        return carDetailsService.findAllActive();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        carDetailsService.deleteCarDetails(id);
    }
}
