package com.example.AOP_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {


    @Before("com.example.AOP_Demo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics(){
        System.out.println("\n====> Performing API analytics");
    }
}
