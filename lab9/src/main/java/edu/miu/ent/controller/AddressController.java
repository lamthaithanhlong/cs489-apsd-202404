package edu.miu.ent.controller;


import edu.miu.ent.dto.AddressRequest;
import edu.miu.ent.dto.AddressResponse;
import edu.miu.ent.model.Address;
import edu.miu.ent.service.AddressService;
import edu.miu.ent.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + "/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid AddressRequest addressRequest){
        return ResponseEntity.ok(addressService.createNewAddress(addressRequest));
    }
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddresses(){
        return ResponseEntity.ok(addressService.getAllAddresses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        address.setAddressId(id);
        Address updatedAddress = addressService.updateAddress(address);
        if (updatedAddress != null) {
            return ResponseEntity.ok(updatedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        boolean deleted = addressService.deleteAddress(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
