package Staging.pakages;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class RandomDataGenerator {



	private static String startDate;
	// public static void main(String[] args) {
//	        RandomDataGenerator generator = new RandomDataGenerator();
//
//	        // Generate random data
////	        String randomName = generator.generateRandomName();
//	        String randomPhoneNumber = generator.generateRandomPhoneNumber();
//	        String randomEmail = generator.generateRandomEmail();
//	        String randomDOB = generator.generateRandomDOB();
//
//	        // Print the generated data
//	        System.out.println("Random Name: " + generateRandomName());
//	        System.out.println("Random Phone Number: " + generateRandomPhoneNumber());
//	        System.out.println("Random Email: " + randomEmail);
//	        System.out.println("Random Date of Birth: " + randomDOB);
//	    }
	
	  public static String generateRandomName() {
	        Random random = new Random();
	        String firstName = generateRandomString(random, 5);
	        String lastName = generateRandomString(random, 8);
	        String fullname =capitalize(firstName) + " " + capitalize(lastName);
	        return fullname;
//	        return capitalize(firstName) + " " + capitalize(lastName);
	    }

	    // Method to generate a random phone number
	    public static String generateRandomPhoneNumber() {
	        Random random = new Random();
	        int firstDigit = random.nextInt(5) + 5;
	        String phoneNumber = String.valueOf(firstDigit);

	        // Append the rest of the digits for the phone number (assuming 10 digits total)
	        for (int i = 0; i < 9; i++) {
	            phoneNumber += random.nextInt(10);
	        }

	        return phoneNumber.toString();
	    }

	    public static String generateRandomPrimaryNumber() {
	        Random random = new Random();
	        int firstDigit = random.nextInt(4) + 1;
	        String primaryNumber = String.valueOf(firstDigit);

	        // Append the rest of the digits for the phone number (assuming 10 digits total)
	        for (int i = 0; i < 9; i++) {
	        	primaryNumber += random.nextInt(10);
	        }

	        return primaryNumber.toString();
	    }
	    // Method to generate a random email address
	    public static String generateRandomEmail() {
	        Random random = new Random();
	        String username = generateRandomString(random, 8);
	        String domain = generateRandomString(random, 6);
	        return username + "@" + domain + ".com";
	    }

	    // Method to generate a random date of birth (DOB) in the format "YYYY-MM-DD"
		// Method to generate a random date of birth (DOB) in the format "YYYY-MM-DD"
		public static  String generateRandomDOB() {
			if (startDate == null) {
				Random random = new Random();
				int day = random.nextInt(28) + 1;
				int month = random.nextInt(12) + 1;
				int year = random.nextInt(99) + 1906; // Generate a year between 1970 and 1999
				// Generate a month between 1 and 12
				// Generate a day between 1 and 28 (for simplicity, assuming all months have 28 days)
				startDate =String.format("%02d-%02d-%04d", day, month,year);
			}
			return startDate;

		}

	public static String generateEndDOB() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date StartDate = sdf.parse(startDate);

		// Calculate end date by adding 5 years to the start date
		Date endDate = new Date(StartDate.getTime() + (5L * 365 * 24 * 60 * 60 * 1000)); // Adding milliseconds

		return sdf.format(endDate);
	}

	    // Helper method to generate a random string of given length
	    private static String generateRandomString(Random random, int length) {
	        String characters = "abcdefghijklmnopqrstuvwxyz";
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            sb.append(characters.charAt(index));
	        }
	        return sb.toString();
	    }

	    // Helper method to capitalize the first letter of a string
	    private static String capitalize(String str) {
	        if (str == null || str.isEmpty()) {
	            return str;
	        }
	        return str.substring(0, 1).toUpperCase() + str.substring(1);
	    }
	

	
	
	

}
