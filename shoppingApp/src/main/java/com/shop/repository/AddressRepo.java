package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
