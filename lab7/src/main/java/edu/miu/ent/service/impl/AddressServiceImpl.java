package edu.miu.ent.service.impl;


import edu.miu.ent.dto.AddressRequest;
import edu.miu.ent.dto.AddressResponse;
import edu.miu.ent.model.Address;
import edu.miu.ent.repository.AddressRepository;
import edu.miu.ent.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressResponse createNewAddress(AddressRequest addressRequest){
        var address = new Address();
        address.setAddress(addressRequest.address());
        address.setCity(addressRequest.city());
        address.setState(addressRequest.state());
        address.setZip(addressRequest.zip());
        var savedAddress = addressRepository.save(address);
        return new AddressResponse(
                savedAddress.getAddressId(),
                savedAddress.getAddress(),
                savedAddress.getCity(),
                savedAddress.getState(),
                savedAddress.getZip()
        );
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        return addressRepository.findAll().stream().
                map(a -> new AddressResponse(
                        a.getAddressId(),
                        a.getAddress(),
                        a.getCity(),
                        a.getState(),
                        a.getZip()
                )).toList();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean deleteAddress(Integer id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
