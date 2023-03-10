import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key;
        String message;

        // Get user input for the key (shift value) and message
        System.out.print("Enter the key (shift value): ");
        key = input.nextInt();
        System.out.print("Enter the message to encrypt/decrypt: ");
        input.nextLine(); // Clear buffer
        message = input.nextLine();

        // Encrypt the message
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted message: " + encrypted);

        // Decrypt the message
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted message: " + decrypted);
    }

    public static String encrypt(String message, int key) {
        // Convert the message to a character array
        char[] chars = message.toCharArray();

        // Shift each character by the key
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) ('a' + (chars[i] - 'a' + key) % 26);
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) ('A' + (chars[i] - 'A' + key) % 26);
            }
        }

        // Convert the character array back to a string
        return new String(chars);
    }

    public static String decrypt(String message, int key) {
        // Convert the message to a character array
        char[] chars = message.toCharArray();

        // Shift each character by the negative key
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) ('a' + (chars[i] - 'a' - key + 26) % 26);
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) ('A' + (chars[i] - 'A' - key + 26) % 26);
            }
        }

        // Convert the character array back to a string
        return new String(chars);
    }
}


/*This program prompts the user to enter a key (shift value) and a message,
then uses the Caesar Cipher algorithm to encrypt and decrypt the message.
The encrypt and decrypt methods both take in a message and a key,
shift each character in the message by the key (or negative key for decryption), 
and return the resulting message as a string. Note that this program only works for letters (uppercase and lowercase),
and any other characters in the message will not be shifted.*/