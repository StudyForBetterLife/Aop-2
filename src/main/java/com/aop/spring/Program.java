package com.aop.spring;

import com.aop.entity.Exam;
import com.aop.entity.ExamIF;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("settings.xml");
        /*
        * settings.xml에서 proxyBean을 통해 보조 업무를 중간에 실행 시킬 수도 있고, 주 업무만 실행시킬 수 있다.
        * */
        ExamIF proxyExam = (ExamIF) context.getBean("proxy");

        System.out.printf("total is %d\n", proxyExam.total());
        System.out.printf("avg is %f\n", proxyExam.avg());
    }
}
