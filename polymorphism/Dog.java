package polymorphism;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Woooof");
    }

    @Override
    public String getType() {
        return "Dog";
    }
}
