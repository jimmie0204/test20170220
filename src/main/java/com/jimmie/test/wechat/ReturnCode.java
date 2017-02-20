package com.jimmie.test.wechat;

import java.util.HashMap;
import java.util.Map;

public enum ReturnCode {
	
	ACTIVE_EXCEPTION(-1, "异常"),
    ACTIVE_SUCCESS(01, "操作成功"),
    ACTIVE_FAILURE(02, "操作失败"),
    ERROR_PARAMS_NOT_NULL(03, "参数不能为空"),
    ERROR_HEADER_NOT_NULL(04, "请求头不能为空"),
    REQUEST_SUCCESS(200,"请求成功"),
    ERROR_PARAMS(400, "请求失败"),
    ERROR_AUTH(401, "无权限"),
    ERROR_PARAMS_DECRYPT(402, "参数解密失败"),
    ERROR_WRONG(403, "用户无法使用此系统"),
    ERROR_RESOURCES(404, "请求资源不存在"),
    ERROR_SERVER(503, "系统异常"),
    ERROR_USER_TYPE_ERROR(1111, "用户类型参数错误"),
    ERROR_OUTSIDE_INTERFACE(1112,"调用外部接口失败"),
    ERROR_PARAMS_ERROR(1113,"参数验证错误"),
    ERROR_NO_CHANGE_STATUS_ERROR(1115,"此订单状态不允许更改"),
	ERROR_NO_DATA(1114,"没有找到对应的数据");
	
	private int code;
	
	private String msg;
	
	private ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCode codeToEnum(int code) {

        ReturnCode[] values = ReturnCode.values();
        for (ReturnCode returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return ACTIVE_EXCEPTION;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, ?> Map() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code, Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":").append(this.code).append(",");
        sb.append("\"msg\":\"").append(this.msg).append("\"}");

        return sb.toString();
    }
	

}
