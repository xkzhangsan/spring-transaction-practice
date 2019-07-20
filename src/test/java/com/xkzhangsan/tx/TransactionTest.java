package com.xkzhangsan.tx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xkzhangsan.tx.service.AccountService;

public class TransactionTest extends ExampleConfigurationTests{

	@Autowired
	private AccountService accountService;
	
    @Test
    public void testNoTransaction(){
        //Tom 向 Marry 转账1000
    	accountService.transfer("Tom", "Marry", 1000);
    }
}
