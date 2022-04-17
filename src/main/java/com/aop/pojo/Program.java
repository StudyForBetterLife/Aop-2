package com.aop.pojo;

import com.aop.pojo.entity.Exam;
import com.aop.pojo.entity.ExamIF;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {

        /*
         * [그냥 total() 함수 호출하기]
         * */
        System.out.println("[그냥 total() 함수 호출하기]");
        ExamIF exam = new Exam(1, 1, 1, 1);
        System.out.printf("total is %d\n", exam.total());

        /*
         * [Proxy 객체를 이용하여 total() 함수 호출하기]
         *
         * Proxy 객체를 newProxyInstance로 생성
         * newProxyInstance의 파라미터로 사용자 정의 인터페이스를 삽입할 수 있다
         *
         * Proxy 객체는 실제 객체와 똑같은 기능을 수행한다.
         * 보조 업무와 관련된 코드는 InvocationHandler에 작성한다.
         * */
        System.out.println("[Proxy 객체를 이용하여 total() 함수 호출하기]");
        ExamIF proxyExam = (ExamIF) Proxy.newProxyInstance(Exam.class.getClassLoader(),
                new Class[]{ExamIF.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis(); // 보조 업무

                        Object result = method.invoke(exam, args); // 주 업무 (reflection 활용)

                        long end = System.currentTimeMillis(); // 보조 업무
                        System.out.println((end - start) + "ms 시간 걸렸습니다.");
                        return result;
                    }
                });

        System.out.printf("total is %d\n", proxyExam.total());
        System.out.printf("avg is %f\n", proxyExam.avg());

    }
}
