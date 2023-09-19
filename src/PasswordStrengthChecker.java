import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Check password length
        if (length >= 8) {
            // Check for other criteria
            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isDigit(ch)) {
                    hasNumber = true;
                } else if (isSpecialCharacter(ch)) {
                    hasSpecialChar = true;
                }
            }
        }

        // Determine password strength
        if (length >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
            System.out.println("Password should meet the following criteria:");
            System.out.println("- At least 8 characters long");
            System.out.println("- Contains at least one uppercase letter");
            System.out.println("- Contains at least one lowercase letter");
            System.out.println("- Contains at least one number");
            System.out.println("- Contains at least one special character");
        }
    }

    // Helper function to check if a character is a special character
    private static boolean isSpecialCharacter(char ch) {
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";
        return specialChars.contains(String.valueOf(ch));
    }
}
