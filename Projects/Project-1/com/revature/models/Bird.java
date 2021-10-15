package com.revature.models;

//This model's purpose is to declare attributes associated with pet birds.

public class Bird{
    public String name;
    public String mutation;
    public String breedName;
    public int ageInMonths;
    public double price;

        public Bird(){

        }
        public Bird(String name){
            this.name = name;
        }
        public Bird(String mutation, String breedName, int ageInMonths, double price){
            this.mutation = mutation;
            this.breedName = breedName;
            this.ageInMonths = ageInMonths;
            this.price = price;
            
        }
}        