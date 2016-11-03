/**
 * InvalidMessageException
 * 
 * Throws this exception if there is an invalid message.
 */

public class InvalidMessageException extends Exception
{
    /**
     * Constructor for objects of class InvalidMessageException
     */
    public InvalidMessageException(String error)
    {
        super("Invalid Message!");
    }
}
