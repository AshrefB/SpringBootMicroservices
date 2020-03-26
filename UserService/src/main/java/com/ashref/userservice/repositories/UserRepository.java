package com.ashref.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashref.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
