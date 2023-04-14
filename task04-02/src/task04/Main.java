package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A base class that calls other classes
 */
public class Main {
    private ViewTable view;

    public Main(ViewTable view) {
        this.view = view;
    }

    /**
     * Menu method for ease of use
     */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            // Выводим меню
            System.out.println("Make your choice...");
            System.out.print("(Z)Quit, (X)Enter number, (C)Save number, (W)Restore: ");

            try {
                s = in.readLine();
            } catch(IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }

            // Проверяем выбор пользователя и вызываем соответствующий метод
            switch (s.charAt(0)) {
                case 'Z':
                    System.out.println("Quit.");
                    break;
                case 'X':
                    int size = 2;
                    System.out.println("Enter your " + size + " numbers like this - +38 0xx xxx xx xx");
                    String[] numbers = new String[size];
                    for(int i = 0; i < size; i++) {
                        try {
                            numbers[i] = in.readLine();
                        } catch(IOException e) {
                            System.out.println("Error: " + e);
                            System.exit(0);
                        }
                    }
                    System.out.print(view.viewInit(numbers));
                    break;
                case 'C':
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    System.out.println(view.viewShow());
                    break;
                case 'W':
                    System.out.println("Restore last saved.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    System.out.println(view.viewShow());
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'Q');
    }

    /**
     * A method to run the program
     * @param args the args
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Main main;
        System.out.print("Enter the width of the table, or print anything else if you want to set the default number: ");
        String s = "";
        int width;
        try {
            s = in.readLine();
        } catch(Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }

        // Создаем экземпляр класса Main и передаем ему экземпляр ViewTable
        try {
            width = Integer.parseInt(s);
            main = new Main(new ViewTable(width));
        } catch (NumberFormatException ex){
            main = new Main(new ViewTable());
        }

        // Запускаем меню
        main.menu();
    }
}
