package com.ocloudwork.spring.demo.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.CaseFormat;
import com.ocloudwork.spring.demo.bo.CodeTemplateBO;
import com.ocloudwork.spring.demo.service.CodeTemplateService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

@Controller(value = "/codeGenerator")
public class CodeGeneratorController extends BaseController{
	
	// 项目在硬盘上的基础路径
	@Value(value = "${project.path}")
	private String projectPath = System.getProperty("user.dir");
	
	@Value(value = "${template.file.path}")
	private String templateFilePath;
	
	@Value(value = "${base.package}")
	private String basePackage;
	
	@Autowired
	private CodeTemplateService codeTemplateService;
	
	@GetMapping(path = "/make/{tableId}")
	public @ResponseBody boolean make(@PathVariable String tableId) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, TemplateException, IOException {
		Configuration cfg = initFreemarkerConfiguration();
		Map<String, Object> data=new HashMap<String,Object>();
		String tableName=getTableName(tableId);
		data.put("tableName", tableName);
		data.put("className", tableNameConvertUpperCamel(tableName));
		data.put("objectName", tableNameConvertLowerCamel(tableName));
		data.put("basePackage", basePackage);
		
		List<CodeTemplateBO> codeTemplateList=codeTemplateService.listAll();
		//循环模板生成代码文件
		for (CodeTemplateBO codeTemplateBO : codeTemplateList) {
			data.put("packageType", codeTemplateBO.getPackageType());
			//获取包转换文件路径
			File serviceFile = new File(projectPath + codeTemplateBO.getCodeFilePath()+ codeTemplateBO.getCodeFileName());
			// 查看父级目录是否存在, 不存在则创建
			if (!serviceFile.getParentFile().exists()) {
				serviceFile.getParentFile().mkdirs();
			}
			cfg.getTemplate(codeTemplateBO.getTemplateAlias()).process(data, new FileWriter(serviceFile));
		}
		return false;
	}
	
	private String getTableName(String tableId) {
		return "user_role";
	}
	
	/**
	 * 下划线转成驼峰, 首字符为小写
	 * user_info ==> userInfo
	 * @param tableName 表名 user_info
	 * @return
	 */
	protected String tableNameConvertLowerCamel(String tableName) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
	}
	
	/**
	 * 下划线转成驼峰, 首字符为大写
	 * user_info ==> UserInfo
	 * @param tableName 表名
	 * @return
	 */
	protected String tableNameConvertUpperCamel(String tableName) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
	}
	
	private Configuration initFreemarkerConfiguration() {
		Configuration cfg = null;
		try {
			cfg = new Configuration(Configuration.VERSION_2_3_28);
			cfg.setDirectoryForTemplateLoading(new File(templateFilePath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		} catch (IOException e) {
			throw new RuntimeException("Freemarker 模板环境初始化异常!", e);
		}
		return cfg;
	}
}
