package com.example.mois_user.repository;

import com.example.mois_user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable pageable);

    @Query("FROM User u WHERE u.firstName LIKE %:searchText% OR u.lastName LIKE %:searchText%")
    Page<User> findAll(Pageable pageable, @Param("searchText") String searchText);

    User save(User user);

}