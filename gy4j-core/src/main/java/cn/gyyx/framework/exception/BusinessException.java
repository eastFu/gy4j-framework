package cn.gyyx.framework.exception;

public class BusinessException extends RuntimeException{
    
    public BusinessException(String message){
        super(message);
    }
}
