package com.aop.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Exam implements ExamIF {

    private int kor;
    private int eng;
    private int math;
    private int com;

    /*
     * 성능 체크를 위해 total() 메소드의 실행시간을 구하는 코드를 추가 (without AOP)
     * */
    @Override
    public int total() {
//        long start = System.currentTimeMillis(); // 보조 업무

        int result = kor + eng + math + com; // 주 업무

//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        long end = System.currentTimeMillis(); // 보조 업무
//        System.out.println((end - start) + "ms 시간 걸렸습니다.");
        return result;
    }

    @Override
    public float avg() {

        float result = total() / 4.0f;

        return result;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", com=" + com +
                '}';
    }
}
