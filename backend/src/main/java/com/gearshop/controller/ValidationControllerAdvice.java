package com.gearshop.controller;

import com.gearshop.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.gearshop.constant.MessageType.ERROR;
import static java.util.Locale.ENGLISH;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ValidationControllerAdvice {

    private final MessageSource messageSource;

    @Autowired
    public ValidationControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<Message> processValidationError(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<Message> errors = new ArrayList<>(violations.size());

        for (ConstraintViolation<?> violation : violations) {
            String text = messageSource.getMessage(violation.getMessage(), null, ENGLISH);
            errors.add(new Message(ERROR, text));
        }
        return errors;
    }
}
