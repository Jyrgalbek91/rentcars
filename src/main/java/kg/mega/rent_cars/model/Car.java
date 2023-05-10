package kg.mega.rent_cars.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rent_cars.model.enums.Category;
import kg.mega.rent_cars.model.enums.Color;
import kg.mega.rent_cars.model.enums.EngineType;
import kg.mega.rent_cars.model.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tb_car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String photo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate mnfYear;
    @Enumerated(value = EnumType.STRING)
    private Color color;
    private Double engineVolume;
    @Enumerated(value = EnumType.STRING)
    private EngineType engineType;
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;
    private Integer gasPer100;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private Boolean isAvailable;


}
