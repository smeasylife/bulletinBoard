package sbb.example.demo.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//이 예외가 발생하면 HttpStatus.NOT_FOUND와 entity not found 메시지를 생성해서 클라이언트에게 반환한다.
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message){
        super(message);
    }
}
