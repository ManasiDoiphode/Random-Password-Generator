import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Class responsible for generating random passwords based on user preferences.
 */
class PasswordGenerator {
    private int length;
    private boolean includeNumbers;
    private boolean includeLowercase;
    private boolean includeUppercase;
    private boolean includeSpecial;
    private static final String NUMBERS = "0123456789";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+<>?/";
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * Constructor to initialize password generator with user preferences.
     * @param length Length of the password.
     * @param includeNumbers Whether to include numbers.
     * @param includeLowercase Whether to include lowercase letters.
     * @param includeUppercase Whether to include uppercase letters.
     * @param includeSpecial Whether to include special characters.
     */
    public PasswordGenerator(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        this.length = length;
        this.includeNumbers = includeNumbers;
        this.includeLowercase = includeLowercase;
        this.includeUppercase = includeUppercase;
        this.includeSpecial = includeSpecial;
    }
    
    /**
     * Generates a secure random password based on user preferences.
     * Ensures at least one character from each selected category is included.
     * @return The generated password.
     */
    public String generatePassword() {
        StringBuilder allowedChars = new StringBuilder();
        StringBuilder password = new StringBuilder();
        
        if (includeNumbers) {
            allowedChars.append(NUMBERS);
            password.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }
        if (includeLowercase) {
            allowedChars.append(LOWERCASE);
            password.append(LOWERCASE.charAt(RANDOM.nextInt(LOWERCASE.length())));
        }
        if (includeUppercase) {
            allowedChars.append(UPPERCASE);
            password.append(UPPERCASE.charAt(RANDOM.nextInt(UPPERCASE.length())));
        }
        if (includeSpecial) {
            allowedChars.append(SPECIAL_CHARS);
            password.append(SPECIAL_CHARS.charAt(RANDOM.nextInt(SPECIAL_CHARS.length())));
        }
        
        if (allowedChars.length() == 0) {
            return "Error: No character set selected.";
        }
        
        while (password.length() < length) {
            char nextChar = allowedChars.charAt(RANDOM.nextInt(allowedChars.length()));
            if (password.length() == 0 || password.charAt(password.length() - 1) != nextChar) {
                password.append(nextChar);
            }
        }
        
        return password.toString();
    }
    
    /**
     * Evaluates and returns the strength of the generated password.
     * @return Strength indicator as a string.
     */
    public String getStrengthIndicator() {
        if (length < 6) return "Weak";
        if (length < 10) return "Moderate";
        if ((includeNumbers && includeLowercase && includeUppercase) || includeSpecial) return "Strong";
        return "Moderate";
    }
}

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter the desired password length: ");
            int length = scanner.nextInt();
            
            if (length <= 0) {
                System.out.println("Invalid length. Please enter a positive integer.");
                continue;
            }
            
            System.out.print("Include numbers? (true/false): ");
            boolean includeNumbers = scanner.nextBoolean();
            System.out.print("Include lowercase letters? (true/false): ");
            boolean includeLowercase = scanner.nextBoolean();
            System.out.print("Include uppercase letters? (true/false): ");
            boolean includeUppercase = scanner.nextBoolean();
            System.out.print("Include special characters? (true/false): ");
            boolean includeSpecial = scanner.nextBoolean();
            
            PasswordGenerator generator = new PasswordGenerator(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
            String password = generator.generatePassword();
            String strength = generator.getStrengthIndicator();
            
            System.out.println("Generated Password: " + password);
            System.out.println("Password Strength: " + strength);
            
            System.out.print("Do you want to generate another password? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        scanner.close();
    }
}
