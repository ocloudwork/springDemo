package com.ocloudwork.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocloudwork.spring.demo.bo.DemoBO;
import com.ocloudwork.spring.demo.dao.DemoDao;
import com.ocloudwork.spring.demo.po.DemoPO;
import com.ocloudwork.spring.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private DemoDao demoDao;
	@Autowired
	private ModelMapper modelMapper;

	public List<DemoBO> listAll() {
		List<DemoBO> demoBOList = new ArrayList<DemoBO>();
		List<DemoPO> demoPOList = demoDao.findAll();
		demoPOList.stream().forEach(demoPO -> {
			demoBOList.add(modelMapper.map(demoPO, DemoBO.class));
		});
		return demoBOList;
	}

	public void saveDemo(DemoBO demoBO) {
		demoDao.save(modelMapper.map(demoBO, DemoPO.class));
	}
}
