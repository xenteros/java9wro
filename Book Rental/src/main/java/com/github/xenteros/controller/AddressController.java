package com.github.xenteros.controller;

import com.github.xenteros.model.Address;
import com.github.xenteros.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void create(@RequestParam String street,
                       @RequestParam String city,
                       @RequestParam String state) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);

        addressService.create(address);
    }
}
