package com.jimmie.test.树结构.tree1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreeTest {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException {
		
		final TreeEnum tree = TreeEnum.INSTACNE.setTransfer(null);
		
		for(int i=0;i<30;i++){
			exec.submit(new Runnable() {
				
				@Override
				public void run() {
//					tree.init();
					System.out.println(tree.getChildrenByPid(101).size());
				}
			});
		}
		
		tree.addOrUpdateNode(null,new TreeNode(9999, "jimmie", 101));
		
		Thread.sleep(5000);
		/*		System.out.println(tree.nodeMap.size());
		System.out.println(tree.getChildrenByPid(0));
		System.out.println(tree.getChildrenByPid(100));*/
		System.out.println(tree.getChildrenByPid(101));
//		System.out.println(tree.getChildrenByPid(0).get(0).getChildren().get(0).getName());

	}

}
