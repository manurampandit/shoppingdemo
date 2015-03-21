package com.control;
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
  
public class ItemServiceImpl implements ItemService {  
  
 @Autowired  
 ItemDao itemdao;  

 @Override  
 public List<Items> getItemList() {  
  return itemdao.getItemList();  
 } 
 
 @Override  
 public List<Items> getItemDetails(int id) {  
  return itemdao.getItemDetails(id);  
 }
   
}  