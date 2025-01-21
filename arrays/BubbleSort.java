package arrays;

public class BubbleSort {
    public void sort(int [] arr) {
        int stop = arr.length - 2;
        while (stop >= 0) {
            for (int i = 0; i <= stop; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            stop--;
        }


    }

    public void changeValue(int a) {
        a = a * 2;
    }

    public static void main(String[] args) {
        int [] ar = {89, 56, 23, 2, 45, 26, 1, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();

        int b = 5;
        bubbleSort.changeValue(b);
        System.out.println(b);
    }
}
