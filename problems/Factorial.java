package problems;

public class Factorial {
    public long factorial(int n) {
        long f = 1;
        for(int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        long x = factorial.factorial(50);
        System.out.println(x);
    }
}
