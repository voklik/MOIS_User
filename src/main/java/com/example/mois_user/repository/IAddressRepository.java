package com.example.mois_user.repository;

import com.example.mois_user.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    Address getAddressById(long id);
}
