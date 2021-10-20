package com.revature.models;

public class Human{
    //Human Attributes
    public String hairColor;
    public int age;
    public String name;
    public boolean isRightHanded;

        public Human(){

        }
        public Human(String name){
            this.name = name;
        }

        public Human(String name, int age, boolean isRightHanded){
            this.name = name;
            this.age = age;
            this.isRightHanded = isRightHanded;
        }
//Return Type
    public String eat(String food){
        return "I'm eating " + food;
    }

    public void sleep(){
        System.out.println("zzzz");
    }
}