package org.callblog.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.callblog.model.response.BasicResponse;
import org.callblog.model.response.ErrorResponse;
import org.callblog.model.response.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<? extends BasicResponse> processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode ValidationErrors = mapper.createObjectNode();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");

            ValidationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse<>(StatusEnum.UNPROCESSABLE_ENTITY, "V001", builder.toString(), ValidationErrors));
    }

    @ExceptionHandler(CallblogCommonException.class)
    public ResponseEntity<? extends BasicResponse> processErrorResponse(CallblogCommonException exception) {

        return ResponseEntity.badRequest().body(exception.getBasicResponse());
    }
}
