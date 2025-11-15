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
        public void addChild(MenuNode nd) {
            submenus.add(nd);               // add a submenu to the current menu option
        }

    }

    


    

}