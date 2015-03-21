package com.control.service.impl;
import org.springframework.beans.factory.annotation.Autowired;

import com.control.dao.AddressDao;
import com.control.dao.OrdersDao;
import com.control.objects.Address;
import com.control.objects.Items;
import com.control.objects.Orders;
import com.control.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {  

	@Autowired  
	OrdersDao ordersDao;
	@Autowired
	AddressDao addressDao;
	
	@Override
	public void insertData(Items item, Address address) {
		addressDao.insertData(address);
		Orders order = new Orders();
		item.setItemId(2);
		ordersDao.insertData(order);
		ordersDao.insertData(item.getItemId(), order.getOrderId());
		ordersDao.insertDataAdd(address.getAddressId(), order.getOrderId());
		
	}  
}  