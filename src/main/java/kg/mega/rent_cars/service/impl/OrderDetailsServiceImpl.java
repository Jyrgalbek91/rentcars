package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.OrderDetailsMapper;
import kg.mega.rent_cars.model.CarDetails;
import kg.mega.rent_cars.model.Discount;
import kg.mega.rent_cars.model.OrderDetails;
import kg.mega.rent_cars.model.Price;
import kg.mega.rent_cars.model.dto.OrderDetailsDTO;
import kg.mega.rent_cars.repository.*;
import kg.mega.rent_cars.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsDao orderDetailsRepo;
    private final CarDao carRepo;
    private final AddressDao addressRepo;
    private final PriceDao priceRepo;
    private final DiscountDao discountRepo;
    private final CarDetailsDao carDetailsRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderDetailsDTO saveOrder(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = OrderDetailsMapper.INSTANCE.toEntity(orderDetailsDTO);
        orderDetails.setCar(carRepo.findById(orderDetailsDTO.getCar().getId()).get());
        orderDetails.setGetAddress(addressRepo.findById(orderDetailsDTO.getGetAddress().getId()).get());
        orderDetails.setReturnAddress(addressRepo.findById(orderDetailsDTO.getReturnAddress().getId()).get());

        long duration = orderDetails.getDateTimeTo().getDayOfMonth() - orderDetails.getDateTimeFrom().getDayOfMonth();

        Price price = priceRepo.findByCar_Id(orderDetails.getCar().getId());
        Double carPrice = price.getPrice();
        Double beforeTotalPrice = carPrice * duration;
        orderDetails.setPriceBeforeDiscount(beforeTotalPrice);

        Double totalPrice = null;
        Discount applicableDiscount = null;

        List<Discount> discounts = discountRepo.findByCar_Id(orderDetails.getCar().getId());
        for (Discount d : discounts){
            if (duration >= d.getDaysCount()){
                applicableDiscount = d;
            }
        }
        if (applicableDiscount != null) {
            Double carDiscount = applicableDiscount.getDiscount();
            totalPrice = beforeTotalPrice - ((beforeTotalPrice * carDiscount) / 100);
        } else {
            totalPrice = beforeTotalPrice;
        }
        orderDetails.setPriceWithDiscount(totalPrice);


        CarDetails carDetails = carDetailsRepo.findByCar(orderDetails.getCar())
                .orElse(new CarDetails(null, orderDetails.getCar(), new ArrayList<>()));


        // сохраняем обновленный объект CarDetails в базе данных
        entityManager.merge(carDetails);


        OrderDetails orderDetailsSave = orderDetailsRepo.save(orderDetails);
        return OrderDetailsMapper.INSTANCE.toDTO(orderDetailsSave);
    }

//    public List<LocalDate> getDates(LocalDate dateTimeTo, LocalDate dateTimeFrom){
//        long numOfDays = ChronoUnit.DAYS.between(dateTimeTo, dateTimeFrom) + 1;
//        return IntStream.iterate(0,i -> i + 1)
//                .limit(numOfDays)
//                .mapToObj(dateTimeTo :: plusDays)
//                .collect(Collectors.toList());
//    }


    @Override

    public OrderDetailsDTO updateOrder(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepo.findById(orderDetailsDTO.getId()).get();
        orderDetails.setBabySeat(orderDetailsDTO.getBabySeat());
        orderDetails.setWithDriver(orderDetailsDTO.getWithDriver());
        orderDetails.setClientName(orderDetailsDTO.getClientName());
        orderDetails.setClientPhone(orderDetailsDTO.getClientPhone());
        orderDetails.setClientEmail(orderDetailsDTO.getClientEmail());
        orderDetails.setDateTimeFrom(orderDetailsDTO.getDateTimeFrom());
        orderDetails.setDateTimeTo(orderDetailsDTO.getDateTimeTo());
        orderDetails.setPriceBeforeDiscount(orderDetailsDTO.getPriceBeforeDiscount());
        orderDetails.setPriceWithDiscount(orderDetailsDTO.getPriceWithDiscount());
        OrderDetails orderDetailsUpdate = orderDetailsRepo.save(orderDetails);
        return OrderDetailsMapper.INSTANCE.toDTO(orderDetailsUpdate);
    }

    @Override
    public List<OrderDetailsDTO> findAllOrder() {
        return OrderDetailsMapper.INSTANCE.toDTOList(orderDetailsRepo.findAll());
    }

    @Override
    public void deleteOrder(Long id) {
        OrderDetails orderDetails = orderDetailsRepo.findById(id).get();
        orderDetailsRepo.delete(orderDetails);
    }

}
