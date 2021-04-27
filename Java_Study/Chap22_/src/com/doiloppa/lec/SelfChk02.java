package com.doiloppa.lec;

import java.util.*;


public class SelfChk02 {
    public static void main(String[] args){

        Comparator<String> sLenComp = (s1,s2) -> s1.length() - s2.length();

        List<String> list = new ArrayList<>();
        for(int i=0;i<23;i++){
            Random random = new Random();
            String s = "";
            for(int j=0;j<random.nextInt(150);j++){ //97~122 알파벳
                char x = (char) (random.nextInt(122-97)+97);
                s+= x;
            }
            list.add(s);
        }

        Collections.sort(list,sLenComp);

        for(String s: list)
            System.out.println(s);


    }
}

