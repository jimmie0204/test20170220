package com.jimmie.test.树结构.tree1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreeTest2 {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException {
		
		final TreeEnum tree = TreeEnum.INSTACNE;
		tree.setTransfer(null);
		for(int i=0;i<2;i++){
			exec.submit(new Runnable() {
				
				@Override
				public void run() {
					
					tree.getChildrenByPid(0);
				}
			});
		}
		
//		tree.init(null);
		
		Thread.sleep(5000);
		System.out.println(tree.nodeMap.size());
		System.out.println(tree.getChildrenByPid(0));
		System.out.println(tree.getChildrenByPid(100));
		System.out.println(tree.getChildrenByPid(101));

	}

}
