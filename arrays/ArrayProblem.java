package arrays;

public class ArrayProblem {
    public static void main(String[] args) {
        int [] ar = {1,2,3,4,5};
        int [] ar2 = ar;

        ar2[3] = 11;

        System.out.println(ar[3]);  // 11

        // What if we need to increase array size?
        int [] ar3 = new int[7];
        for (int i = 0; i < ar.length; i++) {
            ar3[i] = ar[i];
        }
    }
}
