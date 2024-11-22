import java.util.Random;

public class MasterMind {
    public static void main(String[] args) {
        System.out.println("Witaj w grze MasterMind!");

        Random random = new Random();

        int accessCodeLength = 4;
        int maxCodeValue = 6;
        int[] accessCode = new int[accessCodeLength];

        for(int i = 0; i < accessCodeLength; i++) {
            accessCode[i] = random.nextInt(maxCodeValue) + 1;
        }

        System.out.println("Kod dostępu to:");

        for(int i = 0; i < accessCodeLength; i++) {
            System.out.print(accessCode[i]);
        }
    }
}
