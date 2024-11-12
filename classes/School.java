package classes;

public class School {
    public static void main(String[] args) {
        Student a = new Student();
        Student b = new Student();

        a.name = "John";
        a.setGpa(3.2);

        b.name = "Mary";
        b.setGpa(2.3);

        System.out.println(a);
        if(a.graduates()) {
            System.out.println(a.name + " graduates");
        }
        System.out.println(b);
        if(b.graduates()) {
            System.out.println(b.name + " graduates");
        }
    }
}
