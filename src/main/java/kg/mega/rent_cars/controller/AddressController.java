package kg.mega.rent_cars.controller;

import kg.mega.rent_cars.model.dto.AddressDTO;
import kg.mega.rent_cars.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;
    @PostMapping("/save")
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO){
        return addressService.saveAddress(addressDTO);
    }
    @PutMapping("/update")
    public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO){
        return addressService.updateAddress(addressDTO);
    }
    @GetMapping("/find_all")
    public List<AddressDTO> findAll(){
        return addressService.findAllAddress();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        addressService.deleteAddress(id);
    }
}
