package com.example.mois_user.data_loader;

import com.example.mois_user.domain.Role;
import com.example.mois_user.domain.User;
import com.example.mois_user.payload.request.SignUpRequest;
import com.example.mois_user.repository.RoleRepository;
import com.example.mois_user.repository.UserRepository;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

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
            SignUpRequest signUpRequest = new SignUpRequest();
            signUpRequest.setEmail("admin@admin.cz");
            signUpRequest.setFirstName("Admin");
            signUpRequest.setLastName("Admin");
            signUpRequest.setPassword("admin1");
            signUpRequest.setCity("HK");
            signUpRequest.setPostCode("500 06");
            signUpRequest.setStreet("nejaka, 21");
            signUpRequest.setPhoneNumber("123456789");
            List<User> user = userRepository.findAll();
            userService.createUser(signUpRequest, true);

        }
        System.out.println(roleRepository.count());
    }

}