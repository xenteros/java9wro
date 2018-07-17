package com.github.xenteros.controller;

import com.github.xenteros.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @GetMapping
    public Set<Address> getAllAddresses() {
        return Collections.emptySet();
    }

}
