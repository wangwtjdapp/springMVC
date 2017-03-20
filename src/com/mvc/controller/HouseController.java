package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService; 
	
	
	
	@RequestMapping(value="/login_status", method=RequestMethod.POST)
	@ResponseBody
	public String login_status(HttpServletRequest request,@RequestBody String str){
		
		String status=houseService.getloginStatus(str);
		return status;
	}
	
	
	@RequestMapping(value="/getTcList", method=RequestMethod.POST)
	@ResponseBody
	public String getTcList(@RequestBody String str){
		
		String resStr=houseService.getTcList();
		return resStr;
		
	}
	
	
}
