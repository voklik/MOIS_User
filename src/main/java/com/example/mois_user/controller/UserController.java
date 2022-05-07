package com.example.mois_user.controller;

import com.example.mois_user.domain.Role;
import com.example.mois_user.domain.User;
import com.example.mois_user.dto.UserDTO;
import com.example.mois_user.security.JwtTokenProvider;
import com.example.mois_user.service.CustomUserDetailsService;
import com.example.mois_user.service.RoleService;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.example.mois_user.domain.util.Role.ADMIN_ROLE;
import static com.example.mois_user.domain.util.Role.USER_ROLE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final JwtTokenProvider jwtTokenProvider;

    @PutMapping("/inactive/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> inactiveUser(@PathVariable long id) {

        User user = userService.getUserById(id);
        user.setActive(!user.isActive());
        userService.updateUser(user);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/switch-role/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> switchRole(@PathVariable long id) {

        User user = userService.getUserById(id);
        Role role;
        if (user.getRole().getName().equals(ADMIN_ROLE)) {
            role = roleService.getRoleByName(USER_ROLE);
        } else {
            role = roleService.getRoleByName(ADMIN_ROLE);
        }
        user.setRole(role);
        userService.updateUser(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping(params = {"page", "size", "sortBy", "search", "sortAsc"})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<UserDTO>> getAllUsers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size,
            @RequestParam(name = "search", defaultValue = "") String searchText,
            @RequestParam(name = "sortBy", defaultValue = "lastName") String sortBy,
            @RequestParam(name = "sortAsc", defaultValue = "true") boolean sortAsc) {

        Sort sort = Sort.by(sortBy).ascending();
        if (!sortAsc)
            sort = sort.descending();

        return new ResponseEntity<>(userService.getAllUsers(
                PageRequest.of(page, size, sort),
                searchText
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        if (!userDTO.getId().equals(id)) {
            throw new IllegalArgumentException("IDs don't match");
        }

        User user = userService.updateUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/verify")
    public Boolean verifyUser(@RequestHeader("Authorization") String token) {
        return jwtTokenProvider.validateToken(token);
    }
}