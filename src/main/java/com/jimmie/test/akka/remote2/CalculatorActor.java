package com.jimmie.test.akka.remote2;

import akka.actor.UntypedActor;

/**
 * 计算加减乘除的Actor getSender getSelf
 */
public class CalculatorActor extends UntypedActor {

	@Override
	public void preStart() throws Exception {
		System.out.println("一个CalculatorActor被创建。。。。。。。。。。。。。。。。");
	}

	@Override
	public void onReceive(Object message) {

		if (message instanceof Op.Add) {
			// try {
			// Thread.sleep(4000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			Op.Add add = (Op.Add) message;
			System.out.println("Calculating " + add.getN1() + " + " + add.getN2());
			Op.AddResult result = new Op.AddResult(add.getN1(), add.getN2(), add.getN1() + add.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Op.Subtract) {
			Op.Subtract subtract = (Op.Subtract) message;
			System.out.println("Calculating " + subtract.getN1() + " - " + subtract.getN2());
			Op.SubtractResult result = new Op.SubtractResult(subtract.getN1(), subtract.getN2(),
					subtract.getN1() - subtract.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Op.Multiply) {
			Op.Multiply multiply = (Op.Multiply) message;
			System.out.println("Calculating " + multiply.getN1() + " * " + multiply.getN2());
			Op.MultiplicationResult result = new Op.MultiplicationResult(multiply.getN1(), multiply.getN2(),
					multiply.getN1() * multiply.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Op.Divide) {
			Op.Divide divide = (Op.Divide) message;
			System.out.println("Calculating " + divide.getN1() + " / " + divide.getN2());
			Op.DivisionResult result = new Op.DivisionResult(divide.getN1(), divide.getN2(),
					divide.getN1() / divide.getN2());
			getSender().tell(result, getSelf());

		} else {
			unhandled(message);
		}
	}
}