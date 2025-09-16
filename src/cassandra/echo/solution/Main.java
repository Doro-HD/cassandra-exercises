package cassandra.echo.solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);
        Parrot parrot = new Parrot("Echo");

        while (isRunning) {
            System.out.println("Enter, exit, to exit the program");

            System.out.print("Enter something for ");
            System.out.print(parrot.getName());
            System.out.print(" to say -> ");

            String input = scanner.nextLine();
            if (input.equals("exit")) {
                isRunning = false;
            } else {
                parrot.repeat(input);
            }
        }
    }
}
