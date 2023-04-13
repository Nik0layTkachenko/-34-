package task05;

import java.util.Formatter;

/**
 * The class View table extends view result
 */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 60;

    private int width;

    /**
     * View table constructor
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * View table constructor with width parameter
     * @param width the width
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Gets the width
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Prints a line of dashes for the table
     */
    private void outLine() {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
    }

    /**
     * Prints the table header
     */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Number", "Provider");
    }

    /**
     * Prints the table body
     */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        for(Provider item : getItems()) {
            System.out.printf(fmt.toString(), item.getNumber(), item.getProvider());
        }
    }

    /**
     * Initializes the view
     * @param numbers the numbers
     * @param width the width
     * @return String
     */
    public String viewInit(String[] numbers, int width) {
        this.viewInit(numbers);
        this.width = width;
        return viewShow();
    }

    @Override
    public String viewShow() {
        outHeader();
        outLine();
        System.out.println();
        outBody();
        outLine();
        return "\n";
    }
}
