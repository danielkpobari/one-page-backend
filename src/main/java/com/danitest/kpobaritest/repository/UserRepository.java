package com.danitest.kpobaritest.repository;


import com.danitest.kpobaritest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
