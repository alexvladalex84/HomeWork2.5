package pro.sky.hw2_5kcollectionlistssets.Service.Exeption;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ArrayIsFull extends RuntimeException {
    public ArrayIsFull(String message) {
        super(message);
    }
}
