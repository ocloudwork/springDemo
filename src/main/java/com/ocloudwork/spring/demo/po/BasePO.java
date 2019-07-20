package com.ocloudwork.spring.demo.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ocloudwork.spring.demo.common.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePO implements Base {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	protected String id;

	@Column
	protected String createBy;

	@Column
	protected Date createTime;

	@Column
	protected String updateBy;

	@Column
	protected Date updateTime;

}
