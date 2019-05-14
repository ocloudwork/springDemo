package com.ocloudwork.spring.demo.dto;

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
public class DemoDTO extends BaseDTO {

	private static final long serialVersionUID = -1572705327959710640L;
	private String demoName;
	private Integer demoInteger;
	private Long demoLong;
	private Double demoDouble;
	private Date editTime;
	private Byte[] file;
	private Gender gender;
}
