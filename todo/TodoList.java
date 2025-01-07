package todo;

import java.util.Scanner;

public class TodoList {

    private int selection;

    public void displayMenu() {
        System.out.println("MENU");
        System.out.println("1. Today");
        System.out.println("2. Projects");
        System.out.println("3. Project Tasks");
        System.out.println("4. Add Project");
        System.out.println("5. Add Task");
        System.out.println("6. Complete Task");
        System.out.println("0. Exit");
    }

    public void getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter selection: ");
        selection = scanner.nextInt();
    }

    public void doSelection() {
        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();
        switch (selection) {
            case 1:
                taskRepository.displayTodayTasks();
                break;
            case 2:
                projectRepository.displayProjects();
                break;
            case 3:
                taskRepository.projectTasks();
                break;
            case 4:
                projectRepository.addProject();
                break;
            case 5:
                taskRepository.addTask();
                break;
            case 6:
                taskRepository.completeTask();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
        }
    }

    public boolean continueSelection() {
        return selection != 0;
    }

    public static void main(String[] args) {
        TodoList todo = new TodoList();
        do {
            todo.displayMenu();
            todo.getUserSelection();
            todo.doSelection();
        } while(todo.continueSelection());
    }
}
