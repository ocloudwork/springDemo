package com.ocloudwork.spring.demo.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeTemplateBO extends BaseBO {
	private static final long serialVersionUID = -2523404153106908538L;

	private String templateName;
	private String templateContent;
	private String templateAlias;
	private String codeFileName;
	private String codeFilePath;
	private String packageType;
	private Boolean subNeed;
}
