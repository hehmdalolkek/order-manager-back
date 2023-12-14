package com.hehmdalolkek.spring.ordermanagerback.dao;

import com.hehmdalolkek.spring.ordermanagerback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
