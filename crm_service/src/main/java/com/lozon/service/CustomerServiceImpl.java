package com.lozon.service;

import java.lang.reflect.Constructor;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lozon.dao.CustomerMapper;
import com.lozon.dao.DictMapper;
import com.lozon.domain.BaseDict;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<BaseDict> findDictByCode(String code) {
		System.out.println("hello");
		return dictMapper.listDictByCode(code);
	}
	
	@Test
	public void test1() throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> loadClass = loader.loadClass("com.lozon.service.CustomerServiceImpl");
		// 通过默认构造器实例化
		Constructor<?> constructor = loadClass.getConstructor(null);
		CustomerServiceImpl instance = (CustomerServiceImpl)constructor.newInstance();
		// 通过class实例化
		//CustomerServiceImpl instance = (CustomerServiceImpl)loadClass.newInstance();
		System.out.println(instance);
	}

}
