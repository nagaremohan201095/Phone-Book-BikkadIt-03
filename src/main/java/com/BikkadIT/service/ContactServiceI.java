package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Contact;

public interface ContactServiceI {

	boolean save(Contact contact);
	
	List<Contact> getAllContact();
}
