package utils;

import java.util.Random;

public class RandomStringGenerationUtils {

    public static String generatePhoneNumber() {
        Random random = new Random();

        // Generate the first digit of the phone number (range: 5-9)
        int firstDigit = random.nextInt(5) + 5;
        System.out.println("first digit: " + firstDigit);


        // Generate the remaining 9 digits of the phone number
        StringBuilder phoneNumberBuilder = new StringBuilder();
        phoneNumberBuilder.append(firstDigit);

        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10);
            phoneNumberBuilder.append(digit);
        }

        return phoneNumberBuilder.toString();
    }


}
