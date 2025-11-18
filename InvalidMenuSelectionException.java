public class InvalidMenuSelectionException extends Exception
{
    public InvalidMenuSelectionException (String errorMsg) {
        super("Error! " + errorMsg);
    }

}