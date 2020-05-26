package example.springboot.dto;

/**
 * @Author: yangmingyang
 * @Date: 2020/5/26
 */
public class CodeMessage {
    private int code;
    private String message;

    public CodeMessage() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
