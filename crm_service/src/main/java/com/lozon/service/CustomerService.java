package com.lozon.service;

import java.util.List;

import com.lozon.domain.BaseDict;

public interface CustomerService {
	List<BaseDict> findDictByCode(String code);
}
