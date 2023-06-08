package pro.sky.hw2_5kcollectionlistssets.Service.Exeption;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeStorageIsFullException extends RuntimeException {             //привышен лимит кол ва сотрудников
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
