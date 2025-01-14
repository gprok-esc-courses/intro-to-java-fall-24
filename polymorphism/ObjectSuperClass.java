package polymorphism;

import java.util.Random;
import java.util.Vector;

public class ObjectSuperClass {
    public static void main(String[] args) {
        Object o = new Dog("Nick");
        o = new Cat("Mike");
        System.out.println(o.getClass());

        o = 15;

        Object o2 = 15;

        System.out.println(o2.getClass());

        Flyable f = new Duck("aaa");
        f.fly();
    }
}
