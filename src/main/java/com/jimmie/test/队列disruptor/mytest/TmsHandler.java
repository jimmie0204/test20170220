package com.jimmie.test.队列disruptor.mytest;

import com.lmax.disruptor.WorkHandler;

/**
 * 订单
 * @author Administrator
 *
 */
public class TmsHandler implements WorkHandler<Order>{

	@Override
	public void onEvent(Order event) throws Exception {
		
		if(event.getOrderNo().equalsIgnoreCase("order1")){
			throw new Exception("TmsHandler 消费报错");
		}
		
		if(event.getStatus()!=1){
			System.out.println("TmsHandler获取的状态错误------"+event.getStatus());
			return ;
		}
		
		if(event.getOrderNo().equalsIgnoreCase("order3")){
			System.out.println("我是第三个单子，我要休眠五秒中===============TmsHandler");
			Thread.sleep(5000);
		}
		
		System.out.println(event.getOrderNo()+"获取运单号成功=====TmsHandler");
		event.setStatus((byte) 2);
		
	}

}
