package example.spring.dto;

/**
 * @Author: yangmingyang
 * @Date: 2020/5/26
 */
public class BasicException extends RuntimeException {
    private int code;

    public BasicException() {
    }

    public BasicException(int code, String message) {
        super(message);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}

