package com.vm.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.audit.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
