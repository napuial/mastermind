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
        boolean isUserCodeCorrect = false;

        for(int i = 0; i < accessCodeLength; i++) {
            accessCode[i] = random.nextInt(maxCodeValue) + 1;
        }

        while(isUserCodeCorrect == false) {
            System.out.println("Wprowadź kod dostępu: ");
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
                System.out.println("Zapoznaj się z zasadami gry i spróbuj ponownie.");
            }

            int correctValuesInRightPlaces = 0;
            int correctValuesInWrongPlaces = 0;
            boolean[] accessCodeVerificationTable = new boolean[accessCodeLength];
            boolean[] userCodeVerificationTable = new boolean[accessCodeLength];

            for(int i = 0; i < accessCodeLength; i++) {
                if(userCode[i] == accessCode[i]) {
                    correctValuesInRightPlaces++;
                    userCodeVerificationTable[i] = true;
                    accessCodeVerificationTable[i] = true;
                }
            }

            for(int i = 0; i < accessCodeLength; i++) {
                if(userCodeVerificationTable[i] != true) {
                    for(int j = 0; j < accessCodeLength; j++) {
                        if(accessCodeVerificationTable[j] == false && userCode[i] == accessCode[j]) {
                            correctValuesInWrongPlaces++;
                            userCodeVerificationTable[i] = true;
                            accessCodeVerificationTable[i] = true;
                        }
                    }
                }
            }

            if(correctValuesInRightPlaces == accessCodeLength) {
                System.out.println("Uzyskano dostęp. Gratulacje.");
                isUserCodeCorrect = true;
            } else {
                System.out.println("Poprawne wartości na poprawnych pozycjach: " + correctValuesInRightPlaces);
                System.out.println("Poprawne wartości na niepoprawnych pozycjach: " + correctValuesInWrongPlaces);
            }
        }

        scanner.close();
    }
}
