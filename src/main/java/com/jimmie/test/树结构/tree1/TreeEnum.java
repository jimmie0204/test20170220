package com.jimmie.test.树结构.tree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum TreeEnum {

	INSTACNE;

	private volatile List<TreeNode> treeNodeList = new ArrayList<TreeNode>();;

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

	public TreeEnum setTransfer(NodeTransfer transfer) {
		this.transfer = transfer;
		return this;
	}

	private TreeEnum() {

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
		List<TreeNode> childrenTreeNode = new ArrayList<TreeNode>();
		for (TreeNode item : treeNodeList) {
			if (item.getParentId() != null
					&& item.getParentId() == nodeId) {
				childrenTreeNode.add(item);
			}
		}
		nodeMap.put(nodeId, childrenTreeNode);

		return childrenTreeNode;
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
	

	public List<TreeNode> getChildrenByPid(int pid){
		try {
			readlock.lock();
			if(nodeMap==null || nodeMap.size()==0){
				try {
					readlock.unlock();
					writelock.lock();
					if(nodeMap==null || nodeMap.size()==0){
						System.out.println(Thread.currentThread().getName()
								+ "修改map ing。。。。nodeMap为：" + (nodeMap==null?0:nodeMap.size()));
						init();
					}
					readlock.lock();
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
	
	public void addOrUpdateNode(TreeNode oldNode,TreeNode newNode){
		try {
			writelock.lock();
			System.out.println(Thread.currentThread().getName()
					+ "修改node ing。。。。nodeid为：" +newNode.getId()+",name="+newNode.getName());
			if(oldNode!=null&&(oldNode.getName()==null || oldNode.getName()==null)){
				throw new IllegalArgumentException("参入的oldNode参数错误");
			}
			if(newNode==null || newNode.getId()==null || newNode.getParentId()==null || newNode.getName()==null){
				throw new IllegalArgumentException("参入的newNode参数错误");
			}
			
			if(treeNodeList==null || treeNodeList.size()==0){
				throw new Exception("treeNodeList 未初始化");
			}
			
			if(nodeMap==null || nodeMap.size()==0){
				throw new Exception("nodeMap 未初始化");
			}
			
			if(oldNode!=null){
				treeNodeList.remove(oldNode);
				nodeMap.get(oldNode.getParentId()).remove(oldNode);
			}
			treeNodeList.add(newNode);
			nodeMap.get(newNode.getParentId()).add(newNode);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			writelock.unlock();
		}
	}
	
	public void init() {
		try {
			initLock.lock();
			
//			treeNodeList = transfer.transfer();

			// Test
			// 从数据库查询所有记录节点
			treeNodeList.add(new TreeNode(0,"中国",null));
			treeNodeList.add(new TreeNode(100, "北京市", 0));
			treeNodeList.add(new TreeNode(101, "山东省", 0));
			treeNodeList.add(new TreeNode(201, "东城区", 100));
			treeNodeList.add(new TreeNode(202, "西城区", 100));
			treeNodeList.add(new TreeNode(203, "朝阳区", 100));
			treeNodeList.add(new TreeNode(210, "烟台市", 101));
			treeNodeList.add(new TreeNode(211, "青岛市", 101));
			
			nodeMap.clear();
			System.out.println("map clear....");
			if (treeNodeList != null && treeNodeList.size() != 0) {
				generateTreeNode(root);
			}
		}catch(IllegalArgumentException e){
			throw e; 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			initLock.unlock();
		}

	}

}