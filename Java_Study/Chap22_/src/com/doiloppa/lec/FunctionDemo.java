package com.doiloppa.lec;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args){
        Function<String, Integer> f= s->s.length();
        // String을 입력받으면 문자열의 길이를 리턴해주는 람다식
        System.out.println(f.apply("Robot"));
        System.out.println(f.apply("System"));
    }
}







