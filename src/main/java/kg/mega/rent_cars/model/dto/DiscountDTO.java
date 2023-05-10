package kg.mega.rent_cars.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rent_cars.model.Car;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountDTO {
    private Long id;
    private Double discount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    private Integer daysCount;
    private Car car;
}
