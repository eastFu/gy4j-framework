package cn.gyyx.framework.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
    public BusinessException(Throwable throwable){
        super(throwable);
    }
    public BusinessException(String message,Throwable throwable){
        super(message,throwable);
    }
}
