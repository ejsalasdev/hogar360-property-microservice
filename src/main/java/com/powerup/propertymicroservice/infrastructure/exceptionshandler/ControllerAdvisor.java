package com.powerup.propertymicroservice.infrastructure.exceptionshandler;

import com.powerup.propertymicroservice.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(InvalidFormatExcepcion.class)
    public ResponseEntity<ExceptionResponse> handleInvalidFormatExcepcion(InvalidFormatExcepcion exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
    
    @ExceptionHandler(NameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxSizeExceededException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxSizeExceededException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleElementAlreadyExistsException(ElementAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException(ElementNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(RequiredFieldNullOrEmptyException.class)
    public ResponseEntity<ExceptionResponse> handleRequiredFieldNullOrEmpty(RequiredFieldNullOrEmptyException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidNameFormatException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidNameFormatException(InvalidNameFormatException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
    
    @ExceptionHandler(InvalidPageNumberException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidPageNumberException(InvalidPageNumberException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
    
    @ExceptionHandler(InvalidPageSizeException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidPageSizeException(InvalidPageSizeException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
    
    @ExceptionHandler(ElementAmbiguousNameException.class)
    public ResponseEntity<ExceptionResponse> handleElementAmbiguousNameException(ElementAmbiguousNameException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

}
