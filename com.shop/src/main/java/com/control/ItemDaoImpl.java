package com.control;
import java.util.ArrayList;  
import java.util.List;  

import javax.sql.DataSource;  

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
  
public class ItemDaoImpl extends SqlSessionDaoSupport implements ItemDao {  
  
 @Autowired  
 DataSource dataSource;  
  
 public List<Items> getItemList() {  
	 return super.getSqlSession().selectList("Items.getItemList");
 }  
 
 public List<Items> getItemDetails(int itemId) {  
	 return super.getSqlSession().selectList("Items.getItemDetails",itemId);
 }
  

}  