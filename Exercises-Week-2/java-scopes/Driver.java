//This program exists to showcase what one would expect when a variable is called "Out of Scope". 
public class Driver{
    public static void main(String[] args){
        for(int i = 0; i <10; i++){
            System.out.println(i);
        }

        saySomething();

       System.out.println(s); 
    }
    public static void saySomething(){
        String s = "Hello";

        System.out.println(s);
    }
}