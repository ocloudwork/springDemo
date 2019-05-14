package com.ocloudwork.spring.demo.bo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseBO implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String id;
	protected String createBy;
	protected Date createTime;
	protected String updateBy;
	protected Date updateTime;

}
