package kg.mega.rent_cars.service;

import kg.mega.rent_cars.model.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDTO saveAddress(AddressDTO addressDTO);
    AddressDTO updateAddress(AddressDTO addressDTO);
    List<AddressDTO> findAllAddress();
    void deleteAddress(Long id);

}
