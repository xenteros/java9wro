package com.github.xenteros.repository;

import com.github.xenteros.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    Set<Address> findAllByState(String state);
    Set<Address> findAllBy();
    Set<Address> findAllByCity(String city);
    Set<Address> findAllByCityAndState(String city, String state);
    Address findTop1ByOrderByCity();
}
