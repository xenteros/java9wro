package com.github.xenteros.service.impl;

import com.github.xenteros.model.Address;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AddressServiceImpl {

    private Map<Long, Address> addressMap = new ConcurrentHashMap<>();

}
