package com.control.dao;
import java.util.List;  

import com.control.model.Users;

  
public interface UserDao {  
 public void insertData(Users user);  
 public List<Users> getUserList();  
 public void updateData(Users user);  
 public void deleteData(Integer id);  
 public Users getUser(Integer id);  
  
}  