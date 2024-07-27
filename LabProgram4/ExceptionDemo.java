import java.util.Scanner;

class ExceptionDemo {
    public static void main(String[] args) {
        int a, b, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Input two integers:");
        a = input.nextInt();
        b = input.nextInt();

        // Handle division by zero exception
        try {
            result = a / b;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Divide by zero error " + e);
        }

        int array[] = {2, 3, 4, 5, 6};

        // Handle array index out of bounds exception
        try {
            System.out.println("Accessing array element at index 5: " + array[5]);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Exception caught: Array index out of bound " + e1);
        }

        input.close();
    }
}
