package com.ocloudwork.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocloudwork.spring.demo.po.CodeTemplatePO;

@Repository
public interface CodeTemplateDao extends JpaRepository<CodeTemplatePO, String> {

}
