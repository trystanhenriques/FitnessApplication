import java.util.Calendar;
import java.util.Scanner;

public class NutritionTrackerService
{
    private UserData userData;

    // Constructor
    public NutritionTrackerService(UserData userData) {
        this.userData = userData;
    }

    public void addFoodItem(Scanner scanner) {
        
        String nameOfFood;
        int calories;
        int quantity;
        String mealType;
        String dateOfEntryString;
        Calendar dateOfEntry;

        System.out.print("Please ENTER the Name Of the Food you want to enter: ");
        nameOfFood = scanner.nextLine();

        System.out.print("Please ENTER the amount of Calories In This Food Item: ");
        calories = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Please ENTER Quantity of the Food Item: ");
        quantity = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Please ENTER the Meal Type (Breakfast, Lunch, Dinner): ");
        mealType = scanner.nextLine();

        System.out.print("Please Enter the Date Of Entry (ex. 8/25/2025): ");
        dateOfEntryString = scanner.nextLine();

        UserData.FoodEntry foodEntry = new UserData.FoodEntry(nameOfFood, calories, quantity, mealType);    // construct food entry

        dateOfEntry = constructDateOfEntry(dateOfEntryString);  // construct date of entry string to valid calendar object

        userData.addFoodEntry(dateOfEntry, foodEntry);          // add that food entr to our map

    }

    // small helper mthod to convert a dateOfEnteryString to a valid dateOfEntry calendar object
    private Calendar constructDateOfEntry(String dateOfEnteryString) {
        
        Calendar dateOfEntry = Calendar.getInstance();
        dateOfEntry.clear();                                         // Epoch

        String[] dateOfEntryTokens = dateOfEnteryString.split("/");    // Turn the String into tokens

        // Parse each part into integers
        int month = Integer.parseInt(dateOfEntryTokens[0]) - 1;        // Months Starts with 0
        int day = Integer.parseInt(dateOfEntryTokens[1]);
        int year = Integer.parseInt(dateOfEntryTokens[2]);

        // Set the date
        dateOfEntry.set(year, month, day);                           // Set the Calendar object based on the fields

        return dateOfEntry;
    }

}