package com.jimmie.test.对象池;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class ZeusPool{

	 private GenericObjectPool<Zeus> basePool;
	 
	 public ZeusPool(PooledObjectFactory<Zeus> factory,ZeusPoolConfig config){
		 basePool = new GenericObjectPool<Zeus>(factory,config);
		 initPool(config.getInitNum());
	 }
	 
	 private void initPool(Integer initNum) {
		if(initNum>0){
			Zeus[] zeus = new Zeus[initNum];
			for(int i=0;i<initNum;i++){
			    zeus[i] =getResource();
				System.out.println(zeus[i].getAge());
				System.out.println(zeus[i]);
			}
			
			for(int i=0;i<initNum;i++){
			    returnResource(zeus[i]);
			}
			
		}
		
	}

	public Zeus getResource(){
		 Zeus zeus = null;
		 try {
			zeus = basePool.borrowObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zeus;
	 }
	 
	 public void returnResource(Zeus zeus){
		 basePool.returnObject(zeus);
	 }
}
