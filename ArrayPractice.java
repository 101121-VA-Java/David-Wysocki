public class ArrayPractice {
    public static void main(String[] args) {
    // This program will print out a reverse order of the string array
    // Declaring the Array used in this example
        String[] names = {"Mark Comment", "David Wysocki", "Dean Long", "Hannah Wallaker"};
    // Using a For Loop to create loop
            for (int i=0; i < names.length; i++){
            System.out.println((names[i]) + " is a member of Super Wonderful Team of Radicals");
            }
            for (int i = names.length; i > 0;i--){
            System.out.println((names[i-1]) + " is a member of Super Wonderful Team of Radicals");
        }
    }
}