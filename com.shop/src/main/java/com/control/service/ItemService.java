package com.control.service;
import java.util.List;  

import com.control.objects.Items;
  
public interface ItemService {  
 public List<Items> getItemList();
 public List<Items> getItemDetails(int id);
}  