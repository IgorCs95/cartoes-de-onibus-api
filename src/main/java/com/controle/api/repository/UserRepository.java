package com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.api.entities.User;

public interface UserRepository  extends JpaRepository<User,Long>{

}
