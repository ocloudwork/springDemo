package com.ocloudwork.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ModelAndMapperGenerator {
	
	@Value("${work.path}")
	private String workPath;
	
	@Value(value = "${resources.path}")
	private String resourcesPath;
	
	@Value(value = "${java.path}")
	private String javaPath;
	
	@Value(value = "${jdbc.driverClassName}")
	private String driverClassName;
	@Value(value = "${jdbc.url}")
	private String url;
	@Value(value = "${jdbc.username}")
	private String username;
	@Value(value = "${jdbc.password}")
	private String password;
	
	@Value(value = "${base.package}")
	private String basePackage;
	
	public void genCode(String tableName) {
		Context initConfig = initConfig(tableName);
		List<String> warnings = null;
		MyBatisGenerator generator = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addContext(initConfig);
			cfg.validate();
			
			DefaultShellCallback callback = new DefaultShellCallback(true);
			warnings = new ArrayList<String>();
			generator = new MyBatisGenerator(cfg, callback, warnings);
			generator.generate(null);
		} catch (Exception e) {
			throw new RuntimeException("Model 和  Mapper 生成失败!", e);
		}
		
		if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
			throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
		}
	}
	
	/**
	 * 完善初始化环境
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param sign 区分字段, 规定如表 gen_test_demo, 则 test 即为区分字段
	 */
	private Context initConfig(String tableName) {
		Context context = null;
		try {
			context = initMybatisGeneratorContext();
			JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
	        javaModelGeneratorConfiguration.setTargetProject(workPath + javaPath);
	        javaModelGeneratorConfiguration.setTargetPackage(basePackage+".model");
	        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
	        
	        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
	        javaClientGeneratorConfiguration.setTargetProject(workPath + javaPath);
	        javaClientGeneratorConfiguration.setTargetPackage(basePackage+".mapper");
	        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
	        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
	        
	        TableConfiguration tableConfiguration = new TableConfiguration(context);
	        tableConfiguration.setTableName(tableName);
	        tableConfiguration.setDomainObjectName(null);//modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
	        context.addTableConfiguration(tableConfiguration);
		} catch (Exception e) {
			throw new RuntimeException("ModelAndMapperGenerator 初始化环境异常!", e);
		}
		return context;
	}
	
	/**
	 * Mybatis 代码自动生成基本配置
	 * @return
	 */
	public Context initMybatisGeneratorContext() {
		Context context = new Context(ModelType.FLAT);
		context.setId("Potato");
		context.setTargetRuntime("MyBatis3Simple");
		context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");
        
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(url);
        jdbcConnectionConfiguration.setUserId(username);
        jdbcConnectionConfiguration.setPassword(password);
        jdbcConnectionConfiguration.setDriverClass(driverClassName);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(workPath + resourcesPath);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        
		return context;
	}
}
