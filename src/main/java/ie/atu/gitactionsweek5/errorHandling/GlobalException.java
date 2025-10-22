
package ie.atu.gitactionsweek5.errorHandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String showErrorDetails(MethodArgumentNotValidException mae){

        return "There is an issue";
    }
}
