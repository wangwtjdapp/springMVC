package com.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.service.SearchService;
import com.mvc.until.TcUser;
import com.mvc.until.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/login")
public class LoginController{
	@Autowired
	private SearchService searchService;

	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String Hello(ModelMap model){
		model.addAttribute("message", "hhh");
		return "hello";
	}
	
//	@RequestMapping(value="/user", method=RequestMethod.POST)
//	public String getUsers(ModelMap model){
//		System.out.println("ssss");
//		List<User> users = searchService.getUsers();
//		model.addAttribute("users", users);
//		model.addAttribute("user", users.get(0));
//		return "user";
//	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	@ResponseBody
	public String getUsers(@RequestBody String str){
		System.out.println("ssss");
		List<User> users = searchService.getUsers();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<users.size();i++){
			User user = users.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", String.valueOf(user.getId()));
			map.put("username", user.getUserName());
			map.put("password", user.getPassword());
			
			JSONObject json = JSONObject.fromObject(map);
			jsonArray.add(json);
		}
		str=jsonArray.toString();
		return str;
	}
	
	
	
}
