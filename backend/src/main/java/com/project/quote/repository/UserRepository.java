package com.project.quote.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 

    public  Optional<User> findByName(String name);

    

    public boolean existsByName(String name);



  



}