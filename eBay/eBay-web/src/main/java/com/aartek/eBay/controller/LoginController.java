package com.aartek.eBay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
	@RequestMapping("/showPage")
	public String showPage()
	{
		return "showPage";
	}
	
}
