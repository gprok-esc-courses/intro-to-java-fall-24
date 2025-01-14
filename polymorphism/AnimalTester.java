package polymorphism;

import java.util.Random;
import java.util.Vector;

public class AnimalTester {
    public static void main(String[] args) {
        Vector<Animal> animals = new Vector<>();
        animals.add(new Cat("Sylvester"));
        animals.add(new Dog("Pluto"));
        animals.add(new Duck("Donald"));

        for(Animal a : animals) {
            a.sound();
//            if(a instanceof Cat) {
//                Cat c = (Cat) a;
//                c.speak();
//            }
//            else if(a instanceof Dog) {
//                Dog d = (Dog) a;
//                d.bark();
//            }
        }

        Customer customer = new Customer("Jane");
        customer.setPet(new Dog("Jack"));
        System.out.println(customer);
        customer.setPet(new Cat("Jill"));
        System.out.println(customer);
    }
}
