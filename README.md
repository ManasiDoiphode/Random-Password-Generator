# Password Generator

## Description
This Java program generates secure random passwords based on user preferences. The user can specify the password length and choose to include numbers, lowercase letters, uppercase letters, and special characters.

## Features
- Allows users to specify password length.
- Option to include/exclude numbers, lowercase, uppercase, and special characters.
- Ensures at least one character from each selected category is included.
- Avoids repeating consecutive characters in generated passwords.
- Provides a password strength indicator (Weak, Moderate, Strong).
- Uses `SecureRandom` for better randomness and security.

## How to Run
### Prerequisites
- Java Development Kit (JDK) installed.
- A command-line terminal (Command Prompt, Terminal, etc.).

### Steps
1. Copy the `RandomPasswordGenerator.java` file into a directory on your computer.
2. Open a terminal and navigate to the directory where the file is saved.
3. Compile the Java program using:
   ```sh
   javac RandomPasswordGenerator.java
   ```
4. Run the compiled program using:
   ```sh
   java RandomPasswordGenerator
   ```
5. Follow the prompts to specify password preferences and generate a secure password.

## Example Usage
```
Enter the desired password length: 12
Include numbers? (true/false): true
Include lowercase letters? (true/false): true
Include uppercase letters? (true/false): true
Include special characters? (true/false): false
Generated Password: Abc123xyz456
Password Strength: Strong
Do you want to generate another password? (yes/no): no
```

## Code Explanation
- The `PasswordGenerator` class handles password generation based on user preferences.
- At least one character from each selected category is included.
- `SecureRandom` is used for cryptographic security.
- The program continuously prompts the user until they choose to exit.
- A strength indicator categorizes the password as Weak, Moderate, or Strong based on length and character diversity.

## Future Enhancements
- Allow users to exclude similar-looking characters (e.g., `O` and `0`, `l` and `1`).
- Add an option to save generated passwords securely.
- Implement a GUI version for better user experience.

## License
This project is open-source and available for personal and educational use.

