package cn.yyb.driver.framework.exception;

/**
 */
public final class ApiException extends RuntimeException {

    private final String msg;

    public ApiException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
