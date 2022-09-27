package com.sample.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.project.model.Buyer;
import com.sample.project.service.ServiceBuyer;
import static com.sample.project.constants.Buyer_URI.*;
@RestController
public class BuyerController {
	 @Autowired
     private ServiceBuyer servicebuyer;
    
     public BuyerController(ServiceBuyer servicebuyer)
     {
    	 this.servicebuyer=servicebuyer;
     }
          
          @GetMapping(BUYER_DETAILS)
          public List<Buyer> list()
            {   
        	    List<Buyer> buyerlist=servicebuyer.allBuyers();
            	return buyerlist;
            }
          @GetMapping(BUYER_DETAILS_BY_NO)
          public Buyer  getbyNumber(@PathVariable String contactno)
          {     
        	  Buyer buyerByNo=servicebuyer.getbyNumber(contactno);
        	  return buyerByNo;
          }
          @GetMapping(BUYER_DETAILS_BY_NAME)
          public Buyer  getbyName(@PathVariable String name)
          {     
        	  Buyer buyerByName=servicebuyer.getbyName(name);
        	  return buyerByName;
          }
          @PostMapping(BUYER_DETAILS_ADD)
    	   public Buyer addBuyer(@RequestBody Buyer buyer)
    	   {   
        	  Buyer addBuyer=servicebuyer.createBuyer(buyer);
    		  return addBuyer;
    	   }
          @PutMapping(BUYER_DETAILS_UPD_BY_NO)
          public Buyer updateBuyer(@RequestBody Buyer buyer)
    	   {   
        	   Buyer updateBuyer=servicebuyer.updateBuyer(buyer);
    		   return updateBuyer;
    	   }
          @DeleteMapping(BUYER_DETAILS_DEL_BY_NO)
          public String deleteUser(@PathVariable String contactno)
          { 
              String deleteBuyer=servicebuyer.deleteBuyer(contactno);
        	  return deleteBuyer;
          }
}      
