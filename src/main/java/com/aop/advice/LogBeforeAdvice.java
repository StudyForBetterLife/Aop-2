package com.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {

    /*
    * before 메소드에 주 업무 앞에서 실행될 보조 업무를 작성한다.
    * */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("앞에서 실행될 로직");
    }
}
