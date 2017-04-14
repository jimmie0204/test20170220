package com.jimmie.test.序列化.myserial;

import net.sf.cglib.beans.BeanMap;

public class SS extends Serializer{

	private LoginRequest login;
	
	private Integer code;
	
	@Override
	protected void read() {
		this.login = read(LoginRequest.class);
		this.code = readInt();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void write() {
		writeInt(code);
		writeMap(BeanMap.create(login));
		
	}

	public LoginRequest getLogin() {
		return login;
	}

	public void setLogin(LoginRequest login) {
		this.login = login;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	 

}
