package com.xkzhangsan.tx.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xkzhangsan.tx.dao.AccountDao;
import com.xkzhangsan.tx.service.AccountService;

public class AccountServiceImpl implements AccountService{
	 
    private AccountDao accountDao;
     
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    @Transactional(propagation=Propagation.REQUIRED , isolation = Isolation.DEFAULT)
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer, money);
        int i=10/0;
        accountDao.in(inner, money);
    }
 
}
