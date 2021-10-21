import java.util.Iterator;
import java.util.LinkedList;

public class LambdaEve {

    public static void main(String args[]) {

        Operation s = (a, b) -> a - b;
        System.out.println(s.operate(5,3));

        Greet g = message -> System.out.println("Hello " + message);
        g.to("Mahesh");

    }

    @FunctionalInterface
    interface Operation {
        int operate(int a, int b);
    }

    @FunctionalInterface
    interface Greet {
        void to(String message);
    }

}
