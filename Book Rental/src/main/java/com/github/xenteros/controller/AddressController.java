package com.github.xenteros.controller;

import com.github.xenteros.model.Address;
import com.github.xenteros.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {


    private static Logger LOG = LoggerFactory.getLogger(AddressController.class);

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

    @GetMapping
    public Set<Address> findAll() {

        LOG.trace("A TRACE Message");
        LOG.debug("A DEBUG Message");
        LOG.info("An INFO Message");
        LOG.warn("A WARN Message");
        LOG.error("An ERROR Message");

        return addressService.findAll();
    }

    @GetMapping("/{city}_{state}")
    public Set<Address> findAllByCityAndState(@PathVariable String city,
                                              @PathVariable String state) {
        return addressService.findAllByCityAndState(city, state);
    }
}
