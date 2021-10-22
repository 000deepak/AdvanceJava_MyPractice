public class CustomException {
    // throw
    // throws
    public static void main(String[] args) {
        m1();
        m2();
    }

    private static void m2() {
        multiplyValues(10, 0);
    }

    private static void m1() {
        try {
            divideValues(10, 0);
        } catch (Exception e) {

        }
    }

    // JVM
    private static void multiplyValues(int i, int i1) {
        if (i1 == 0)
            try {
                throw new CustomRunTimeException("Please provide any number except 0");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        System.out.println(i / i1);
    }
    
    private static void divideValues(int i, int i1) throws Exception {
        if (i1 == 0) {
            try {
                throw new CustomCompileTimeException("Please provide any number except 0");
            } catch (Exception e) {
                System.out.println();
            }
        }
        System.out.println(i / i1);
    }
    
}
// CompileTime -> Exception , RunTime Exception -> RunTimeException


// CompileTime
class CustomCompileTimeException extends Exception {

    public CustomCompileTimeException(String message) {
        super(message);
    }
}


// Runtime
class CustomRunTimeException extends RuntimeException {

    public CustomRunTimeException(String message) {
        super(message);
    }
}
