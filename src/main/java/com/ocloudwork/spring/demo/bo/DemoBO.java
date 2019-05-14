package com.ocloudwork.spring.demo.bo;

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
public class DemoBO extends BaseBO {

	private static final long serialVersionUID = -4902517619794835349L;
	
	private String demoName;
	private Integer demoInteger;
	private Long demoLong;
	private Double demoDouble;
	private Date editTime;
	private Byte[] file;
	private Gender gender;
}
