package Exeptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid socks request")
public class InvalidArgumentExeption extends RuntimeException {
    public InvalidArgumentExeption(String message) {
        super(message);
    }
}
