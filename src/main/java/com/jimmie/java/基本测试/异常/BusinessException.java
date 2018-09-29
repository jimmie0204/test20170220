package com.jimmie.java.基本测试.异常;/**
 * Created by jimmie on 2018/9/13.
 */

/**
 * @author jimmie
 * @create 2018-09-13 下午7:58
 */

public class BusinessException extends RuntimeException{


    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                '}';
    }
}
