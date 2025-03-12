package exception;

/**
 * Handles Roboast-specific problems
 */
public class RoboastException extends Exception{
    /**
     * Initializer for Exception
     * @param message the message showing what went wrong
     */
    public RoboastException(String message){

        super(message);
    }

    /**
     * For printing purposes
     * @return the string that gets printed
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
