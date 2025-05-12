import java.util.*;

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskCompleted();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n---- To-Do List Menu ----");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Task task = new Task(nextId++, desc, priority);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        tasks.sort(Comparator.comparingInt(Task::getPriority));
        System.out.println("\n-- Your Tasks --");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void markTaskCompleted() {
        System.out.print("Enter task ID to mark as completed: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("Task deleted.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}
