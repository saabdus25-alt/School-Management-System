import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolManager manager = new SchoolManager();
        SchoolUI ui = new SchoolUI(scanner, manager);
        ui.start();
        scanner.close();
    }
}
