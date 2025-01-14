package polymorphism;

public class Customer {
    private String name;
    private Animal pet;

    public Customer(String name) {
        this.name = name;
        pet = null;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public String toString() {
        return "Customer " + name + " has pet " + pet.getType();
    }
}
