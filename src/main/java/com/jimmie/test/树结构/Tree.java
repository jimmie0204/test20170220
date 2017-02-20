package com.jimmie.test.树结构;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Tree {

	//<id,node>
	public volatile Map<Integer, TreeNode> nodeMap = new ConcurrentHashMap<Integer, TreeNode>();
	//<pid,childNodes>
	public volatile Map<Integer, Set<TreeNode>> nodeChildMap = new ConcurrentHashMap<Integer, Set<TreeNode>>();

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	final Lock readlock = lock.readLock();

	final Lock writelock = lock.writeLock();

	private int rootId = 0;

	public Tree(){
		
	}
	
	//创建空树
	@Deprecated
	public Tree(int rootId) {
		this.rootId = rootId;
		
	}
	
	//用已有数据生成一棵树
	public Tree(List<TreeNode> nodeList){
		
		tree(nodeList);
	}

	

	public Set<TreeNode> getChildrenByPid(int pid){
		try {
			readlock.lock();
			return nodeChildMap.get(pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			readlock.unlock();
		}

	}
	
	public void addOrUpdateNode(TreeNode newNode,TreeNode oldNode){
		try {
			writelock.lock();
			System.out.println(Thread.currentThread().getName()
					+ "修改node ing。。。。nodeid为：" +newNode.getId()+",name="+newNode.getName());
			if(oldNode!=null&&(oldNode.getName()==null || oldNode.getName()==null)){
				throw new IllegalArgumentException("参入的oldNode参数错误");
			}
			if(newNode==null || newNode.getId()==null || newNode.getPId()==null || newNode.getName()==null){
				throw new IllegalArgumentException("参入的newNode参数错误");
			}
			
			if(nodeMap==null || nodeMap.size()==0){
				throw new Exception("treeNodeSet 未初始化");
			}
			
			if(nodeChildMap==null || nodeChildMap.size()==0){
				throw new Exception("nodeChildMap 未初始化");
			}
			
			if(oldNode!=null){
				nodeMap.remove(oldNode);
				nodeChildMap.get(oldNode.getPId()).remove(oldNode);
			}
			nodeMap.put(newNode.getId(), newNode);
			nodeChildMap.get(newNode.getPId()).add(newNode);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			writelock.unlock();
		}
	}
	
	private void tree(List<TreeNode> nodeList) {
		try {
			
			if(nodeList==null || nodeList.size()==0)
				throw new IllegalAccessException("nodeList 参数错误");
			
			nodeChildMap.clear();
			System.out.println("map clear....");
			
			Integer pidTemp;
			
			for(TreeNode node:nodeList){
				nodeMap.put(node.getId(), node);
				pidTemp = node.getPId();
				if(pidTemp==null) continue;
				
				if(nodeChildMap.get(pidTemp)==null){
					Set<TreeNode> set = new HashSet<TreeNode>();
					set.add(node);
					nodeChildMap.put(pidTemp, set);
				}else{
					nodeChildMap.get(pidTemp).add(node);
				}
			}
			
		}catch(IllegalArgumentException e){
			throw e; 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//树高
	public int height(){
	
		return nodeChildMap==null?0:nodeChildMap.size();
	}

}