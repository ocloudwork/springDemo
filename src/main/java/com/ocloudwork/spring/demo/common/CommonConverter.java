package com.ocloudwork.spring.demo.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommonConverter implements Converter<Base, Base>{
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public Base convert(Base source) {
		return modelMapper.map(source, Base.class);
	}
}
