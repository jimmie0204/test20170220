package com.jimmie.test.树结构;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreeTest {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException {
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		// Test
		// 从数据库查询所有记录节点
		nodeList.add(new TreeNode(0,"中国",null));
		nodeList.add(new TreeNode(100, "北京市", 0));
		nodeList.add(new TreeNode(101, "山东省", 0));
		nodeList.add(new TreeNode(201, "东城区", 100));
		nodeList.add(new TreeNode(202, "西城区", 100));
		nodeList.add(new TreeNode(203, "朝阳区", 100));
		nodeList.add(new TreeNode(210, "烟台市", 101));
		nodeList.add(new TreeNode(211, "青岛市", 101));

		
		final Tree tree = new Tree(nodeList);
		
		for(int i=0;i<20;i++){
			exec.submit(new Runnable() {
				
				@Override
				public void run() {
					
					System.out.println(tree.getChildrenByPid(101).size());;
				}
			});
		}
		
		tree.addOrUpdateNode(new TreeNode(9999, "jimmie", 101),null);
		
		Thread.sleep(5000);
		System.out.println(tree.nodeMap.size());
		System.out.println(tree.height());
		System.out.println(tree.getChildrenByPid(0));
		System.out.println(tree.getChildrenByPid(100));
		System.out.println(tree.getChildrenByPid(101));
		
		tree.addOrUpdateNode(new TreeNode(9999, "jimmie", 100),new TreeNode(9999, "jimmie", 101));
		System.out.println(tree.nodeMap.size());
		System.out.println(tree.height());
		System.out.println(tree.getChildrenByPid(0));
		System.out.println(tree.getChildrenByPid(100));
		System.out.println(tree.getChildrenByPid(101));
		

	}

}
