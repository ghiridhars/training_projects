package com.mindtree.personPassport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.personPassport.entity.Passport;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Integer>{

}
