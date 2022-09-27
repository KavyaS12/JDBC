package com.sample.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.project.ExceptionResponse.BuyerAlreadyExists;
import com.sample.project.ExceptionResponse.BuyerNotFoundException;
import com.sample.project.dao.DAO;
import com.sample.project.model.Buyer;
import static com.sample.project.constants.ExceptionMSG.*;
import static com.sample.project.constants.ReturnMSG.*;
@Service
public class ServiceBuyer {
	@Autowired
	private DAO daobuyer;
	//List allbuyers
	
	public List<Buyer> allBuyers()
	{
		List<Buyer> buyerList=daobuyer.allBuyers();
		return buyerList;
	}
	//List specific buyer by contact_no
	public Buyer  getbyNumber(String contactno)
	{
		Buyer buyerByNo=daobuyer.getbyNumber(contactno);
		 System.out.println("*************"+buyerByNo);
		 if(buyerByNo==null)
      	       throw new BuyerNotFoundException(BUYER_NOT_FOUND_BY_NO+ " " + contactno);
         
      	  return buyerByNo;
		
	}
	//List specific buyer by name
	public Buyer  getbyName(String name)
	{
		 Buyer buyerByName=daobuyer.getbyName(name);
		 if(buyerByName==null)
			 
      	       throw new BuyerNotFoundException(BUYER_NOT_FOUND_BY_NAME+ " " + name);
         
      	  return buyerByName;
		
	}
	//Adding buyer
	public Buyer createBuyer(Buyer buyer) 
	{
		
		Buyer buyerAdd=null; 
		String contactno=buyer.getContactno();
		Buyer existing_buyer=daobuyer.getbyNumber(contactno);
		
		if(existing_buyer==null)
		{
			 buyerAdd=daobuyer.saveBuyer(buyer);
			
			
		}
		else
			throw new BuyerAlreadyExists(EXISTING_BUYER+" "+contactno);
		
		
		return  buyerAdd;
	}
	//Update buyer
	public Buyer updateBuyer(Buyer buyer)
	{   Buyer buyerUpd=null;
		Buyer existing_buyer=daobuyer.getbyNumber(buyer.getContactno());
	    
	    if(existing_buyer!=null)
	    {
	    	buyerUpd=daobuyer.updateBuyer(buyer);
	    }
		//Buyer buyerUpdate=daobuyer.updateBuyer(buyer);
	    else
	    	throw new BuyerNotFoundException(BUYER_NOT_FOUND_BY_NO+ " " +buyer.getContactno());
		return buyerUpd;
	}
	 
	//Delete buyer
	public String deleteBuyer(String contactno)
	{    
	  
		Buyer existing_buyer=daobuyer.getbyNumber(contactno);
		
		if(existing_buyer!=null)
		{
			daobuyer.deleteBuyer(contactno);
			
		}
		else
			throw new BuyerNotFoundException(BUYER_NOT_FOUND_BY_NO+ " " + contactno);
		
		return DELETED_BUYER+" "+contactno;
	}
	}
	
	
	

