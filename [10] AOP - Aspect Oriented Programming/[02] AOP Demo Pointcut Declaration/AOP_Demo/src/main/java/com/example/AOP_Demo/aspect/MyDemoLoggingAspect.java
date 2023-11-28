package com.example.AOP_Demo.aspect;

import com.example.AOP_Demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.example.AOP_Demo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @After (finally) on method " + method);

    }
    @AfterThrowing(
            pointcut = "execution(* com.example.AOP_Demo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing afterThrowing on method " + method);

        // log the exception
        System.out.println("\n=====> The exception is " + exception);

    }

    @Before("com.example.AOP_Demo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n====> Executing @Before advice on add*()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display the method arguments

        //get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object tempArgs : args){
            System.out.println(tempArgs);

            if (tempArgs instanceof Account){
                // downcast and print Account specifics

                Account account = (Account) tempArgs;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    // Add a new advice for @AfterReturning on the findAccounts method.

    @AfterReturning(
            pointcut = "execution(* com.example.AOP_Demo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n =====> Executing @AfterReturning on method: " + method);

        // print out the results of the method called
        System.out.println("\n =====> Result is: " + result);
        
        // Let's post-process the data ... let's modify it.

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n =====> Result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account account : result) {

            // get uppercase version of name
            String upperName = account.getName().toUpperCase();


            // update the name on the account object
            account.setName(upperName);

        }
    }


}

