public class Calculator {
    public static void main(String args[]) {

        // Basic Variable declaration for use
        int a = 5;
        int b = 12;
        double a1 = 5;
        double b1 = 12;
        int outputadd = addition(a, b);
        int outputsub = subtraction(a, b);
        double outputmulti = multiplication(a1, b1);
        double outputdiv = division(a, b);
        System.out.println("5 + 12 is equal to " + outputadd);
        System.out.println("5 - 12 is equal to " + outputsub);
        System.out.println("12 times 5 is equal to " + outputmulti);
        System.out.println("5 divided by 12 is equal to " + outputdiv);
        /*
         * method declaration: [access modifier] [non-access modifier] [return type]
         * [name os method] ([param 1], [param 2])
         */

    }
    //Days of Week Switch Statement
    public static void main(String[] args)
    String[] days = {"Default", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    Random r=new Random();
    int randomNumber=r.nextInt(days.length)
    System.out.println(days[randomNumber]);

    // Declaring methods used in a calculator
    public static int addition(int a, int b) {
        return (a + b);
    }

    public static int subtraction(int a, int b) {
        return (a - b);
    }

    public static double multiplication(double a1, double b1) {
        return (a1 * b1);
    }

    public static double division(double a1, double b1) {
        return (a1 / b1);
    }

}
