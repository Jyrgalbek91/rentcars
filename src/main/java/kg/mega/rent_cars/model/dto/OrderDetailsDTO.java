package kg.mega.rent_cars.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rent_cars.model.Address;
import kg.mega.rent_cars.model.Car;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailsDTO {
    private Long id;
    private Car car;
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private Address getAddress;
    private Address returnAddress;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTimeTo;
    private Double priceBeforeDiscount;
    private Double priceWithDiscount;
}
