
class LambdaExpressions {
    //interface which has only one abstract method is functional interface.
    //used to provide implementation of functional interface
    //write annotation @Functional interface to avoid excep's
    //lambda represents one method interface

    /*
    *
    * we don't need to define a class and a method to define the implementation of interface
    */

    //here we simply write the implementation code

    public static void main(String[] args) {

// without lambda
        MyInterf myInterf = new MyInterf() {
            @Override
            public int add(int input1, int input2) {
                return input1 + input2;
            }
        };
        System.out.println(myInterf.add(2, 3));

// with lambda
        MyInterf myInterf1 = (int a, int b) -> {
            if (a % 2 == 0)
                return a + b;
            return a * b;
        };
        System.out.println(myInterf1.add(5, 3));

// Modifying
        MyInterf myInterf2 = (a, b) -> {
            return a + b;
        };
        System.out.println(myInterf2.add(5, 5));

// Modifying
        MyInterf myInterf3 = (a, b) -> a + b;
        System.out.println(myInterf3.add(5, 6));


    }
}

interface MyInterf {
    int add(int input1, int input2);

    public default int add1(int a, int b) {
        return 0;
    }

    public static int add2(int a, int b) {
        return 0;
    }
}