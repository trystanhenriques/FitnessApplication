import java.util.Calendar;

public class UserData {

    private PersonalInfo personalInfo;

    // setters
    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
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

        // setters
        public void setAge(int age) {this.age = age;}
        public void setWeight_lbs(int weight) {this.weight_lbs = weight;}
        public void setHeight_cm(int height) {this.height_cm = height;}
        public void setActivityLevel(int activityLevel) {this.activityLevel = activityLevel;}
        public void setGender(char gender) {this.gender = gender;}

    }
        
}