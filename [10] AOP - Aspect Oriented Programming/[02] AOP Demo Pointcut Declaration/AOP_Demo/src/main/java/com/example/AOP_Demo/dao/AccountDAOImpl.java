package com.example.AOP_Demo.dao;

import com.example.AOP_Demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + " DOING DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + " doWork()");

        return false;
    }

    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName()");
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getSetviceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode()");
    }

    @Override
    public List<Account> findAccounts(boolean tripWare) {
        List<Account> accounts = new ArrayList<>();

        if (tripWare){
            throw new RuntimeException("Exception");
        }

        // create sample accounts
        Account account1 = new Account("Jose", "Basic");
        Account account2 = new Account("Brandon", "Medium");
        Account account3 = new Account("Daniel", "High");

        // add them to the list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }
}
