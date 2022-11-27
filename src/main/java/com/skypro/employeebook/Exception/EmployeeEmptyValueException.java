package com.skypro.employeebook.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Не все поля заполнены")
public class EmployeeEmptyValueException extends RuntimeException {

}
