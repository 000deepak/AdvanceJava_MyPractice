/*
* Implementation of anonymous class
*
* */

class AnonymousClass {
    public static void main(String[] args) {
        int width = 10;

        //Drawable implementation using anonymous class
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing " + width);
            }
        };

        d.draw();

    }

}

interface Drawable {
    public void draw();
}
