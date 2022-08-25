package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Contact;
import com.BikkadIT.service.ContactServiceI;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value ="saveContact",consumes = "application/json" )
   public ResponseEntity<String> save(@RequestBody Contact contact){
	
		boolean saveContact = contactServiceI.save(contact);
	   
		if(saveContact==true) {
		
			String msg="Contact save Successfully";
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else {
			String msg="Contact not save Successfully";
	   
	   return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	   
	   
	   }
	
    }
	
	@GetMapping(value = "/getAllContact",produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		
		List<Contact> allContact = contactServiceI.getAllContact();
		if(allContact !=null) {
			
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
	
		}
		
	 else {
			String msg="Contact not found";
			
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/getContactById/{cid}",produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cid){
		
		Contact contactById = contactServiceI.getContactById(cid);
		
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		
		}
      

@PutMapping(value ="/updateContact",consumes = "application/json" )
public ResponseEntity<String> updateContact(@RequestBody  Contact contact){
	
		boolean saveContact = contactServiceI.updateContact(contact);
	   
		if(saveContact==true) {
		
			String msg="Contact update Successfully";
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else {
			String msg="Contact not update Successfully";
	   
	   return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	   
		}
}


      @DeleteMapping(value = "/deleteContactById/{cid}")
    public ResponseEntity<String> deleteContactById(@PathVariable Integer cid){
    	
    	boolean deleteById = contactServiceI.deleteById(cid);
    	
    	if(deleteById) {
    		
    		return new ResponseEntity<String>("Record delete sucessfully",HttpStatus.OK);
    		
    	}else {
    		
    		return new ResponseEntity<String>("Record not delete successfully",HttpStatus.BAD_REQUEST);
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   }
   }
}
