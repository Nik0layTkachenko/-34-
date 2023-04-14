package task06;

import java.util.concurrent.TimeUnit;

/**
 * The class Execute command implements console command
 */
public class ExecuteCommand implements ConsoleCommand {
    private ViewResult view;

    /**
     * Gets the view
     * @return the view
     */
    public ViewResult getView() {
        return view;
    }

    /**
     * Sets the view
     * @param view the view
     * @return ViewResult
     */
    public ViewResult setView(ViewResult view) {
        return this.view = view;
    }

    /**
     * Execute command
     * @param view the view
     * @return public
     */
    public ExecuteCommand(ViewResult view) {
        this.view = view;
    }

    /**
     * Gets the key
     * @return the key
     */
    @Override
    public char getKey() {
        return 'S';
    }

    /**
     * To string
     * @return String
     */
    @Override
    public String toString() {
        return "(S)Execute";
    }

    /**
     * Execute
     */
    @Override
    public void execute() {
        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        TrendCommand trendCommand = new TrendCommand(view);
        WrongCommand wrongCommand = new WrongCommand(view);

        System.out.println("Execute all threads...");

        queue1.put(trendCommand);
        queue2.put(wrongCommand);

        try {
            // Wait for both threads to finish
            while (trendCommand.running() || wrongCommand.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            // Shut down the command queues
            queue1.shutdown();
            queue2.shutdown();

            // Wait a second before continuing
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("All done.");
    }
}
