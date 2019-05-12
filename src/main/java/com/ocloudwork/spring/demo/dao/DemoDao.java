package com.ocloudwork.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocloudwork.spring.demo.po.DemoPO;

@Repository
public interface DemoDao extends JpaRepository<DemoPO, String> {

}
