
import java.util.Scanner;


public class PersonalInfoService {
    
    private UserData userData;

    // Constructor
    public PersonalInfoService(UserData userData) {
        this.userData = userData;
    }

    // Method to enter the User's Personal Information
    public void enterPersonalInfo() {

        System.out.println("Testing: Inside enterPersonalInfo");

        // Declare our variables before we ask for input
        int age;
        double weight_lbs;
        int height_cm;
        int activityLevel;
        char gender;
        String dateOfEntryString;

        Scanner scanner = new Scanner(System.in);           // Intialize scanner object

        //_______________________
        // Gender Input
        //_______________________

        while (true) {
            System.out.println("Please ENTER your Gender: (M) Male or (F) Female: ");       // Prompt Gender
            gender = scanner.next().charAt(0);                                              // Read in Gender
            
            // Invalid Character choice
            if ( (gender != 'M') || (gender != 'F') ) {
                System.out.println("Error! You entered an INVALID GENDER selection! Try Again!");
                continue;
            }

            break;

        }

        //________________________
        // Age Input
        //________________________

        while (true) {

            System.out.print("Please ENTER your AGE: ");      
            age = scanner.nextInt();

            // User Enters Invalid Age
            if (age <= 0) {
                System.out.println("Error! You entered an INVALID AGE! Try Again!");        // prompt age
                continue;                                                                   // read in age
            }
            break;

        }

        //_______________________
        // Weight Input
        //_______________________    

        while (true) {
            System.out.print("Please ENTER your weight (IN LBS): ");                        // prompt weight
            weight_lbs = scanner.nextDouble();                                              // read in wieght

            // User enters invalid weight
            if (weight_lbs <= 0) {
                System.out.println("Error! You entered an INVALID WEIGHT! Try Again!");
                continue;
            }
            
            break;
        }

        //_______________________
        // Height Input
        //_______________________

        while (true) {
            System.out.print("Please ENTER your Heigth (IN CM): ");                         // prompt height
            height_cm = scanner.nextInt();                                                  // read in height

            // User enters invalid Height
            if (height_cm <= 0) {
                System.out.println("Error! You entered an INVALID HEIGHT! Try Again!");
                continue;
            }
            
            break;
        }

    
        //_______________________
        // Activity Level Input
        //_______________________

        while (true) { 

            // Prompt For Activity Level
            System.out.println("Select your Activity Level:\n");
            System.out.println("  1. Sedentary        — little or no exercise");
            System.out.println("  2. Light            — exercise 1-3 times per week");
            System.out.println("  3. Moderate         — exercise 4-5 times per week");
            System.out.println("  4. Active           — daily exercise or intense exercise 3-4 times per week");
            System.out.println("  5. Very Active      — intense exercise 6-7 times per week");
            System.out.println("  6. Extra Active     — very intense exercise daily, or physical job\n");
            System.out.print("Enter the number that corresponds to your activity level: ");

            // read in choice
            activityLevel = scanner.nextInt();

            // invalid Choice
            if ( (activityLevel > 6) || (activityLevel <= 0) ) {
                System.out.println("You entered an INVALID SELECTION! Try Again!");
                continue;
            }

            break;

        }

        //_______________________
        // Date Of Entry Input
        //_______________________

        System.out.println("Please Enter the Date Of Entry (ex. 8/25/2025): ");
        dateOfEntryString = scanner.nextLine();

        // _______________________________
        // Construct the Personal Info Data
        // _______________________________
        UserData.PersonalInfo personalInfo = new UserData.PersonalInfo(age, weight_lbs, height_cm, activityLevel, gender, dateOfEntryString);
        userData.setPersonalInfo(personalInfo);     // Update the UserData


        
        // Close scanner object
        scanner.close();
    }

}