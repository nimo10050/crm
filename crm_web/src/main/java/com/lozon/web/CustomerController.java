package com.lozon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lozon.domain.BaseDict;
import com.lozon.domain.Customer;
import com.lozon.domain.QueryVo;
import com.lozon.service.CustomerService;

import cn.itcast.utils.Page;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer.dict.source}")
	private String source;
	@Value("${customer.dict.industry}")
	private String industry;
	@Value("${customer.dict.level}")
	private String level;
	
	@RequestMapping("/list")
	public String list(QueryVo vo, Model model) throws Exception{
		List<BaseDict> sourceList = customerService.findDictByCode(source);
		List<BaseDict> industryList = customerService.findDictByCode(industry);
		List<BaseDict> levelList = customerService.findDictByCode(level);
		// 获取查询条件列表
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		// 查询条件回显
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custName", vo.getCustName());
		
		Integer count = customerService.findCustomerByVoCount(vo);
		List<Customer> customerList = customerService.findCustomerByVo(vo);
		// 显示
		Page<Customer> page = new Page<Customer>();
		page.setTotal(count);		//数据总数
		page.setSize(vo.getSize());	//每页显示条数
		page.setPage(vo.getPage()); //当前页数
		page.setRows(customerList);
		
		model.addAttribute("page", page);
		return "customer";
	}
	
	@RequestMapping("/delete.do")
	public String delete(String id) throws Exception{
		customerService.deleteCustomerById(id);
		return "customer";
	}
	// 修改用户信息
	@RequestMapping("/update.do")
	public String update(Customer customer) throws Exception{
		customerService.updateCustomer(customer);
		return "customer";
	}
	// 根据 id 获取用户信息, 显示在 编辑页面
	@RequestMapping("/edit.do")
	@ResponseBody
	public Customer edit(String id,Model model) throws Exception{
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
}
