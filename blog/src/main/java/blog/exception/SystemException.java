package blog.exception;

public class SystemException extends BaseException{
    public SystemException(String code, String message) {
        this(code, message,null);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYSTEM"+code, "系统异常"+message, cause);
    }
}
