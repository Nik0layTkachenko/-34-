package task05;

import java.io.IOException;

/**
 * The interface View defines methods that a view should implement.
 */
public interface View {
    
    /**
     * Displays the current state of the view.
     *
     * @return a string representation of the view
     */
    public String viewShow();
    
    /**
     * Initializes the view with an array of numbers.
     *
     * @param numbers an array of numbers to initialize the view with
     * @return a string representation of the initialized view
     */
    public String viewInit(String[] numbers);
    
    /**
     * Saves the current state of the view.
     *
     * @throws IOException if there is an error during serialization
     */
    public void viewSave() throws IOException;
    
    /**
     * Restores the view to a previously saved state.
     *
     * @throws Exception if there is an error during deserialization
     */
    public void viewRestore() throws Exception;
}
