package kg.mega.rent_cars.service.impl;

import kg.mega.rent_cars.mapper.AddressMapper;
import kg.mega.rent_cars.model.Address;
import kg.mega.rent_cars.model.dto.AddressDTO;
import kg.mega.rent_cars.repository.AddressDao;
import kg.mega.rent_cars.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressDao addressRepo;
    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toEntity(addressDTO);
        Address addressSave = addressRepo.save(address);
        return AddressMapper.INSTANCE.toDTO(addressSave);
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        Address address = addressRepo.findById(addressDTO.getId()).get();
        address.setCity(addressDTO.getCity());
        address.setStreet(address.getStreet());
        address.setBuildingNum(addressDTO.getBuildingNum());
        return AddressMapper.INSTANCE.toDTO(address);
    }

    @Override
    public List<AddressDTO> findAllAddress() {
        return AddressMapper.INSTANCE.toDTOList(addressRepo.findAll());
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepo.findById(id).get();
        addressRepo.delete(address);
    }
}
