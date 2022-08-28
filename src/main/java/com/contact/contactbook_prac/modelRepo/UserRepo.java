package com.contact.contactbook_prac.modelRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.contactbook_prac.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    
    
}
