package task05;

/**
 * The class View command implements console command
 */
public class ViewCommand implements ConsoleCommand {
    private ViewTable view;

    /**
     * View command
     *
     * @param view the view
     * @return public
     */
    public ViewCommand(ViewTable view) {
        this.view = view;
    }

    /**
     * Gets the key
     *
     * @return the key
     */
    @Override
    public char getKey() {
        return 'Z';
    }

    /**
     * To string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "(Z)View";
    }

    /**
     * Execute
     */
    @Override
    public void execute() {
        System.out.println(view.viewShow());
    }
}