import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    class MenuNode {

        private String label;                   // label of the menu shown to the users
        private ArrayList<MenuNode> submenus;
        private Runnable action;                // optional action used by the menu (only used if the menu has no submenus)

        // Constructor
        public MenuNode(String label) {
            this.label = label;
            this.submenus = new ArrayList<>();
        }
        
        // getters
        public MenuNode getChild(int idx) {
                    return submenus.get(idx);
        }

        public String getLabel() {return label;}

        // Method to add a node to the current node
        public void addSubMenu(MenuNode nd) {
            submenus.add(nd);               // add a submenu to the current menu option
        }

        // To check if this menu node has as submenus?
        public boolean hasSubMenus() {
            return !submenus.isEmpty();      // Checks whether the sumbmenus array is empty
        }

        // TO check if the menu has an action
        public boolean hasAction() {
            return action != null;
        }

        // Method to get the number of submenus that the menu Node has
        public int numOfSubmenus()
        {
            return submenus.size();
        }
        
        // Method to run the action
        public void runAction()
        {
            System.out.println("DEBUG: running action for " + label);
            if (action != null) {
                action.run();
            }
            else {
                System.out.println("DEBUG: NO ACTION SET!");
            }
        }

        // Method to set the action of a menu option
        public void setAction(Runnable action)
        {
            this.action = action;
        }

    
    }

    private MenuNode root;
    private Scanner scanner;

    // Constructor to build the entire menu structure
    public Menu(PersonalInfoService personalInfoService) {

        scanner = new Scanner(System.in);               // Initialize scanner object

        // Create Root Menu Node / Main Menu
        root = new MenuNode("Main Menu");

        //========================================================================================
        // Menu Options:
        //========================================================================================


        //__________________________________________________________________________________________
        // Personal info:
        //__________________________________________________________________________________________

        // Create the PERSONAL INFO menu option node and its submenus
        MenuNode menu_personalInfo = new MenuNode("Personal Info");

        // Construct submenus for Personal Info
        //______________________________________

        // Enter Peronsal Info
        MenuNode menu_personalInfo_enter = new MenuNode("Enter Personal Info");
        menu_personalInfo_enter.setAction(() -> personalInfoService.enterPersonalInfo(scanner));     // set the enter personal info action

        MenuNode menu_personalInfo_activity = new MenuNode("Activity Level");

        // View Personal Info 
        MenuNode menu_personalInfo_view = new MenuNode("View Personal Info");
        menu_personalInfo_view.setAction(() -> personalInfoService.viewPersonalInfo(scanner));

        MenuNode menu_personalInfo_remove = new MenuNode("Remove A Personal Info Entry");

        // Add submenus for Personal Menu Node
        menu_personalInfo.addSubMenu(menu_personalInfo_enter);
        menu_personalInfo.addSubMenu(menu_personalInfo_activity);
        menu_personalInfo.addSubMenu(menu_personalInfo_view);
        menu_personalInfo.addSubMenu(menu_personalInfo_remove);

        // Add the Personal Info Node to the Root Node
        root.addSubMenu(menu_personalInfo);

        //__________________________________________________________________________________________
        // Workouts:
        //__________________________________________________________________________________________

        // Create the WORKOUTS menu option and its submenues
        MenuNode menu_workouts = new MenuNode("Workout Manager");

        //----
        
        // WORKOUTS -> Manage List of All Workouts
        MenuNode menu_workouts_manage = new MenuNode("View / Manage List of All Workouts");

        // Construct submeues for Workouts -> Manage 
        MenuNode menu_workouts_manage_view = new MenuNode("View List of Preset Workouts");
        MenuNode menu_workouts_manage_create = new MenuNode("Create Your Own Workout Routine");
        MenuNode menu_workouts_manage_delete = new MenuNode("Delete a Created Workout Routine");
        MenuNode menu_workouts_manage_edit = new MenuNode("Edit a Specific Exercise in a Specific Routine");

        // Add submenues for Workouts -> Manage List of All Workouts
        menu_workouts_manage.addSubMenu(menu_workouts_manage_view);
        menu_workouts_manage.addSubMenu(menu_workouts_manage_create);
        menu_workouts_manage.addSubMenu(menu_workouts_manage_delete);
        menu_workouts_manage.addSubMenu(menu_workouts_manage_edit);

        // add View and Manage as submenu of the Workouts node
        menu_workouts.addSubMenu(menu_workouts_manage);

        //----

        // WORKOUTS -> Start Tracking Workout

        // Construct submenu for Workouts -> Start Tracking Workout
        MenuNode menu_workouts_tracking = new MenuNode("Start Tracking Workout");

        // Add submenue to Workouts 
        menu_workouts.addSubMenu(menu_workouts_tracking);

        //----

        // WORKOUTS -> View List Of Past Workouts
        MenuNode menu_workouts_viewPast = new MenuNode("View List Of Past Workouts");

        // Add submenu to Workouts
        menu_workouts.addSubMenu(menu_workouts_viewPast);

        //----

        // Add the Workouts Node to the Root Node
        root.addSubMenu(menu_workouts);


        //__________________________________________________________________________________________
        // Nutrition Tracker:
        //__________________________________________________________________________________________

        // Construct Create the NUTRITION TRACKER menu option and its submenus
        MenuNode menu_nutritionTracker = new MenuNode("Nutrition Tracker");

        //---

        // Nutrition Tracker - > Food Tracker

        // Construct Food Tacker Node
        MenuNode menu_nutritionTracker_food = new MenuNode("Food Tracker");

        // Construct Food Tracker menu's submenus
        MenuNode menu_nutritionTracker_food_add = new MenuNode("Add a Food Item");
        MenuNode menu_nutritionTracker_food_view = new MenuNode("View Food Items");
        MenuNode menu_nutritionTracker_food_remove = new MenuNode("Remove Food Item");
        MenuNode menu_nutritionTracker_food_edit = new MenuNode("Edit Entry of a Food Item");

        // Add submenus to parent(Food Tracker)
        menu_nutritionTracker_food.addSubMenu(menu_nutritionTracker_food_add);
        menu_nutritionTracker_food.addSubMenu(menu_nutritionTracker_food_view);
        menu_nutritionTracker_food.addSubMenu(menu_nutritionTracker_food_remove);
        menu_nutritionTracker_food.addSubMenu(menu_nutritionTracker_food_edit);

        // Add Foodtracker menu node to its parent(Nutrition Tracker)
        menu_nutritionTracker.addSubMenu(menu_nutritionTracker_food);

        //---

        // Nutrition Trakcer - Nutrition Stats

        // COnstruct Nutrition Stats menu option
        MenuNode menu_nutritionTracker_stats = new MenuNode("Nutrition Stats");

        menu_nutritionTracker.addSubMenu(menu_nutritionTracker_stats);

        //----

        // Add the Nutrition Tracker Node to the Root Node
        root.addSubMenu(menu_nutritionTracker);

        //__________________________________________________________________________________________
        // Goals
        //__________________________________________________________________________________________

        // Construct Create the GOALS menu option and its submenus
        MenuNode menu_goals = new MenuNode("Goals");

        //----
        // Goals -> Set Fitness goals
        MenuNode menu_goals_set = new MenuNode("Set Fitness Goals");

        // set submenu to parent menu
        menu_goals.addSubMenu(menu_goals_set);

        //----
        // Goals -> View Goals
        MenuNode menu_goals_view = new MenuNode("View Goals");

        // set submenu to parent menu
        menu_goals.addSubMenu(menu_goals_view);

        //----
        // Goals -> Update A Goal
        MenuNode menu_goals_update = new MenuNode("Update A Goal");

        // set submenu to parent menu
        menu_goals.addSubMenu(menu_goals_update);

        //----
        // Goats -> Delete a Goal
        MenuNode menu_goals_delete = new MenuNode("Delete a Goal");

        // set submenu to parent menu
        menu_goals.addSubMenu(menu_goals_delete);

        //---

        // Add the Goals Node to the Root Node
        root.addSubMenu(menu_goals);

    }

    private void printStartHeader()
    {
        System.out.println("===================================");
        System.out.println("      FITNESS APPLICATION         ");
        System.out.println("===================================\n");

    }

    private void printMenuNodeHeader(MenuNode nd)
    {
        System.out.println("\n===================================");
        System.out.println("         " + nd.getLabel() + "         ");
        System.out.println("===================================\n");
    }

    // TO start the application
    public void start() {
        //printStartHeader();     // Header
        navigate(root);
    }

    // Prints the menu nodes Submenues
    private void printSubMenus(MenuNode nd)
    {

        for (int i = 0; i < nd.numOfSubmenus(); i++) {
            int menuOptionNumber = i+1;
            System.out.println(menuOptionNumber + ": " + nd.getChild(i).label);
        }

        if (nd != root)
            System.out.println("0: Go Back");               // All submenus besided the main menu should have a "Go Back" option
            System.out.println("-1: Exit Application");     // All menus should have an exit application option
    }

    // Method to navigate through the menu
    public void navigate(MenuNode currentnd)
    {

        while (true) {
            
            //Print the header for the current menu node
            printMenuNodeHeader(currentnd);
        
            // Print the children of the current node. (we will likely call navigate with root as the first parameter)
            printSubMenus(currentnd);

            // Get input From the user
            System.out.print("Enter Your Menu Choice: ");
            int choice = scanner.nextInt();                         // get the choice from the user

            // Validate the users choice
            //___________________________

            try {

                //Case where the choice is <0 or > number of submenus
                if (choice < -1 || choice > currentnd.numOfSubmenus()) {
                    throw new InvalidMenuSelectionException("Menu Choice does not exist");
                }

                // Case where the 
                if (currentnd == root && choice == 0) {
                    throw new InvalidMenuSelectionException("You cannot go back at this point");
                }
                
            } catch (InvalidMenuSelectionException e) {
                System.out.println("Something Went Wrong: " + e.getMessage());     // print error message to the user
                continue;                                           // reprint the menu and its options
            
            } catch (Exception e) {
                System.out.println("Error! " + e.getMessage());     // print error message to the user
                continue; 
            }
            

            // Case where the user chose option '0': Go Back
            if (choice == 0) {
                return;
            }
            
            // Case where the user chose option '-1': Exit Application
            if (choice == -1) {
                System.out.println("Exiting Fitness Application! Goodbye!");
                System.exit(0);
            }

            
            MenuNode selectedMenu = currentnd.getChild(choice-1);  // the menu option the user selected

            // Go to the next submenu if it has one; else do the action
            if (selectedMenu.hasSubMenus()) {
                // Go to the menu the user chose
                navigate(selectedMenu);                 // the index of the child is 1 less than choice because children is stored in 0 based indexing
            }
            // DO the action
            else {
                
                printMenuNodeHeader(selectedMenu);  // print header for selected menu

                System.err.println("Testing: Do The Action");
                selectedMenu.runAction();
                navigate(currentnd);      // after the action is done, return to the current menu
            }

        }
    }  

    //getters
    public MenuNode getRoot() {return root;}


}