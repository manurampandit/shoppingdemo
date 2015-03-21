package com.control.dao;
import java.util.List;  

import com.control.objects.Items;
  
public interface ItemDao {  
 public List<Items> getItemList();
 public List<Items> getItemDetails(int id);
}  