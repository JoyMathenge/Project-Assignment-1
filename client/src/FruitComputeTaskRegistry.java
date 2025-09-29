package FruitServiceEngine.client.src;

import server.Compute;
import server.tasks.AddFruitPrice;
import server.tasks.UpdateFruitPrice;
import server.tasks.DeleteFruitPrice;
import server.tasks.CalFruitCost;
import server.tasks.CalculateCost;
import server.tasks.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class FruitComputeTaskRegistry {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute engine = (Compute) registry.lookup("FruitComputeEngine");

            System.out.println("Welcome to the Fruit Client");
            System.out.println("Select Task:");
            System.out.println("1 - Add Fruit");
            System.out.println("2 - Update Fruit");
            System.out.println("3 - Delete Fruit");
            System.out.println("4 - Calculate Cost");
            System.out.println("5 - Print Receipt");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            Task<?> task = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter fruit name: ");
                    String fruitAdd = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double priceAdd = Double.parseDouble(scanner.nextLine());
                    task = new AddFruitPrice(fruitAdd, priceAdd);
                    break;
                case 2:
                    System.out.print("Enter fruit name: ");
                    String fruitUpdate = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double priceUpdate = Double.parseDouble(scanner.nextLine());
                    task = new UpdateFruitPrice(fruitUpdate, priceUpdate);
                    break;
                case 3:
                    System.out.print("Enter fruit name: ");
                    String fruitDelete = scanner.nextLine();
                    task = new DeleteFruitPrice(fruitDelete);
                    break;
                case 4:
                    System.out.print("Enter fruit name: ");
                    String fruitCalc = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    task = new CalFruitCost(fruitCalc, quantity);
                    break;
                case 5:
                    System.out.print("Enter total cost: ");
                    double cost = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter amount given: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter cashier name: ");
                    String cashier = scanner.nextLine();
                    task = new CalculateCost(cost, amount, cashier);
                    break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }

            Object result = engine.executeTask(task);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Client error:");
            e.printStackTrace();
        }
    }
}
