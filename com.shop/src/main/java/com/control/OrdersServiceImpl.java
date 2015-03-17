package com.control;
import org.springframework.beans.factory.annotation.Autowired;

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