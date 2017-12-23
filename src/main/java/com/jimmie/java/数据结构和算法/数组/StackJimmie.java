package com.jimmie.java.数据结构和算法.数组;

//push\pop\get_max
public class StackJimmie {

	public int[] table;
	
	public int last;
	
	public int[] tableMax;
	
	public StackJimmie(){
		table = new int[16];
		tableMax = new int[16];
	}
	
	public StackJimmie(int captity){
		table = new int[Math.abs(captity)];
		tableMax = new int[Math.abs(captity)];
	}
	
	public void push(int data){//TODO 扩容
		if(last==0){
			tableMax[0]=data;
		}else if(last>0){
			if(data>tableMax[last-1])
				tableMax[last] = data;
			else
				tableMax[last] = tableMax[last-1];
		}
		
		table[last++]=data;
	}
	
	public int pop(){
		
		 int top = table[--last];
		 return top;
	}

	
	public int getMax(){
		return tableMax[last-1];
	}
	
	public String toString(){
		StringBuffer buff = new StringBuffer();
		for(int i=0;i<table.length;i++){
			buff.append(table[i]+"，");
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		StackJimmie s = new StackJimmie();
		s.push(12);
		s.push(2);
		s.push(35);
		s.push(17);
		
		System.out.println(s);
		System.out.println(s.getMax());
		s.pop();
		System.out.println(s);
		System.out.println(s.getMax());
		s.pop();
		System.out.println(s);
		System.out.println(s.getMax());
	}
	
}
