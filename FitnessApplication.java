public class FitnessApplication {
    public static void main(String[] args) {
        
        UserData userData = new UserData();                                             // Initialize User Data
        PersonalInfoService personalInfoService = new PersonalInfoService(userData);    // Initialize Personal Info Service

        Menu menu = new Menu(personalInfoService);
        menu.start();
    }
}