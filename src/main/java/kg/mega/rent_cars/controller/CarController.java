package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.CarDTO;
import kg.mega.rent_cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;
    @PostMapping("/save")
    public CarDTO saveCar(@RequestBody CarDTO carDTO){
        return carService.saveCar(carDTO);
    }
    @PutMapping("/update")
    public CarDTO updateCar(@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }
    @GetMapping("/find_all")
    public List<CarDTO> findAll(){
        return carService.findAllCar();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        carService.deleteCar(id);
    }
}
