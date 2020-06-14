package example.springboot.dto;

/**
 * @Author: yangmingyang
 * @Date: 2020/5/26
 */
public enum BasicResponseStatus {
    SUCCESS(0, "SUCCESS"),
    FAIL(-1, "FAIL"),
    IO_EXCEPTION(-2, "IO_EXCEPTION");

    private int code;
    private String message;

    private BasicResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public BasicResponseStatus valueOf(int code) {
        switch(code) {
            case -1:
                return FAIL;
            case 0:
                return SUCCESS;
            default:
                return null;
        }
    }
}