package com.revature.driver;
import com.revature.models.Human;

public class driver{

    public static void main(String[] args){
        Human kevin = new Human();

        Human dean = new Human("Dean");

        Human michael = new Human("Michael", 25, true);
        System.out.println(dean.name);
        System.out.println(michael.age);
        System.out.println(michael.isRightHanded + " is that Michael is Right Handed.");

        System.out.println(dean.eat("rice"));
        michael.sleep();
    }
}