package task04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private ViewTable view;

    public Main(ViewTable view) {
        this.view = view;
    }


    private void menu() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;
        while (!quit) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Enter a phone number");
            System.out.println("2. Save current phone numbers");
            System.out.println("3. Restore last saved phone numbers");
            System.out.println("4. Quit");

            String choice = "";
            try {
                choice = in.readLine();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }

            switch (choice) {
                case "1":
                    System.out.println("Enter your phone number:");
                    String phoneNumber = "";
                    try {
                        phoneNumber = in.readLine();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                        System.exit(0);
                    }
                    String result = view.viewInit(new String[]{phoneNumber});
                    System.out.println(result);
                    break;
                case "2":
                    try {
                        view.viewSave();
                        System.out.println("Phone numbers saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    break;
                case "3":
                    try {
                        view.viewRestore();
                        System.out.println("Phone numbers restored successfully.");
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    /**
     * A method to run the program
     * @param args  the args
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Main main;
        System.out.println("Enter the width of the table, or press Enter to set the default width:");
        String input = "";
        int width;
        try {
            input = in.readLine();
        } catch(Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }

        try {
            width = Integer.parseInt(input);
            main = new Main(new ViewTable(width));
        } catch (NumberFormatException ex){
            main = new Main(new ViewTable());
        }

        main.menu();
    }
}