package com.example.mois_user.service;

import com.example.mois_user.domain.Role;
import com.example.mois_user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        return roleRepository.findByNameEquals(name);
    }
}
