package com.ocloudwork.spring.demo.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ocloudwork.spring.demo.po.Account;

@Repository("testXmlDAO")
public interface ITestXmlDAO {


	public int addMoney(int userId, float money);
	
	public int minusMoney(int userId, float money);

	@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
	public int insertAccount(Account account);

	@Cacheable(value = "indexCache",key = "'xmlgetAccountById'+#id")
	public Account getAccountById(int id);

	@Cacheable(value = "indexCache",key = "'xmlfindAccountsById'+#id")
	public List<Account> findAccountsById(int id);
}
