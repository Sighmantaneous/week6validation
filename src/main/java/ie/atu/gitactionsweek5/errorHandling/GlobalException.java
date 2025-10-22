
package ie.atu.gitactionsweek5.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <List<ExceptionDetails>> showErrorDetails(MethodArgumentNotValidException mae)
    {
        List<ExceptionDetails> errors = new ArrayList<>();
        for(FieldError fieldError : mae.getBindingResult().getFieldErrors()) {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.setFieldName(fieldError.getField());
            exceptionDetails.setFieldMessage(fieldError.getDefaultMessage());
            errors.add(exceptionDetails);
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionDetails> showDupError(DuplicateException de){

        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setFieldName("passengerId");
        exceptionDetails.setFieldMessage(de.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDetails);

    }
    @ExceptionHandler(NoPassengerException.class)
    public ResponseEntity<ExceptionDetails> DoesNotExist(NoPassengerException np){
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setFieldName("PassengerId");
        exceptionDetails.setFieldMessage(np.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDetails);
    }


}
