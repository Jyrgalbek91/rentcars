package kg.mega.rent_cars.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.mega.rent_cars.model.OrderDetails;
import kg.mega.rent_cars.model.Price;
import kg.mega.rent_cars.model.enums.Category;
import kg.mega.rent_cars.model.enums.Color;
import kg.mega.rent_cars.model.enums.EngineType;
import kg.mega.rent_cars.model.enums.Transmission;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CarDTO {
    private Long id;
    private String model;
    private String photo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate mnfYear;
    private Color color;
    private Double engineVolume;
    private EngineType engineType;
    private Transmission transmission;
    private Integer gasPer100;
    private Category category;
    private Boolean isAvailable;
}
