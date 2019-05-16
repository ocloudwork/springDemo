package com.ocloudwork.spring.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ocloudwork.spring.demo.bo.DemoBO;

public interface DemoService {
	
	List<DemoBO> listAll();

	void saveDemo(DemoBO demoBO);
	
	Page<DemoBO> pageListDemo(Pageable pageable);

	Page<DemoBO> pageListDemo(Pageable pageable, String id);
}
