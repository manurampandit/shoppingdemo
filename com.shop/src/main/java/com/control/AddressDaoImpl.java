package com.control;
import javax.sql.DataSource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressDaoImpl extends SqlSessionDaoSupport implements AddressDao {  

	@Autowired  
	DataSource dataSource;  

	public void insertData(Address address) {  
		super.getSqlSession().insert("Orders.addAddress", address);
	}  


}  