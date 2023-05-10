package kg.mega.rent_cars.model.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String city;
    private String street;
    private Integer buildingNum;
}
