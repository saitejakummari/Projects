/*This program is a simple to-do list application that allows users to add, edit, and delete tasks.
It uses an ArrayList to store the tasks, and a Scanner to get user input. 
The program displays a menu for the user to choose from different options such as adding, editing, and deleting tasks, viewing the tasks, 
and exiting the application.
The program uses a while loop to repeatedly display the menu, 
and a switch statement to handle the different options selected by the user.
The program also includes validation for the task number when editing or deleting tasks
to ensure that the task number entered is valid and exists in the task list.*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice=0;

        do {
            displayMenu();

            try {
                choice = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (choice) {
                    case 1: // Add task
                        addTask(input, tasks);
                        break;
                    case 2: // Edit task
                        editTask(input, tasks);
                        break;
                    case 3: // Delete task
                        deleteTask(input, tasks);
                        break;
                    case 4: // View tasks
                        viewTasks(tasks);
                        break;
                    case 5: // Exit
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.nextLine(); // Clear invalid input
            }
        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("\n-- TO-DO LIST --");
        System.out.println("1. Add task");
        System.out.println("2. Edit task");
        System.out.println("3. Delete task");
        System.out.println("4. View tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner input, ArrayList<String> tasks) {
        System.out.print("Enter the task: ");
        tasks.add(input.nextLine());
    }

    private static void editTask(Scanner input, ArrayList<String> tasks) {
        System.out.print("Enter the task number to edit: ");
        int taskNum = input.nextInt();
        input.nextLine(); // Clear buffer

        if (taskNum > 0 && taskNum <= tasks.size()) {
            System.out.print("Enter the new task: ");
            tasks.set(taskNum - 1, input.nextLine());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask(Scanner input, ArrayList<String> tasks) {
        System.out.print("Enter the task number to delete: ");
        int taskNum = input.nextInt();

        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewTasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\nTasks:");
            
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
