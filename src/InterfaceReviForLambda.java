class LambdaExBL {
    public static void main(String[] args) {

        Interf interf = new Interf() {
            @Override
            public void m1() {
                System.out.println("m1 method");
            }

            @Override
            public void m2() {
                System.out.println("m2 method");
            }

            @Override
            public void m3() {
                System.out.println("m3 method");
            }
        };

        interf.m3();
    }
}


interface Interf {
    void m1();

    void m2();

    void m3();
}

abstract class A implements Interf {
    @Override
    public void m1() {
        System.out.println("abstract m1 method");
    }

    @Override
    public void m2() {
        System.out.println("abstract m2 method");
    }
}


class B extends A {

    @Override
    public void m3() {
        System.out.println("abstract m3 method");
    }

}



