package inheritance;

public class Zoo {
    public static void main(String[] args) {
        Dog d = new Dog("Pluto");
        d.sound();

        Cat c = new Cat("Sylvester");
        c.sound();

        Duck d2 = new Duck("Donald");
        d2.sound();
    }
}
