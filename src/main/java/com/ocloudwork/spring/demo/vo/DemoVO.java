package com.ocloudwork.spring.demo.vo;

import java.util.Date;

import com.ocloudwork.spring.demo.constant.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemoVO extends BaseVO {
	
	private static final long serialVersionUID = 5180722551798030677L;
	
	private String demoName;
	private Integer demoInteger;
	private Long demoLong;
	private Double demoDouble;
	private Date editTime;
	private Byte[] file;
	private Gender gender;
}
