package com.example.mois_user.client;

import com.example.mois_user.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@FeignClient(name = "user-client")
public interface UserClient {

    @GetMapping("/{id}")
    ResponseEntity<Optional<User>> getUser(@PathVariable Long id);
}
