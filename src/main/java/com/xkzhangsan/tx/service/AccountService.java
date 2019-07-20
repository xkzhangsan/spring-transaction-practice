package com.xkzhangsan.tx.service;

public interface AccountService {
    
    /**
     * 转账
     * @param outer 汇款人
     * @param inner 收款人
     * @param money 交易金额
     */
    public void transfer(String outer,String inner,int money);
 
}
