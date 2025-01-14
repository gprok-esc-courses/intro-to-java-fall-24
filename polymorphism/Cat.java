package polymorphism;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Mieow");
    }

    @Override
    public String getType() {
        return "Cat";
    }
}
