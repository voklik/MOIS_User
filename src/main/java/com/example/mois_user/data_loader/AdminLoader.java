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
public class AdminLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (!userRepository.findByEmail("admin@admin.cz").isPresent()) {
            //User user1 = new User(1l, "admin@admin.cz", "admin1", "Admin", "Admin", "123456789", true, 1l, 1l);
            //User user2 = new User(2l,);
            //userRepository.save(user1);
            //userRepository.save(user2);
            /*SignUpRequest signUpRequest = new SignUpRequest();*/
            /*signUpRequest.setEmail("admin@admin.cz");*/
            /*signUpRequest.setFirstName("Admin");*/
            /*signUpRequest.setLastName("Admin");*/
            /*signUpRequest.setPassword("admin1");*/
            /*signUpRequest.setCity("HK");*/
            /*signUpRequest.setPostCode("500 06");*/
            /*signUpRequest.setStreet("nejaka, 21");*/
            /*signUpRequest.setPhoneNumber("123456789");*/
            /*List<User> user = userRepository.findAll();*/
            /*userService.createUser(signUpRequest, true);*/
        }
        System.out.println(userRepository.count());
    }
}
