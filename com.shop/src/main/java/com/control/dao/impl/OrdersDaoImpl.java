package com.control.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.control.dao.OrdersDao;
import com.control.objects.Orders;

public class OrdersDaoImpl extends SqlSessionDaoSupport implements OrdersDao {  

	@Autowired  
	DataSource dataSource;  

	public void insertData(Orders order) {  
		super.getSqlSession().insert("Orders.addOrder", order);
	}  

	public void insertData(int itemId, int orderId){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("itemId", itemId);
		map.put("orderId", orderId);
		super.getSqlSession().insert("Orders.orderDet",map);
	}
	
	public void insertDataAdd(int addressId, int orderId){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("addressId", addressId);
		map.put("orderId", orderId);
		super.getSqlSession().insert("Orders.orderDetAdd",map);
	}
}  