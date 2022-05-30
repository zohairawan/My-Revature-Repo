package com.project1.training.revature.dao;

import com.project1.training.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
