package ie.atu.gitactionsweek5.errorHandling;


public class DuplicateException extends RuntimeException {

    private String message;
    private String field;


    public DuplicateException(String message) {

        super(message);
    }
}
