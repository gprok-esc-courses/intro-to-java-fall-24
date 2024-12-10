package collections;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<String>();

        data.add("Athens");
        data.add("Paris");
        data.add("New York");
        data.add("San Francisco");

        for(String city : data) {
            System.out.println(city);
        }
    }
}
