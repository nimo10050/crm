package com.lozon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lozon.dao.CustomerMapper;
import com.lozon.dao.DictMapper;
import com.lozon.domain.BaseDict;
import com.lozon.domain.Customer;
import com.lozon.domain.QueryVo;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<BaseDict> findDictByCode(String code) {
		return dictMapper.listDictByCode(code);
	}

	@Override
	public List<Customer> findCustomerByVo(QueryVo vo) {
		return customerMapper.findCustomerByVo(vo);
	}

	@Override
	public Integer findCustomerByVoCount(QueryVo vo) {
		return customerMapper.findCustomerByVoCount(vo);
	}

	@Override
	public void deleteCustomerById(String id) {
		customerMapper.deleteCustomerById(id);
	}

	@Override
	public Customer findCustomerById(String id) {
		return customerMapper.findCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

}
