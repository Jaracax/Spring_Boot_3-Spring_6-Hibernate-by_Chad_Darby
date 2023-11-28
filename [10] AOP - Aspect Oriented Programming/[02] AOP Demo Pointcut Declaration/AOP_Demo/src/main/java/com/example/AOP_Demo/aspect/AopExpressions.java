package com.example.AOP_Demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.example.AOP_Demo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut fo getter methods
    @Pointcut("execution(* com.example.AOP_Demo.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut fo setter methods
    @Pointcut("execution(* com.example.AOP_Demo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
