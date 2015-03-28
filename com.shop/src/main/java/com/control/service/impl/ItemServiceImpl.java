package com.control.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.control.dao.ItemDao;
import com.control.model.Items;
import com.control.service.ItemService;

public class ItemServiceImpl implements ItemService {  

	@Autowired  
	ItemDao itemdao;  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Items> getItemList() {  
		return itemdao.getItemList();  
	} 

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Items> getItemDetails(int id) {  
		return itemdao.getItemDetails(id);  
	}

}  