package statics;

public class Test {
    private int a;
    private static int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        Test.b = b;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.setA(10);
        t1.setB(20);
        t2.setA(30);
        t2.setB(40);

        System.out.println("T1: " + t1.getA() + " " + t1.getB());
        System.out.println("T2: " + t2.getA() + " " + t2.getB());
    }
}
