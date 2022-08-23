package com.BikkadIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
