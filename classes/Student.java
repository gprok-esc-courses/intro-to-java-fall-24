package classes;

public class Student {
    int id;
    String name;
    String major;
    private double gpa;

    public String toString() {
        return name + " gpa: " + gpa;
    }

    public boolean setGpa(double gpaValue) {
        if(gpaValue >= 0 && gpaValue <= 4) {
            gpa = gpaValue;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean graduates() {
        if(gpa >= 2) {
            return true;
        }
        else {
            return false;
        }
    }
}
