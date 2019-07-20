package com.xkzhangsan.tx.service.impl;

import com.xkzhangsan.tx.dao.AccountDao;
import com.xkzhangsan.tx.service.AccountService;

public class AccountServiceImpl implements AccountService{
	 
    private AccountDao accountDao;
     
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer, money);
        accountDao.in(inner, money);
    }
 
}
