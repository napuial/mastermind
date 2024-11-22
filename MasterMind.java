import java.util.Scanner;
import java.util.Random;

public class MasterMind {
    public static void main(String[] args) {
        System.out.println("Witaj w grze MasterMind!");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int accessCodeLength = 4;
        int maxCodeValue = 6;
        int[] accessCode = new int[accessCodeLength];
        int[] userCode = new int[accessCodeLength];

        for(int i = 0; i < accessCodeLength; i++) {
            accessCode[i] = random.nextInt(maxCodeValue) + 1;
        }

        System.out.println("Wprowadż kod dostępu: ");
        String input = scanner.nextLine();

        try {
            if(input.length() != accessCodeLength) {
                throw new NumberFormatException();
            }
            for(int i = 0; i < accessCodeLength; i++) {
                userCode[i] = Character.getNumericValue(input.charAt(i));
                if(userCode[i] < 1 || userCode[i] > maxCodeValue) {
                    throw new NumberFormatException();
                }
            }
        } catch(NumberFormatException e) {
            System.out.println("Przegrana. Zapoznaj się z zasadami gry i spróbuj ponownie.");
        }

        scanner.close();
    }
}
