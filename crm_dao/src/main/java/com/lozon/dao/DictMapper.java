package com.lozon.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.lozon.domain.BaseDict;


public interface DictMapper {
	List<BaseDict> listDictByCode(String code);
}
