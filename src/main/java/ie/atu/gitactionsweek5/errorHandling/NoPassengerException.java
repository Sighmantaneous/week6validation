package ie.atu.gitactionsweek5.errorHandling;


public class NoPassengerException extends RuntimeException {

    private String message;
    private String field;

        public NoPassengerException(String message) {

            super(message);

        }

        }
