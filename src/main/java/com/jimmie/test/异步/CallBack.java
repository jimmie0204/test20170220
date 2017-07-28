package com.jimmie.test.异步;

public interface CallBack<V> {

	public void onCancel();
	
	public void onSuccess(V result);
	
	public void onFailure(Throwable t);
}
