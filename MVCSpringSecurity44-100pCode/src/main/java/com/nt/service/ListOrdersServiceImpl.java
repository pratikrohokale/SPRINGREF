package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListOrdersServiceImpl implements ListOrdersService {
   
	@Override
	public List<String> getOrders() {
	   List<String> orders=null;
	   orders=new ArrayList();
	   orders.add("watch");
	   orders.add("mobile");
	   orders.add("shirt");
       return orders;
	}

}
