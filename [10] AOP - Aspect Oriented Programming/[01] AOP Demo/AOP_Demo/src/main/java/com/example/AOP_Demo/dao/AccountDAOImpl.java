package com.example.AOP_Demo.dao;

import com.example.AOP_Demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + " DOING DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + " doWork()");

        return false;
    }
}
