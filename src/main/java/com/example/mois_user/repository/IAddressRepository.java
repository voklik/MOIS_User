package com.example.mois_user.repository;

import com.example.mois_user.domain.Address;

public interface IAddressRepository {
    Address getAddressById(long id);
}
