package pl.polsl.aleksander.mekail.exceptions;

/**
 *custom exception class for handling negative value passed as size.
 *
 * @author Aleksander Mekail
 * @version 2.0
 */
public class NegativeNumberException extends Exception {

    private String s;

    /**
     * Exception for negative number input.
     * @param s the string for the exception.
     */
    public NegativeNumberException(String s){
        this.s=s;
    }

    /**
     * prints the error.
     */
    public void printError()
{
    System.out.println(s);
}
}
