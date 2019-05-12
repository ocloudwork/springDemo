package com.ocloudwork.spring.demo.service;

import java.util.List;

import com.ocloudwork.spring.demo.bo.DemoBO;

public interface DemoService {
	
	List<DemoBO> listAll();

	void saveDemo(DemoBO demoBO);
}
