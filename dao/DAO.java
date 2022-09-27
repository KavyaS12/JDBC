package com.sample.project.dao;

import java.util.List;
import com.sample.project.model.Buyer;

public interface DAO {
	//List<T> list();
	//Optional<T> getbyNo(String contactno);
	//void create(T obj);
	Buyer getbyNumber(String contactno);
    Buyer saveBuyer(Buyer buyer);
    Buyer updateBuyer(Buyer buyer);
    String deleteBuyer(String contactno);
    List<Buyer> allBuyers();
	Buyer getbyName(String name);
    
}
