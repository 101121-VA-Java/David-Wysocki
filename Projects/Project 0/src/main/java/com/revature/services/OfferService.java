package com.revature.services;

import java.util.List;

import com.revature.models.Bird;
import com.revature.models.Offers;
import com.revature.repositories.OfferDao;
import com.revature.repositories.OfferPostgres;

public class OfferService {
private static OfferDao od = new OfferPostgres();

public static Offers submitoffer(Offers o) {
	
	return od.add(o);
	
}
public static List<Offers> getAll(){
	return od.getAll();
	
}
public static boolean update(Offers o) {
	return od.update(o);
	
}
}
