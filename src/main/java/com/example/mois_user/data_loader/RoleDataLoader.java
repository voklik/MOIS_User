package com.example.mois_user.data_loader;

import com.example.mois_user.domain.Role;
import com.example.mois_user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadContactData();
    }

    private void loadContactData() {
        if (roleRepository.count() == 0) {
            Role role1 = new Role( 1l, "ADMIN");
            Role role2 = new Role(2l, "USER");
            roleRepository.save(role1);
            roleRepository.save(role2);
        }
        System.out.println(roleRepository.count());
    }

}