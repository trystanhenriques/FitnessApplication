import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

public class UserData {

    private ArrayList<PersonalInfo> personalInfos = new ArrayList<>(10);                                // list of personal info entries
    private HashMap<Calendar, LinkedList<FoodEntry>> foodEntriesByDate = new HashMap<>();      // Map of (Key: Date of Entry) --> (Value: Food Entry)

    public void addPersonalInfoEntry(PersonalInfo personalInfo) {
        personalInfos.add(personalInfo);
    }
    public ArrayList<PersonalInfo> getPersonalInfos() {return personalInfos;}
    public int numOfPerosonalInfoEntries() {return personalInfos.size();}
    public HashMap<Calendar, LinkedList<FoodEntry>> getFoodEntriesByDate() {return foodEntriesByDate;}

    public void addFoodEntry(Calendar dateOfEntry, FoodEntry foodEntry) {
        
        LinkedList<FoodEntry> foodEntryList;

        // Check if theres food entries for that date. If so, add the food entry to the list 
        if (foodEntriesByDate.containsKey(dateOfEntry)) {
            foodEntryList = foodEntriesByDate.get(dateOfEntry);       // retrive the list of food entries for that date
            foodEntryList.add(foodEntry);                       // add that food entry to the list of food entries for that date
            return;
        }

        // Case where Date was not found. Add a date entry  and create a new list
        foodEntryList = new LinkedList<FoodEntry>();
        foodEntryList.add(foodEntry);
        foodEntriesByDate.put(dateOfEntry, foodEntryList);
        
    }

    public static class PersonalInfo {

        private int age;
        private double weight_lbs;
        private Calendar dateOfEntry;
        private int height_cm;
        private int activityLevel;
        private char gender; // Male (m) or Female (f)
        
        // Constructor
        public PersonalInfo(int age, double weight, int height, int activityLevel, char gender, String dateOfEntryString)
        {
            this.age = age;
            this.weight_lbs = weight;
            this.height_cm = height;
            this.activityLevel = activityLevel;
            this.gender = gender;

            // Turn the date of entry string into a valid date
            constructDateOfEntry(dateOfEntryString);

        }

        // small helper mthod to convert a dateOfEnteryString to a valid dateOfEntry calendar object
        private void constructDateOfEntry(String dateOfEnteryString) {
            dateOfEntry = Calendar.getInstance();
            dateOfEntry.clear();                                         // Epoch

            String[] dateOfEntryTokens = dateOfEnteryString.split("/");    // Turn the String into tokens

            // Parse each part into integers
            int month = Integer.parseInt(dateOfEntryTokens[0]) - 1;        // Months Starts with 0
            int day = Integer.parseInt(dateOfEntryTokens[1]);
            int year = Integer.parseInt(dateOfEntryTokens[2]);

            // Set the date
            dateOfEntry.set(year, month, day);                           // Set the Calendar object based on the fields
        }

        // getters
        public int getAge() {return age;}
        public double  getWeight_lbs() {return weight_lbs;}
        public int getHeight_cm() {return height_cm;}
        public int getActivityLevel() {return activityLevel;}
        public char getGender() {return gender;}
        
        public String getActivityLevelString() {
            switch (activityLevel) {
                case 1:
                    return "Sedentary        - little or no exercise";
                case 2:
                    return "Light            - exercise 1-3 times per week";
                case 3:
                    return "Moderate         - exercise 4-5 times per week";
                case 4:
                    return "Active           - daily exercise or intense exercise 3-4 times per week";
                case 5:
                    return "Very Active      - intense exercise 6-7 times per week";
                case 6:
                    return "Extra Active     - very intense exercise daily, or physical job";
                default:
                    throw new AssertionError();
            }
        }


        // setters
        public void setAge(int age) {this.age = age;}
        public void setWeight_lbs(int weight) {this.weight_lbs = weight;}
        public void setHeight_cm(int height) {this.height_cm = height;}
        public void setActivityLevel(int activityLevel) {this.activityLevel = activityLevel;}
        public void setGender(char gender) {this.gender = gender;}

    }

    public static class FoodEntry {

        private String nameOfFood;
        private int calories;
        private int quantity;
        private String mealType;            // breakfast, lunch, or dinner, etc

        // Constructor
        public FoodEntry(String nameOfFood, int calories, int quantity, String mealType) {
            this.nameOfFood = nameOfFood;
            this.calories = calories;
            this.quantity = quantity;
            this.mealType = mealType;
            
        }

        // getters
        public String getNameOfFood() {return nameOfFood;}
        public int getCalories() {return calories;}
        public int getQuantity() {return quantity;}
        public String getMealType() {return mealType;}

        // setters
        public void setNameOfFood(String nameOfFood) {this.nameOfFood = nameOfFood;}
        public void setCalories(int calories) {this.calories = calories;}
        public void setQuantity(int quantity) {this.quantity = quantity;}
        public void setMealType(String mealType) {this.mealType = mealType;}

    }
        
}