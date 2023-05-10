package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.OrderDetailsDTO;
import kg.mega.rent_cars.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;
    @PostMapping("/save")
    public OrderDetailsDTO save(@RequestBody OrderDetailsDTO orderDetailsDTO){
        return orderDetailsService.saveOrder(orderDetailsDTO);
    }
    @PutMapping("/update")
    public OrderDetailsDTO update(@RequestBody OrderDetailsDTO orderDetailsDTO){
        return orderDetailsService.updateOrder(orderDetailsDTO);
    }
    @GetMapping("/find_all")
    public List<OrderDetailsDTO> findAll(){
        return orderDetailsService.findAllOrder();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        orderDetailsService.deleteOrder(id);
    }
}
