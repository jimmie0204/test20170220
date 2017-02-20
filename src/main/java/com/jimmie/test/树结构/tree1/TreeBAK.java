package com.jimmie.test.树结构.tree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum TreeBAK {

	INSTACNE;

	private List<TreeNode> treeNodeList;

	public volatile Map<Integer, List<TreeNode>> nodeMap = new ConcurrentHashMap<Integer, List<TreeNode>>();

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	final Lock readlock = lock.readLock();

	final Lock writelock = lock.writeLock();

	private Lock initLock = new ReentrantLock();

	private final int root = 0;

	private NodeTransfer transfer;

	public NodeTransfer getTransfer() {
		return transfer;
	}

	public void setTransfer(NodeTransfer transfer) {
		this.transfer = transfer;
	}

	private TreeBAK() {

	}

	/**
	 * 
	 * @param nodeId
	 * @return
	 */
	public TreeNode getNodeById(int nodeId) {
		TreeNode treeNode = new TreeNode();
		for (TreeNode item : treeNodeList) {
			if (item.getId() == nodeId) {
				treeNode = item;
				break;
			}
		}
		return treeNode;
	}

	/**
	 * 
	 * @param nodeId
	 * @return
	 */
	public List<TreeNode> getChildrenNodeById(int nodeId) {
		List<TreeNode> childrenTreeNode = null;

		readlock.tryLock();
		try {
			childrenTreeNode = nodeMap.get(nodeId);
		} catch (Exception e) {
			readlock.unlock();
		}

		System.out.println(Thread.currentThread().getName()
				+ "从map中获取的childrenTreeNode为：" + childrenTreeNode);
		if (childrenTreeNode == null) {
			readlock.unlock();
			writelock.lock();
			try {
				childrenTreeNode = nodeMap.get(nodeId);
				if (childrenTreeNode == null) {
					childrenTreeNode = new ArrayList<TreeNode>();
					for (TreeNode item : treeNodeList) {
						if (item.getParentId() != null
								&& item.getParentId() == nodeId) {
							childrenTreeNode.add(item);
						}
					}
					nodeMap.put(nodeId, childrenTreeNode);
					System.out.println(Thread.currentThread().getName()
							+ "修改map ing。。。。Key为：" + nodeId);
					System.out.println(Thread.currentThread().getName()
							+ "修改map ing。。。。Value值list大小为："
							+ (childrenTreeNode == null ? 0 : childrenTreeNode
									.size()));
				}
			} catch (Exception e) {
				writelock.unlock();
			}

			readlock.lock();
			writelock.unlock();
		}
		readlock.unlock();

		return childrenTreeNode;
	}

	public List<TreeNode> getChildrenByPid(int pid){
		try {
			readlock.lock();
			System.out.println(Thread.currentThread().getName()
							+ "修改map ing。。。。nodeMap为：" + nodeMap);
			if(nodeMap==null || nodeMap.size()==0){
				try {
					readlock.unlock();
					writelock.lock();
					if(nodeMap==null || nodeMap.size()==0){
						init();
					}
//					readlock.lock();
				} finally{
					writelock.unlock();
				}
			}
			return nodeMap.get(pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			readlock.unlock();
		}

		
	}
	/**
	 * 递归生成Tree结构数据
	 * 
	 * @param rootId
	 * @return
	 */
	public TreeNode generateTreeNode(int rootId) {
		TreeNode root = this.getNodeById(rootId);
		System.out.println(Thread.currentThread().getName() + "获取的root为:"
				+ root.getName());
		List<TreeNode> childrenTreeNode = this.getChildrenNodeById(rootId);
		for (TreeNode item : childrenTreeNode) {
			TreeNode node = this.generateTreeNode(item.getId());
			root.getChildren().add(node);
		}
		return root;
	}
	

	public void init() throws IllegalArgumentException {
		try {
			initLock.lock();
			/*
			 * if(transfer==null) throw new
			 * IllegalArgumentException("transfer参数不能为空！");
			 * 
			 * treeNodeList = transfer.transfer();
			 */

			// Test
			treeNodeList = new ArrayList<TreeNode>();// 从数据库查询所有记录节点
			 treeNodeList.add(new TreeNode(0,"中国",null));
			treeNodeList.add(new TreeNode(100, "北京市", 0));
			treeNodeList.add(new TreeNode(101, "山东省", 0));
			treeNodeList.add(new TreeNode(201, "东城区", 100));
			treeNodeList.add(new TreeNode(202, "西城区", 100));
			treeNodeList.add(new TreeNode(203, "朝阳区", 100));
			treeNodeList.add(new TreeNode(210, "烟台市", 101));
			treeNodeList.add(new TreeNode(211, "青岛市", 101));

			if (treeNodeList != null && treeNodeList.size() != 0) {
				nodeMap.clear();
				generateTreeNode(root);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			initLock.unlock();
		}

	}

}