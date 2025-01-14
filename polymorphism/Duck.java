package polymorphism;

public class Duck extends Animal implements Flyable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Quack");
    }

    @Override
    public String getType() {
        return "Duck";
    }


    @Override
    public void fly() {
        System.out.println("I'm flying like a Duck");
    }
}
