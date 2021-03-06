package com.jimmie.test.wechat;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code = ReturnCode.ACTIVE_FAILURE.code();
	private Object attach;

	public ResponseDTO() {

	}

	public ResponseDTO(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.attach = returnCode.msg();
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.attach = returnCode.msg();
	}

	public ReturnCode nowReturnCode() {// 此处不能写getxx,会被spring 识别然后返回出去
		return ReturnCode.codeToEnum(code);
	}

	public ResponseDTO(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getAttach() {
		return attach;
	}

	public void setAttach(Object attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", attach=" + attach + "]";
	}
	
}