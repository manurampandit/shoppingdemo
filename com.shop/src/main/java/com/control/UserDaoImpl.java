package com.control;
import java.util.ArrayList;  
import java.util.List;  

import javax.sql.DataSource;  

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
  
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {  
  
 @Autowired  
 DataSource dataSource;  
  
 public void insertData(User user) {  
  super.getSqlSession().insert("User.insertUser", user);
 }  
  
 public List<User> getUserList() {  
	 return super.getSqlSession().selectList("User.getUserList");
 }  
  
 @Override  
 public void deleteData(String id) {  
   super.getSqlSession().delete("User.deleteUser", id);
 }  
  
 @Override  
 public void updateData(User user) {  
//  
//  String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";  
//  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
//  
//  jdbcTemplate.update(  
//    sql,  
//    new Object[] { user.getFirstName(), user.getLastName(),  
//      user.getGender(), user.getCity(), user.getUserId() });  
//  
 }  
  
 @Override  
 public User getUser(String id) {  
  List<User> userList = new ArrayList<User>();  
  String sql = "select * from users where user_id= " + id;  
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
  userList = jdbcTemplate.query(sql, new UserRowMapper());  
  return userList.get(0);  
 }  
  
}  