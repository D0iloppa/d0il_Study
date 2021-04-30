package com.doiloppa.lec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf_Ex {

    public static void main(String[] args){
        List<Integer> ls = Arrays.asList(1,-2,-3,4,5,-6,7);
        ls = new ArrayList<>(ls);


        Predicate<Number> p = n -> n.intValue() < 0; // 삭제의 조건
        ls.removeIf(p);

        System.out.println(ls);

    }
}
