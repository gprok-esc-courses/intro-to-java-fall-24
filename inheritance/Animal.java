package inheritance;

public class Animal {
    protected String name;
    protected String sound;

    public Animal(String name) {
        this.name = name;
        this.sound = "...";
    }

    public void sound() {
        System.out.println("I am " + name + " and say " + sound);
    }
}
