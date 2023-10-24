package in.bushansirgur.expensetrackerapi.exceptions;

import in.bushansirgur.expensetrackerapi.entity.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ItemAlreadyExistsException(String message) {
        super(message);
    }

}
