package com.ocloudwork.spring.demo.vo;

import java.util.Date;

import com.ocloudwork.spring.demo.common.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseVO implements Base {
	
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String createBy;
	protected Date createTime;
	protected String updateBy;
	protected Date updateTime;
}
