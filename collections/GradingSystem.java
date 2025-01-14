package collections;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class GradingSystem {

    private LinkedList<Grade> grades;

    public GradingSystem() {
        grades = new LinkedList<>();
    }

    public void setGrades() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many students? ");
        int n = in.nextInt();

        for(int i = 0; i < n; i++) {
            System.out.print("Name: ");
            String name = in.next();
            System.out.print("Grade: ");
            int grade = in.nextInt();
            Grade newGrade = new Grade(name, grade);
            grades.add(newGrade);
        }
    }

    public void printGrades() {
        for(Grade g : grades) {
            System.out.println(g);
        }
    }

    public static void main(String[] args) {
        GradingSystem gs = new GradingSystem();
        gs.setGrades();
        gs.printGrades();
    }
}
