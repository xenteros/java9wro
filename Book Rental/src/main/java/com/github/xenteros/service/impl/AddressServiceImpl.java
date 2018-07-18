package com.github.xenteros.service.impl;

import com.github.xenteros.model.Address;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Set<Address> findAllByCityAndState(String city, String state) {
        return addressRepository.findAllByCityAndState(city, state);
    }

    @Override
    public void create(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Set<Address> findAll() {
        return addressRepository.findAllBy();
    }
}
