package com.lozon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lozon.domain.BaseDict;
import com.lozon.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer.dict.source}")
	private String source;
	
	@RequestMapping("/list")
	public String list() throws Exception{
		List<BaseDict> sourceList = customerService.findDictByCode(source);
		System.out.println("客户源大小: " + sourceList.size());
		return "customer";
	}
}
