package com.github.xenteros.service;

import com.github.xenteros.model.Address;

import java.util.Set;

public interface AddressService {


    Set<Address> findAllByCityAndState(String city, String state);
    void create(Address address);
    Set<Address> findAll();
}
