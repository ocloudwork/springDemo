package com.ocloudwork.spring.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "code_template")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CodeTemplatePO extends BasePO{

	private static final long serialVersionUID = 7747808078321370108L;
	@Column
	private String templateName;
	@Column
	private String templateContent;
	@Column
	private String templateAlias;
	@Column
	private String codeFileName;
	@Column
	private String codeFilePath;
	@Column
	private String packageType;
	@Column
	private Boolean subNeed;
}
