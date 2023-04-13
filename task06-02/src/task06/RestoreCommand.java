package task06;

/**
 * The RestoreCommand class implements the ConsoleCommand interface.
 */
public class RestoreCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * Constructor for RestoreCommand class.
     *
     * @param view the ViewTable object
     */
    public RestoreCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Returns the key associated with this command.
     *
     * @return the key associated with this command
     */
    @Override
    public char getKey() {
        return 'W';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return a string representation of this command
     */
    @Override
    public String toString() {
        return "(W)estore";
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.out.println("Deserialization error: " + e);
        }
        System.out.println(view.viewShow());
    }
}
