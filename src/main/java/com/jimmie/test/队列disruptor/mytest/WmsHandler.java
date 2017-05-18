package com.jimmie.test.队列disruptor.mytest;

import com.lmax.disruptor.WorkHandler;

/**
 * 订单
 * @author Administrator
 *
 */
public class WmsHandler implements WorkHandler<Order>{

	@Override
	public void onEvent(Order event) throws Exception {
		if(event.getOrderNo().equalsIgnoreCase("order1")){
			throw new Exception("WmsHandler 消费报错");
		}
		
		if(event.getStatus()!=2){
			System.out.println("WmsHandler获取的状态错误------"+event.getStatus());
			return ;
		}
		
		System.out.println(event.getOrderNo()+"推送wms成功=====WmsHandler");
		event.setStatus((byte) 3);
		
	}

}
