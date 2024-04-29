package edu.miu.ent.service;

import edu.miu.ent.dto.AddressRequest;
import edu.miu.ent.dto.AddressResponse;
import edu.miu.ent.model.Address;

import java.util.List;

public interface AddressService {
    AddressResponse createNewAddress(AddressRequest addressRequest);
    List<AddressResponse> getAllAddresses();

    Address getAddressById(Integer id);

    Address updateAddress(Address address);

    boolean deleteAddress(Integer id);
}