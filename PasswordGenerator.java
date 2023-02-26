/*You can run this program from the command line with two optional arguments, 
the first one being the desired password length and the second one being the desired complexity level (0, 1, or 2).

You can use this program as a basic starting point and customize it to meet your specific needs, 
such as adding special characters, or use it as it is.*/
import java.util.Random;

public class PasswordGenerator
	{
    public static void main(String[] args) 
		{
        int length = 12; // default password length
        int complexity = 2; // default complexity level (0 = only lowercase letters, 1 = lowercase + uppercase letters, 2 = lowercase + uppercase + digits)
        
        if (args.length > 0)
			{
            try 
				{
                length = Integer.parseInt(args[0]);
            } catch (NumberFormatException e)
				{
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }
        
        if (args.length > 1)
			{
            try {
                complexity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }
        
        String password = generatePassword(length, complexity);
        System.out.println("Random Password is : "+password);
    }

    public static String generatePassword(int length, int complexity) {
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        
        if (complexity >= 1) {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        
        if (complexity >= 2) {
            characters += "0123456789";
        }
        
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(rand.nextInt(characters.length())));
        }
        
        return password.toString();
    }
}


/*Note: This program is just an example and should not be used in any production system.
It is important to use a secure method of generating passwords, 
such as using a cryptographically secure random number generator and other security mechanisms.*/
