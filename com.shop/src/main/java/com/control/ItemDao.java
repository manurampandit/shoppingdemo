package com.control;
import java.util.List;  
  
public interface ItemDao {  
 public List<Items> getItemList();
 public List<Items> getItemDetails(int id);
}  