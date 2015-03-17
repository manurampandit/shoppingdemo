package com.control;

public interface OrdersDao {  
	public void insertData(int itemId, int orderId);
	public void insertDataAdd(int itemId, int orderId);
	public void insertData(Orders order);
}  