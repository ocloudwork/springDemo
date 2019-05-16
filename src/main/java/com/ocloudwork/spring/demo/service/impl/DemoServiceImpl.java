package com.ocloudwork.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
	@Override
	public List<DemoBO> listAll() {
		List<DemoBO> demoBOList = new ArrayList<DemoBO>();
		List<DemoPO> demoPOList = demoDao.findAll();
		demoPOList.stream().forEach(demoPO -> {
			demoBOList.add(modelMapper.map(demoPO, DemoBO.class));
		});
		return demoBOList;
	}
	@Override
	public Page<DemoBO> pageListDemo(Pageable pageable) {
		Page<DemoPO> pageDemo=demoDao.findAll(pageable);
		List<DemoBO> demoBOList = new ArrayList<DemoBO>();
		pageDemo.getContent().stream().forEach(demoPO -> {
			demoBOList.add(modelMapper.map(demoPO, DemoBO.class));
		});
		Page<DemoBO> pageDemoBO=new PageImpl<DemoBO>(demoBOList, pageable, pageDemo.getTotalElements());
		return pageDemoBO;
	}
	@Override
	public void saveDemo(DemoBO demoBO) {
		demoDao.save(modelMapper.map(demoBO, DemoPO.class));
	}

	@Override
	public Page<DemoBO> pageListDemo(Pageable pageable, String id) {
		DemoPO p=new DemoPO();
		p.setId(id);
		Page<DemoPO> pageDemo=demoDao.findAll(Example.of(p), pageable);
		List<DemoBO> demoBOList = new ArrayList<DemoBO>();
		pageDemo.getContent().stream().forEach(demoPO -> {
			demoBOList.add(modelMapper.map(demoPO, DemoBO.class));
		});
		Page<DemoBO> pageDemoBO=new PageImpl<DemoBO>(demoBOList, pageable, pageDemo.getTotalElements());
		return pageDemoBO;
	}
}
