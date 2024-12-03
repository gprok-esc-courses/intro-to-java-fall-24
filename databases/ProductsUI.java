package databases;

import java.util.Scanner;

public class ProductsUI {

    public void displayMenu() {
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Find Product");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        double price = scanner.nextDouble();
        ProductRepository repository = new ProductRepository();
        repository.addProduct(description, price);
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        double newPrice = scanner.nextDouble();
        ProductRepository repository = new ProductRepository();
        repository.updateProduct(id, newPrice);
    }

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ProductRepository repository = new ProductRepository();
        repository.deleteProduct(id);
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ProductRepository repository = new ProductRepository();
        repository.findProduct(id);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    findProduct();
                    break;
                case 0:
                    System.out.println("bye!");
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        ProductsUI productsUI = new ProductsUI();
        productsUI.menu();
    }

}
