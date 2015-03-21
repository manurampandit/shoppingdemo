package com.control.service.impl;
import java.util.List;  
  



import org.springframework.beans.factory.annotation.Autowired;  

import com.control.dao.ItemDao;
import com.control.objects.Items;
import com.control.service.ItemService;
  
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