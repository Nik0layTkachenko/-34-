package task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class EnterCommand implements console command.
 */
public class EnterCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * Creates a new EnterCommand with the specified ViewTable.
     *
     * @param view the ViewTable.
     */
    public EnterCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Gets the key for this command.
     *
     * @return the key.
     */
    @Override
    public char getKey() {
        return 'X';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        return "(X) Enter";
    }

    /**
     * Executes this command.
     */
    @Override
    public void execute() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of numbers you want to enter, or anything else to enter 2 numbers:");
        int size;
        try {
            size = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            size = 2;
        }

        System.out.println("Enter your " + size + " numbers like this - +38 0xx xxx xx xx");
        String[] numbers = new String[size];
        for (int i = 0; i < size; i++) {
            try {
                numbers[i] = in.readLine();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }
        }
        System.out.print(view.viewInit(numbers));
    }
}
