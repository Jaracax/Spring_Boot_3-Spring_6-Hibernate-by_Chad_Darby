package com.example.AOP_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudAsyncAspect {


    @Before("com.example.AOP_Demo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync(){
        System.out.println("\n====> Logging to cloud Async");
    }
}
