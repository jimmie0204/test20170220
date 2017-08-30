package com.jimmie.java.数据结构和算法.树;

public class BinarySortTreeTest {

	public static void main(String[] args) {
		BSTree<Integer> tree = new BSTree<Integer>();
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50,48 };
		int length = a.length;
		for(int i=0;i<length;i++){
			tree.insert(a[i]);
		}

		System.out.println("排序结果：" );
		tree.inOrder();
		System.out.println("=======================");
		System.out.println("树顶：" +tree.getMRoot());
		tree.print();
		System.out.println("48的前驱节点：" +tree.predecessor(tree.search(48)));
		System.out.println("删除节点：" );
		tree.remove(46);
		tree.print();
		
	}
}
