package com.xkzhangsan.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.xkzhangsan.tx.dao.AccountDao;
import com.xkzhangsan.tx.service.AccountService;

public class AccountServiceImpl implements AccountService{
	 
    private AccountDao accountDao;
    
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(String outer, String inner, int money) {
    	DefaultTransactionDefinition transDef = new DefaultTransactionDefinition(); // 定义事务属性
        transDef.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED); // 设置传播行为属性
        TransactionStatus status = dataSourceTransactionManager.getTransaction(transDef); // 获得事务状态
        try {
            // 数据库操作
            accountDao.out(outer, money);
            int i = 1/0;
            accountDao.in(inner, money);
             
            dataSourceTransactionManager.commit(status);// 提交
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(status);// 回滚
        }
    }
 
}
