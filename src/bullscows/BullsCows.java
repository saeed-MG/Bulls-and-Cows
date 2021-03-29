package bullscows;
public class BullsCows {

    private static void bullsAndCows() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Input the length of the secret code: ");
        long length = 0;
        boolean b = true;
        String str = scanner.nextLine();
        try {
            length = Long.parseLong(str);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + "\"" + str + "\"" + " isn't a valid number.");
            b = false;
        }
        String numbersLetters = "0123456789abcdefghijklmnopqrstuvwxyz";
        java.security.SecureRandom random = new java.security.SecureRandom();
        StringBuilder secret = new StringBuilder((int) length);
        int numPossible = 0;
        for (int i = 0; i < 0; i++) {
            if (!b) {
                break;
            }
        }
        if (b) {
            System.out.println("Input the number of possible symbols in the code:");
            numPossible = scanner.nextInt();
        }

        while (b) {
            if (numPossible < length || length == 0) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length +" with " + numPossible + " unique symbols.");
                break;
            }
            if (numPossible > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                break;
            }
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < length; i++) {
                System.out.print("*");
            }
            if (numPossible == 10) {
                System.out.println(" (0-9).");
            } else if (numPossible == 11) {
                System.out.println(" (0-9, a).");
            } else {
                System.out.println(" 0-9, a-" + numbersLetters.charAt(numPossible - 1) + ").");
            }
            for (int i = 0; i < numPossible; i++) {
                int rndCharAt = random.nextInt(numPossible);
                char rndChar = numbersLetters.charAt(rndCharAt);
                if (!secret.toString().contains(String.valueOf(rndChar))) {
                    secret.append(rndChar);
                }
                if (secret.length() == length) {
                    break;
                }
            }
            System.out.println("Okay, let's start a game!");
            int m = 1;
            while (true) {
                System.out.println("Turn " + m++ + ":");
                String guess = scanner.next();
                int countBull = 0;
                int countCow = 0;
                int[] arr1 = new int[100];
                int[] arr2 = new int[100];
                if (guess.length() > length || guess.length() < length) {
                    break;
                }
                for (int i = 0; i < secret.length(); i++) {
                    char c1 = secret.charAt(i);
                    char c2 = guess.charAt(i);

                    if (c1 == c2)
                        countBull++;
                    else {
                        arr1[c1 - '0']++;
                        arr2[c2 - '0']++;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    countCow += Math.min(arr1[i], arr2[i]);
                }
                System.out.println("Grade: " + countBull + " bulls and " + countCow + " cows");
                if (countBull == length) {
                    System.out.println("Grade: " + countBull + " bulls");
                    System.out.println("Congratulations! You guessed the secret code.");
                    b = false;
                    break;
                }
            }
        }
    }
}

