import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for password length
        System.out.print("Enter the desired password length: ");
        int passwordLength = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get user preferences for character types
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");

        // Validate user input
        if (!includeNumbers && !includeLowercase && !includeUppercase && !includeSpecialChars) {
            System.out.println("Please select at least one character type to include.");
            return;
        }

        // Define character sets
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        // Create a combined character set based on user preferences
        StringBuilder charset = new StringBuilder();
        if (includeNumbers) charset.append(numbers);
        if (includeLowercase) charset.append(lowercaseLetters);
        if (includeUppercase) charset.append(uppercaseLetters);
        if (includeSpecialChars) charset.append(specialChars);

        // Generate the random password
        Random random = new Random();
        StringBuilder password = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(charset.length());
            char randomChar = charset.charAt(randomIndex);
            password.append(randomChar);
        }

        // Display the generated password
        System.out.println("Your random password is: " + password.toString());
    }
}
