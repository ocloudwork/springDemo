package com.ocloudwork.spring.demo.vo;

import java.util.Date;

import com.ocloudwork.spring.demo.common.Base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseVO implements Base {
	
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String createBy;
	protected Date createTime;
	protected String updateBy;
	protected Date updateTime;
}
