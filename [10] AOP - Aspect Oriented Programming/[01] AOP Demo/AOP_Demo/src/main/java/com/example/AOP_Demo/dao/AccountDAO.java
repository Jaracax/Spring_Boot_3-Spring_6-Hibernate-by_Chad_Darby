package com.example.AOP_Demo.dao;

import com.example.AOP_Demo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
