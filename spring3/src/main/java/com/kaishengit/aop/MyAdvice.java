package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public void beforeAdvice() {
        System.out.println("前置通知");
    }

    public void afterReturingAdvice(Object result) {
        System.out.println("后置通知..  " + result);
    }

    public void exceptionAdvice(Exception e) {
        System.out.println("异常通知..... " + e.getMessage());
    }

    public void finallyAdvie() {
        System.out.println("最终通知...");
    }

    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object object = null;
        try {
            System.out.println("~~~~前置通知~~~~");
            object = joinPoint.proceed(); //代表了目标对象方法的执行
            System.out.println("~~~~后置通知~~~~" + object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("~~~~异常通知~~~~");
        } finally {
            System.out.println("~~~~最终通知~~~~");
        }
        return object;
    }
}
