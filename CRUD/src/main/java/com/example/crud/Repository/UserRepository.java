package com.example.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
