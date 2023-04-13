package task05;

/**
 * The class Restore command implements console command
 */
public class RestoreCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * Restore command
     *
     * @param view the view
     * @return public
     */
    public RestoreCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Gets the key
     *
     * @return the key
     */
    @Override
    public char getKey() {
        return 'W';
    }

    /**
     * To string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "(W)Restore";
    }

    /**
     * Execute
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