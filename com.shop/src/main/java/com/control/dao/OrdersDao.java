package com.control.dao;

import com.control.objects.Orders;

public interface OrdersDao {  
	public void insertData(int itemId, int orderId);
	public void insertDataAdd(int itemId, int orderId);
	public void insertData(Orders order);
}  