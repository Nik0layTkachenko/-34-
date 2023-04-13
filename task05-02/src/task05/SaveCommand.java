package task05;

import java.io.IOException;

/**
 * The class Save command implements console command
 */
public class SaveCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * Save command
     *
     * @param view the view
     * @return public
     */
    public SaveCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Gets the key
     *
     * @return the key
     */
    @Override
    public char getKey() {
        return 'A';
    }

    /**
     * To string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "(A)Save";
    }

    /**
     * Execute
     */
    @Override
    public void execute() {
        try {
            view.viewSave();
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }
        System.out.println(view.viewShow());
    }
}