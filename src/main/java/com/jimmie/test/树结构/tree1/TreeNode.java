package com.jimmie.test.树结构.tree1;

import java.util.HashSet;
import java.util.Set;

class TreeNode {

	private Integer id;
	
	private String name;
	
	private Integer parentId;
	
	private Set<TreeNode> children;
	
	public TreeNode(){
		this.children = new HashSet<TreeNode>();
	}
	public TreeNode(Integer id, String name, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.children = new HashSet<TreeNode>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Set<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeNode> children) {
		this.children = children;
	}
	
	@Override
	public boolean equals(Object obj){
		TreeNode node_ = (TreeNode)obj;
		return (node_.getName()==this.getName()&&node_.getParentId()==this.getParentId());
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
		
	}
	
}
