package com.control.service;
import java.util.List;  

import com.control.model.Users;

public interface UserService {  
  
 public void insertData(Users user);  
 public List<Users> getUserList();  
 public void deleteData(Integer id);  
 public Users getUser(Integer id);  
 public void updateData(Users user,int id);  
 public void indexUser() throws Exception;
 public List<Users> searchUser(String data);
  
}  