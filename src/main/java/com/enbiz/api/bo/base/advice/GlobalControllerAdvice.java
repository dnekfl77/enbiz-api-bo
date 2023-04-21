package com.enbiz.api.bo.base.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.common.base.exception.AppException;
import com.enbiz.common.base.exception.MessageResolver;
import com.enbiz.common.base.exception.ValidationException;
import com.enbiz.common.base.rest.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
@ResponseBody
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Exception e, HttpServletRequest request) {
		log.error("", e);
		return new ErrorResponse(ApiError.UNKNOWN.getCode(), MessageResolver.getMessage(ApiError.UNKNOWN));
    }
	
	@ExceptionHandler(AppException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleAppException(AppException e, HttpServletRequest request, Model model) {
		log.warn("AppException: [{}] {}", e.getErrorCode(), e.getErrorMessage());
		log.warn("", e);
		return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

	/**
     * ValidationException 오류처리
     */
    @ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(ValidationException e, HttpServletRequest request){
        log.warn(e.getMessage(), e);
		return new ErrorResponse(ApiError.VALIDATION_EXCEPTION.getCode(), e.getMessage());
    }
    
	/**
     * @valid  유효성체크에 통과하지 못하면  MethodArgumentNotValidException 이 발생한다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse methodValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        log.warn("", e);
        ApiError appError = getBindingError(e.getBindingResult());
		return new ErrorResponse(appError.getCode(), MessageResolver.getMessage(appError));
    }
    
    private ApiError getBindingError(BindingResult bindingResult){
        //에러가 있다면
        if(bindingResult.hasErrors()){
            //DTO에 유효성체크를 걸어놓은 어노테이션명을 가져온다.
            String bindResultCode = bindingResult.getFieldError().getCode();

            switch (bindResultCode) {
                case "NotNull":
                    return ApiError.BINDING_ERROR_NOT_NULL;
                default:
                    return ApiError.BINDING_ERROR;
            }
        }

        return ApiError.UNKNOWN;
    }    
    
}
