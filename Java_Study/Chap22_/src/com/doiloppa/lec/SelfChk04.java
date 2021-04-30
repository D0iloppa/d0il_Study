package com.doiloppa.lec;

import java.util.Random;
import java.util.function.BiConsumer;

class Box<T> {
    private  T ob;
    public void set(T o) { ob = o;}
    public T get() {return ob;}
}
public class SelfChk04 {

    static BiConsumer<Box<Integer>,Integer> cInt = (a, b) -> a.set(b);
    static BiConsumer<Box<Double>,Double> cDbl = (a, b) -> a.set(b);

    public static void main(String[] args){


        Box<Integer> box1 = new Box<>();
        Box<Double>  box2 = new Box<>();
        Random r = new Random();


        cInt.accept(box1,r.nextInt(1000));
        cDbl.accept(box2,r.nextInt(10000)*0.1);


        System.out.println(box1.get());
        System.out.println(box2.get());


    }

}
