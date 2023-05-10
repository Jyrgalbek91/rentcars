package kg.mega.rent_cars.model.dto;

import kg.mega.rent_cars.model.Car;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CarDetailsDTO {
    Long id;
    Car car;
    List<LocalDate> reservedDates;
}
