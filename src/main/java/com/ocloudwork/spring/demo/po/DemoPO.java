package com.ocloudwork.spring.demo.po;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ocloudwork.spring.demo.constant.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "demo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DemoPO extends BasePO {

	private static final long serialVersionUID = -6384434108426640453L;
	@Column
	private String demoName;
	@Column
	private Integer demoInteger;
	@Column
	private Long demoLong;
	@Column
	private Double demoDouble;

	@Temporal(TemporalType.TIMESTAMP)
	private Date editTime;
	
	@Lob
	@Basic(fetch = FetchType.LAZY) // 二进制数据，且延迟加载
	private Byte[] file;
	
	@Enumerated(EnumType.ORDINAL)  
	@Column(length=1,nullable=false)//枚举类型，且将值存入数据库
	private Gender gender= Gender.UNKNOWN;
}
