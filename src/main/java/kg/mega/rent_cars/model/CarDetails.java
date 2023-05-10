package kg.mega.rent_cars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_car_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Car car;
    @ElementCollection
    List<LocalDate> reservedDates;

}

