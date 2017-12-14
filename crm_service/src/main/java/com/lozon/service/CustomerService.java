package com.lozon.service;

import java.util.List;

import com.lozon.domain.BaseDict;
import com.lozon.domain.Customer;
import com.lozon.domain.QueryVo;

public interface CustomerService {
	List<BaseDict> findDictByCode(String code);

	List<Customer> findCustomerByVo(QueryVo vo);

	Integer findCustomerByVoCount(QueryVo vo);

	void deleteCustomerById(String id);

	Customer findCustomerById(String id);

	void updateCustomer(Customer customer);
}
