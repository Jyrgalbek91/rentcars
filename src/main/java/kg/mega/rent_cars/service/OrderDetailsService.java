package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailsDTO saveOrder(OrderDetailsDTO orderDetailsDTO);
    OrderDetailsDTO updateOrder(OrderDetailsDTO orderDetailsDTO);
    List<OrderDetailsDTO> findAllOrder();
    void deleteOrder(Long id);
}
