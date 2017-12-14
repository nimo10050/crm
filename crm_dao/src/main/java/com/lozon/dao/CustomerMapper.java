package com.lozon.dao;

import java.util.List;

import com.lozon.domain.Customer;
import com.lozon.domain.QueryVo;

public interface CustomerMapper {
	List<Customer> findCustomerByVo(QueryVo vo);

	Integer findCustomerByVoCount(QueryVo vo);

	void deleteCustomerById(String id);

	void updateCustomer(Customer customer);

	Customer findCustomerById(String id);
}
