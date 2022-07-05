package com.sfnotificator.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchHomeworkException.class)
    public ResponseEntity<HomeworkIncorrectData> handlerException(NoSuchHomeworkException exception) {
        HomeworkIncorrectData data = new HomeworkIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

    }
}
