package com.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

    /*
     * 순수 자바 AOP에서 Proxy 객체의 InvocationHandler의 invoke 메소드와 비슷하다
     *
     * */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis(); // 보조 업무

        Object result = invocation.proceed(); // 주 업무

        long end = System.currentTimeMillis(); // 보조 업무
        System.out.println((end - start) + "ms 시간 걸렸습니다.");
        return result;
    }
}
