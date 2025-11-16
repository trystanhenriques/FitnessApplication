import java.util.ArrayList;

public class Menu {

    class MenuNode {

        String label;                   // label of the menu shown to the users
        ArrayList<MenuNode> submenus;

        // Constructor
        public MenuNode(String label) {
            this.label = label;
            this.submenus = new ArrayList<>();
        }

        // Method to add a node to the current node
        public void addSubMenu(MenuNode nd) {
            submenus.add(nd);               // add a submenu to the current menu option
        }

    }

    MenuNode root;

    // Constructor to build the entire menu structure
    public Menu() {
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
        MenuNode menu_personalInfo_enter = new MenuNode("Enter Personal Info");
        MenuNode menu_personalInfo_activity = new MenuNode("Activity Level");
        MenuNode menu_personalInfo_view = new MenuNode("View Personal Info");
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
}