package com.control;
import java.util.List;  
  
public interface UserDao {  
 public void insertData(User user);  
 public List<User> getUserList();
 public void updateData(User user);  
 public void deleteData(String id);  
 public User getUser(String id);  
  
}  