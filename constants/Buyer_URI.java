package com.sample.project.constants;
import org.springframework.stereotype.Component;
@Component
public class Buyer_URI {
	private Buyer_URI() {
		// TODO Auto-generated constructor stub
	}
	public static final String BUYER_DETAILS="/buyerdetails/";
	public static final String BUYER_DETAILS_BY_NO="/buyerdetails/{contactno}";
	public static final String BUYER_DETAILS_BY_NAME="/buyerdetails/name/{name}";
	public static final String BUYER_DETAILS_ADD="/buyerdetails/add";
	public static final String BUYER_DETAILS_UPD_BY_NO="/buyerdetails/{contactno}";
	public static final String BUYER_DETAILS_DEL_BY_NO="/buyerdetails/{contactno}";


}





