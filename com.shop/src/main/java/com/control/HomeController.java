package com.control;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired  
	 UserService userService;  
	
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
	 public ModelAndView registerUser(@ModelAttribute User user) {  
	  
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
	  
	 @RequestMapping("/insert")  
	 public String inserData(@ModelAttribute User user) {  
	  if (user != null)  
	   userService.insertData(user);  
	  return "redirect:/getList";  
	 }  
	  
	 @RequestMapping("/getList")  
	 public ModelAndView getUserLIst() {  
	  List<User> userList = userService.getUserList();  
	  return new ModelAndView("userList", "userList", userList);  
	 }  
	  
	 @RequestMapping("/edit")  
	 public ModelAndView editUser(@RequestParam String id,  
	   @ModelAttribute User user) {  
	  
	  user = userService.getUser(id);  
	  
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
	  map.put("user", user);  
	  
	  return new ModelAndView("userList", "map", map);  
	  
	 }  
	  
	 @RequestMapping("/update")  
	 public String updateUser(@ModelAttribute User user) {  
	  userService.updateData(user);  
	  return "redirect:/getList";  
	  
	 }  
	  
	 @RequestMapping("/delete")  
	 public String deleteUser(@RequestParam String id) {  
	  System.out.println("id = " + id);  
	  userService.deleteData(id);  
	  return "redirect:/getList";  
	 }  
	 
	// Saurabh Arora
	// To provide Item List for home page
	 @RequestMapping("/itemList")  
	 public ModelAndView itemList() {  
	  List<Items> itemDetails = itemService.getItemList();
	  
	  return new ModelAndView("itemDetails", "itemDetails", itemDetails);  
	 }
	 
	 // Saurabh Arora	 
	 // to be called from home page with item Id
	 @RequestMapping("/itemDetails")  
	 public ModelAndView orderDetails(@RequestParam int id) {  
	  List<Items> itemDetails = itemService.getItemDetails(id);
	  
	  return new ModelAndView("itemDetails", "itemDetails", itemDetails);  
	 }
}



