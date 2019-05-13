package com.ocloudwork.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.spring.demo.bo.DemoBO;
import com.ocloudwork.spring.demo.service.DemoService;
import com.ocloudwork.spring.demo.vo.DemoVO;

@RestController
public class DemoController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DemoService demoService;

	@GetMapping(path = "/listDemo")
	public @ResponseBody List<DemoVO> listDemo() {
		List<DemoVO> demoVOList = new ArrayList<DemoVO>();
		List<DemoBO> demoBOList = demoService.listAll();
		demoBOList.stream().forEach(demoBO -> {
			demoVOList.add(modelMapper.map(demoBO, DemoVO.class));
		});
		return demoVOList;
	}
}
