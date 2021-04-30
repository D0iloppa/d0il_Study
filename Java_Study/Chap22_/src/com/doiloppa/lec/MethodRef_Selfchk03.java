package com.doiloppa.lec;


import java.util.ArrayList;
import java.util.function.BiFunction;

public class MethodRef_Selfchk03 {

    static class Box<T, U> {
        private T id; // 식별자
        private U con; // 내용

        public Box(T id, U con) {
            this.id = id;
            this.con = con;
        }

        public void showIt(){
            System.out.println("ID: "+ id + ", " + "Contents : "+ con);
        }
    }

    public static void main(String[] args){
//        BiFunction<Integer,String,Box<Integer,String>> bf = (id,con)->new Box<>(id,con);
        BiFunction<Integer,String,Box<Integer,String>> bf = Box::new;
        Box<Integer,String> b1 = bf.apply(1,"Toy");
        Box<Integer,String> b2 = bf.apply(2,"Robot");


        b1.showIt();
        b2.showIt();

    }




}
