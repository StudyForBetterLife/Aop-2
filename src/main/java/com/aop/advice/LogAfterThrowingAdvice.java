package com.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {

    /*
     * 예외에 따라 함수의 파라미터(exception 종류)가 달라지므로 ThrowsAdvice 인터페이스에서 override 할 목록이 없다.
     * 직접 정해야 한다.
     *
     * 예외가 발생하지 않으면 afterReturning 메소드가 실행된다.
     * */

    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("target 메소드 수행 도중 IllegalArgumentException 예외가 발생했을 때 수행되는 로직="
                + e.getMessage());
    }

}
