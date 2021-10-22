/*
public class Exception extends Throwable {

    public static void main(String[] args) {
        print();
        String name = null;
        int[] array = new int[1];
        // method(0);
        try {
        // System.out.println(array[5]);
        // method(0); // interrupt
            print();
        // System.out.println(name.equals("abc"));
            print();

            print();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException"); // by Zero
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("finally block");
        }

        try {

        } finally {
            System.out.println("finally 2 block called");
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Testing......");
        }
    }

    private static void method(int input) {
        System.out.println(10 / input);
    }

}
*/
