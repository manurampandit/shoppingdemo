package com.control.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.model.Address;
import com.control.model.Announcment;
import com.control.model.Items;
import com.control.model.Users;
import com.control.service.AnnouncmentService;
import com.control.service.ItemService;
import com.control.service.OrdersService;
import com.control.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private OrdersService orderService;

	@Autowired
	private AnnouncmentService announcmentService;

	@Autowired
	ItemService itemService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public HomeController() {
		super();
		try {
			userService.indexUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Just A TEST API
	@RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
	public @ResponseBody Users getShopInJSON(@PathVariable String name) {
		Users shop = new Users();
		logger.info(shop.toString());
		shop.setFirstName("vaibhav");
		return shop;
	}

	// User Apis -- Start

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String insertUserData(
			@Context HttpServletRequest httpRequest, @RequestBody String strBody) {
		JsonElement jsonElement = null;
		Gson gson = new Gson();
		jsonElement = new JsonParser().parse(strBody);
		Users user = gson.fromJson(jsonElement, Users.class);

		if (user != null)
			userService.insertData(user);
		return "success";
	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public @ResponseBody List<Users> getUserList(
			@Context HttpServletRequest httpRequest) {
		List<Users> userList = userService.getUserList();
		return userList;
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public @ResponseBody List<Users> searchUserList(
			@Context HttpServletRequest httpRequest,
			@RequestParam(value = "data", required = false) String data) {
		List<Users> userList = userService.searchUser(data);
		return userList;
	}

	@RequestMapping(value = "/getUserListById", method = RequestMethod.GET)
	public @ResponseBody Users getUserListById(
			@Context HttpServletRequest httpRequest,
			@RequestParam(value = "uid", required = false) String uid) {
		Users user = userService.getUser(Integer.parseInt(uid));
		return user;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody String deleteUser(
			@Context HttpServletRequest httpRequest,
			@RequestParam(value = "uid", required = false) String uid) {
		userService.deleteData(Integer.parseInt(uid));
		return "success";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody String updateUser(
			@Context HttpServletRequest httpRequest,
			@RequestBody String strBody,
			@RequestParam(value = "uid", required = false) String uid) {
		JsonElement jsonElement = null;
		Gson gson = new Gson();
		jsonElement = new JsonParser().parse(strBody);
		Users user = gson.fromJson(jsonElement, Users.class);
		userService.updateData(user, Integer.parseInt(uid));
		return "success";
	}

	// User Apis -- End

	@RequestMapping(value = "/getaddress", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAddress(
			@Context HttpServletRequest httpRequest,
			@RequestParam(value = "itemid", required = false) String itemid) {
		List<String> stateList = new ArrayList<String>();
		stateList.add("Uttar Pradesh");
		stateList.add("Delhi");
		List<String> cityList = new ArrayList<String>();
		cityList.add("delhi");
		cityList.add("gurgaon");
		cityList.add("meerut");
		cityList.add("noida");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemId", itemid);
		map.put("stateList", stateList);
		map.put("cityList", cityList);
		return map;
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addAddress(
			@Context HttpServletRequest httpRequest,
			@RequestParam(value = "itemid", required = false) String itemid,
			@RequestBody String strBody) {
		Items item = new Items();
		item.setItemId(Integer.parseInt(itemid));
		JsonElement jsonElement = null;
		Gson gson = new Gson();
		jsonElement = new JsonParser().parse(strBody);
		Address address = gson.fromJson(jsonElement, Address.class);
		if (null != item && null != address)
			orderService.insertData(item, address);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		map.put("address", address);
		return map;
	}

	// Saurabh Arora
	// To provide Item List for home page
	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public @ResponseBody List<Items> itemList(
			@Context HttpServletRequest httpRequest) {
		List<Items> itemsList = itemService.getItemList();
		return itemsList;
	}

	// Saurabh Arora
	// to be called from home page with item Id
	@RequestMapping(value = "/itemDetails", method = RequestMethod.GET)
	public List<Items> orderDetails(@RequestParam int id) {
		List<Items> itemDetails = itemService.getItemDetails(id);
		return itemDetails;
	}

	@RequestMapping(value = "/addAnnouncment", method = RequestMethod.POST)
	public @ResponseBody String addAnnouncment(
			@Context HttpServletRequest httpRequest, @RequestBody String strBody) {
		JsonElement jsonElement = null;
		Gson gson = new Gson();

		jsonElement = new JsonParser().parse(strBody);
		Announcment announcment = gson.fromJson(jsonElement, Announcment.class);

		if (announcment != null)
			announcmentService.insertData(announcment);
		return "success";
	}

	@RequestMapping(value = "/getAnnouncmentById", method = RequestMethod.GET)
	public @ResponseBody List<Announcment> getAnnouncmentById(
			@Context HttpServletRequest httpRequest,
			@RequestBody String strBody,
			@RequestParam(value = "uid", required = false) String uid) {
		return announcmentService.getAnnouncmentList(uid);
	}

	@RequestMapping(value = "/getAnnouncment", method = RequestMethod.GET)
	public @ResponseBody List<Announcment> getAnnouncment(
			@Context HttpServletRequest httpRequest, @RequestBody String strBody) {
		return announcmentService.getAnnouncmentList();
	}
}
