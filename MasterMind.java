import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args) {
        System.out.println("Witaj w grze MasterMind!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadż kod dostępu: ");

        String input = scanner.nextLine();

        System.out.println("Wprowadzony kod dostępu to: " + input);

        scanner.close();
    }
}
