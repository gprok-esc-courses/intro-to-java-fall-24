package collections;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListSort {
    public void sort(ArrayList<Integer> list) {
        int stop = list.size() - 2;
        while (stop >= 0) {
            for (int i = 0; i <= stop; i++) {
                if (list.get(i) > list.get(i+1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
            stop--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        ArrayListSort sort = new ArrayListSort();
        sort.sort(list);
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
