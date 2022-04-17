package com.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfterReturningAdvice implements AfterReturningAdvice {
    /*
     * 함수가 호출 된 이후 afterReturning이 수행된다
     * 따라서 함수의 반환 값 Object returnValue이 파라미터로 들어온다.
     * */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("주 업무가 종료된 이후 실행되는 로직=" + "returnValue:" + returnValue + " method.getName():" + method.getName());
    }
}
