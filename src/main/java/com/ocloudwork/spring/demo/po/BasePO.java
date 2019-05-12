package com.ocloudwork.spring.demo.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BasePO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	private String id;

	@Column
	private String createBy;

	@Column
	private Date createTime;

	@Column
	private String updateBy;

	@Column
	private Date updateTime;

}
