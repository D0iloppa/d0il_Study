package com.doiloppa.recycler_cardview;

public class Item {
    String name,e_Mail;
    int age,res_Id;

    
    // 생성자
    public Item(String name, int age, String e_Mail,int res_Id) {
        this.name = name;
        this.age = age;
        this.e_Mail = e_Mail;
        this.res_Id = res_Id;
    }
    
    
    // 게터&세터
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_Mail() {
        return e_Mail;
    }

    public void setE_Mail(String e_Mail) {
        this.e_Mail = e_Mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRes_Id() {
        return res_Id;
    }

    public void setRes_Id(int res_Id) {
        this.res_Id = res_Id;
    }
}
