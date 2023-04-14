package task04;

import java.util.Formatter;

/**
 * The class View table extends view result
 */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 20;
    private int width;

    /**
     * View table constructor with default width
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * View table constructor with custom width
     * @param width the width of the table
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Gets the width of the table
     * @return the width of the table
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the table
     * @param width the width of the table
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Prints a line of hyphens
     */
    private void outLine() {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
    }

    /**
     * Prints the header of the table
     */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Number", "Provider");
    }

    /**
     * Prints the body of the table
     */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        for (Provider item : getItems()) {
            System.out.printf(fmt.toString(), item.getNumber(), item.getProvider());
        }
    }

    /**
     * Initializes the view of the table
     * @param numbers the numbers
     * @param width the width of the table
     * @return the view of the table
     */
    public String viewInit(String[] numbers, int width) {
        this.viewInit(numbers); // calls the superclass method
        this.width = width;
        return viewShow();
    }

    /**
     * Shows the view of the table
     * @return the view of the table
     */
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
