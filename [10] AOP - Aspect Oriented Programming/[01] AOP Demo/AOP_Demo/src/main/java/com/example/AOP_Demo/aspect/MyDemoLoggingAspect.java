package com.example.AOP_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // @Before advice

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void com.example.AOP_Demo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.example.AOP_Demo.Account))")
//    @Before("execution(* add*(com.example.AOP_Demo.Account, ..))")
//    @Before("execution(* add*(..))")
    @Before("execution(* com.example.AOP_Demo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====> Executing @Before advice on add*()");
    }

}

