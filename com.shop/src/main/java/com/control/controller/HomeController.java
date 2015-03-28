package com.control.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.control.beans.AddressBean;
import com.control.beans.ItemsBean;
import com.control.beans.UsersBean;
import com.control.model.Address;
import com.control.model.Items;
import com.control.model.Users;
import com.control.service.ItemService;
import com.control.service.OrdersService;
import com.control.service.UserService;

@Controller
public class HomeController {
	@Autowired  
	private UserService userService;
	@Autowired  
	private OrdersService orderService; 

	@Autowired  
	 ItemService itemService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Saurabh
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome !!!");

		String message = "Home page for web water" ;
		model.addAttribute("serverResponseMessage", message );

		return "wwe";
	}


	@RequestMapping("/register")  
	public ModelAndView registerUser(@ModelAttribute UsersBean user) {  

		List<String> genderList = new ArrayList<String>();  
		genderList.add("male");  
		genderList.add("female");  

		List<String> cityList = new ArrayList<String>();  
		cityList.add("delhi");  
		cityList.add("gurgaon");  
		cityList.add("meerut");  
		cityList.add("noida");  

		Map<String, List> map = new HashMap<String, List>();  
		map.put("genderList", genderList);  
		map.put("cityList", cityList);  
		return new ModelAndView("register", "map", map);  
	}

	@RequestMapping("/getAddress")  
	public ModelAndView getAddress(@RequestParam String itemId, @ModelAttribute AddressBean addressBean) {  

		List<String> stateList = new ArrayList<String>();
		stateList.add("Uttar Pradesh");  
		stateList.add("Delhi");  

		List<String> cityList = new ArrayList<String>();  
		cityList.add("delhi");  
		cityList.add("gurgaon");  
		cityList.add("meerut");  
		cityList.add("noida");  

		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("itemId", itemId);
		map.put("stateList", stateList);  
		map.put("cityList", cityList);  
		return new ModelAndView("address", "map", map);  
	}
	@RequestMapping("/addAddress") 
	public ModelAndView addAddress(@RequestParam String itemId, @ModelAttribute AddressBean addressBean) {
		Items item = new Items();
		item.setItemId(Integer.parseInt(itemId));
		Address address = prepareModel(addressBean);
		if (null != item && null != address)  
			orderService.insertData(item, address);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		map.put("address", address);
		return new ModelAndView("confirm", "map", map);
	}
	
	@RequestMapping("/successPage")  
	public String success() {  
		return "success";  
	}

	@RequestMapping("/insert")  
	public String inserData(@ModelAttribute UsersBean userBean) {  
		if (userBean != null) {
			Users user = prepareUserModel(userBean);
			userService.insertData(user);
		}
		return "redirect:/getList";  
	}  

	@RequestMapping("/getList")  
	public ModelAndView getUserLIst() {  
		List<Users> userList = userService.getUserList(); 
		List<UsersBean> userBeanList = new ArrayList<UsersBean>();
		for(Users user:userList){
			userBeanList.add(prepareUserBean(user));
		}
		return new ModelAndView("userList", "userList", userBeanList);  
	}  

	@RequestMapping("/edit")  
	public ModelAndView editUser(@RequestParam String id,  
			@ModelAttribute UsersBean userBean) {  

		Users user = userService.getUser(Integer.parseInt(id));  
		userBean = prepareUserBean(user);
		List<String> genderList = new ArrayList<String>();  
		genderList.add("male");  
		genderList.add("female");  

		List<String> cityList = new ArrayList<String>();  
		cityList.add("delhi");  
		cityList.add("gurgaon");  
		cityList.add("meerut");  
		cityList.add("noida");  

		Map<String, Object> map = new HashMap<String, Object>();  
		map.put("genderList", genderList);  
		map.put("cityList", cityList);  
		map.put("user", userBean);  

		return new ModelAndView("userList", "map", map);  

	}  

	@RequestMapping("/update")  
	public String updateUser(@ModelAttribute UsersBean userBean) {
		Users user = prepareUserModel(userBean);
		userService.updateData(user);  
		return "redirect:/getList";  

	}  

	@RequestMapping("/delete")  
	public String deleteUser(@RequestParam String id) {  
		System.out.println("id = " + id);  
		userService.deleteData(Integer.parseInt(id));  
		return "redirect:/getList";  
	}  
	// Saurabh Arora
	// To provide Item List for home page
	 @RequestMapping("/itemList")  
	 public ModelAndView itemList() {  
	  List<Items> itemsList = itemService.getItemList();
	  List<ItemsBean> itemDetails = new ArrayList<ItemsBean>();
	  for(Items item:itemsList){
		  itemDetails.add(prepareItemsBean(item));
	  }
	  return new ModelAndView("itemDetails", "itemDetails", itemDetails);  
	 }
	 
	 // Saurabh Arora	 
	 // to be called from home page with item Id
	 @RequestMapping("/itemDetails")  
	 public ModelAndView orderDetails(@RequestParam int id) {  
	  List<Items> items = itemService.getItemDetails(id);
	  List<ItemsBean> itemDetails = new ArrayList<ItemsBean>();
	  for(Items item:items){
		  itemDetails.add(prepareItemsBean(item));
	  }
	  return new ModelAndView("itemDetails", "itemDetails", itemDetails);  
	 }
	 
	 private Address prepareModel(AddressBean addressBean){
			Address address = new Address();
			address.setAddressId(addressBean.getAddressId());
			address.setCity(addressBean.getCity());
			address.setStreetName(addressBean.getStreetName());
			address.setPincode(addressBean.getPincode());
			address.setState(addressBean.getState());
			address.setGuestAdd("Y");
			
			return address;
		}
	 
	 private ItemsBean prepareItemsBean(Items items){
			ItemsBean bean = new ItemsBean();
			bean.setItemId(items.getItemId());
			bean.setItemName(items.getItemName());
			bean.setPrice(items.getPrice());
			bean.setPicPath(items.getImagePath());
			return bean;
		}
	 private Users prepareUserModel(UsersBean userBean){
		 Users user = new Users();
		 user.setCity(userBean.getCity());
		 user.setFirstName(userBean.getFirstName());
		 user.setGender(userBean.getGender());
		 user.setLastName(userBean.getLastName());
		 user.setUserId(userBean.getUserId());
		 return user;
	 }
	 
	 private UsersBean prepareUserBean(Users user){
		 UsersBean userBean = new UsersBean();
		 userBean.setCity(user.getCity());
		 userBean.setFirstName(user.getFirstName());
		 userBean.setGender(user.getGender());
		 userBean.setLastName(user.getLastName());
		 userBean.setUserId(user.getUserId());
		 return userBean;
	 }

}
