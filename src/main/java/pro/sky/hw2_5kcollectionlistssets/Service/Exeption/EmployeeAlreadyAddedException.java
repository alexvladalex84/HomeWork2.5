package pro.sky.hw2_5kcollectionlistssets.Service.Exeption;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeAlreadyAddedException extends RuntimeException {              //уже есть такой сотрудник

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
