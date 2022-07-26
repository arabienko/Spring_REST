package by.arabienko.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WorkerGlobalExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<WorkerIncorrectData> handlingException
            (NoSuchWorkerException exception){
        WorkerIncorrectData workerIncorrectData =
                new WorkerIncorrectData();
        workerIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(workerIncorrectData,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<WorkerIncorrectData> handlingException
            (Exception exception){
        WorkerIncorrectData workerIncorrectData =
                new WorkerIncorrectData();
        workerIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(workerIncorrectData,
                HttpStatus.BAD_REQUEST);
    }

}
