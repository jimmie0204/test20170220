package com.jimmie.test.树结构;


class TreeNode {

	private Integer id;
	
	private String name;
	
	private Integer pId;
	
	public TreeNode(){

	}
	public TreeNode(Integer id, String name, Integer pId) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
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

	public Integer getPId() {
		return pId;
	}

	public void setPId(Integer pId) {
		this.pId = pId;
	}

	
	@Override
	public boolean equals(Object obj){
		TreeNode node_ = (TreeNode)obj;
		return (node_.getName()==this.getName()&&node_.getPId()==this.getPId());
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
		
	}
	
	@Override
	public String toString(){
		return "( id="+id+", name="+name+", pId="+pId+" )";
	}
	
}
