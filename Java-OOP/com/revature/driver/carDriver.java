package com.revature.driver;
import com.revature.models.*;

public class carDriver{

    public static void main(String[] args){
        Human kevin = new Human("Kevin");
        Human david = new Human("David");
        Human dean = new Human("Dean");

        Car toyota = new Car("Red ", 2004 , " Toyota ", "Celica ");
        Car hyundai = new Car("Gray ", 2020 , " Hyundai ", "Kona ");
        Car porsche = new Car("Highlighter Yellow ", 2021 , " Porsche ", "Cayenne ");

        System.out.println(david.name + " drives a " + hyundai.carColor + hyundai.carYear + hyundai.carBrand + hyundai.carType);
        System.out.println(kevin.name + " drives a " + toyota.carColor + toyota.carYear + toyota.carBrand + toyota.carType);
        System.out.println(dean.name + " drives a " + porsche.carColor + porsche.carYear + porsche.carBrand + porsche.carType);

        
    }
}