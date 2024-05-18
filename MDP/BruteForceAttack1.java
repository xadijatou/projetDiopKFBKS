import java.util.Arrays;

public class BruteForceAttack1 {

    public static void main(String[] args) {
        String targetPassword = "1234"; // Mot de passe à deviner
        bruteForce(targetPassword);
    }

    public static void bruteForce(String targetPassword) {
        char[] charset = "0123456789".toCharArray();
        int passwordLength = targetPassword.length();
        char[] attempt = new char[passwordLength];

        Arrays.fill(attempt, charset[0]);

        while (!Arrays.equals(attempt, targetPassword.toCharArray())) {
            increment(attempt, charset);
            String currentAttempt = new String(attempt);
            System.out.println("Tentative : " + currentAttempt);
            if (currentAttempt.equals(targetPassword)) {
                System.out.println("Mot de passe trouvé : " + currentAttempt);
                break;
            }
        }
    }

    public static void increment(char[] attempt, char[] charset) {
        int index = attempt.length - 1;
        while (index >= 0) {
            if (attempt[index] == charset[charset.length - 1]) {
                attempt[index] = charset[0];
                index--;
            } else {
                int charIndex = indexOf(charset, attempt[index]);
                if (charIndex >= 0) {
                    attempt[index] = charset[charIndex + 1];
                    break;
                }
            }
        }
    }

    public static int indexOf(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
