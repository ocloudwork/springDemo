package com.ocloudwork.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.spring.demo.bo.DemoBO;
import com.ocloudwork.spring.demo.service.DemoService;
import com.ocloudwork.spring.demo.vo.DemoVO;

@RestController
public class DemoController extends BaseController {

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

	@GetMapping(path = "/pageListDemo")
	@ResponseBody
	public Page<DemoVO> pageListDemo(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("sortType") String sortType, @RequestParam("sortableFields") String sortableFields) {

		Sort sort = ASC.equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields)
				: new Sort(Sort.Direction.DESC, sortableFields);
		Pageable pageable = new PageRequest(page, size, sort);

		List<DemoVO> demoVOList = new ArrayList<DemoVO>();
		Page<DemoBO> pageDemoBO = demoService.pageListDemo(pageable);
		pageDemoBO.getContent().stream().forEach(demoBO -> {
			demoVOList.add(modelMapper.map(demoBO, DemoVO.class));
		});

		Page<DemoVO> pageDemoVO = new PageImpl<DemoVO>(demoVOList, pageable, pageDemoBO.getTotalElements());
		return pageDemoVO;
	}

	@GetMapping(path = "/pageListParasDemo")
	@ResponseBody
	public Page<DemoVO> pageListParasDemo(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("sortType") String sortType, @RequestParam("sortableFields") String sortableFields,
			@RequestParam("id") String id) {

		Sort sort = ASC.equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields)
				: new Sort(Sort.Direction.DESC, sortableFields);
		Pageable pageable = new PageRequest(page - 1, size, sort);

		List<DemoVO> demoVOList = new ArrayList<DemoVO>();
		Page<DemoBO> pageDemoBO = demoService.pageListDemo(pageable, id);
		pageDemoBO.getContent().stream().forEach(demoBO -> {
			demoVOList.add(modelMapper.map(demoBO, DemoVO.class));
		});

		Page<DemoVO> pageDemoVO = new PageImpl<DemoVO>(demoVOList, pageable, pageDemoBO.getTotalElements());
		return pageDemoVO;
	}
}
