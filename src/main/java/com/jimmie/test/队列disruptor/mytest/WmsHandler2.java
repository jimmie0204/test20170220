package com.jimmie.test.队列disruptor.mytest;

import com.lmax.disruptor.WorkHandler;

/**
 * 订单
 * @author Administrator
 *
 */
public class WmsHandler2 implements WorkHandler<Order>{

	@Override
	public void onEvent(Order event) throws Exception {
		if(event.getOrderNo().equalsIgnoreCase("order1")){
			throw new Exception("WmsHandler2 消费报错");
		}
		
		if(event.getStatus()!=2){
			System.out.println("WmsHandler2获取的状态错误------"+event.getStatus());
			return ;
		}
		
		System.out.println(event.getOrderNo()+"推送wms成功=====WmsHandler2");
		event.setStatus((byte) 3);
		
	}

}
