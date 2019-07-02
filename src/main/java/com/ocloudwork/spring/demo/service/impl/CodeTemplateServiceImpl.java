package com.ocloudwork.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocloudwork.spring.demo.bo.CodeTemplateBO;
import com.ocloudwork.spring.demo.dao.CodeTemplateDao;
import com.ocloudwork.spring.demo.po.CodeTemplatePO;
import com.ocloudwork.spring.demo.service.CodeTemplateService;

@Service
public class CodeTemplateServiceImpl implements CodeTemplateService {
	@Autowired
	private CodeTemplateDao codeTemplateDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<CodeTemplateBO> listAll() {
		List<CodeTemplateBO> codeTemplateBOList = new ArrayList<CodeTemplateBO>();
		List<CodeTemplatePO> codeTemplatePOList = codeTemplateDao.findAll();
		codeTemplatePOList.stream().forEach(po -> {
			codeTemplateBOList.add(modelMapper.map(po, CodeTemplateBO.class));
		});
		return codeTemplateBOList;
	}
	
}
