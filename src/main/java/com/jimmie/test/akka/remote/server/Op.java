package com.jimmie.test.akka.remote.server;

import java.io.Serializable;

public class Op {
	
	
	public interface MathOp extends Serializable { 
		
		public int getN1() ;
		
		public int getN2() ;
	}

	/**
	 * 
	 */
	
	public static class Add  implements MathOp{  
	    private static final long serialVersionUID = 1L;  
	    private final int n1;  
	    private final int n2;  
	  
	    public Add(int n1, int n2) {  
	        this.n1 = n1;  
	        this.n2 = n2;  
	    }  
	  
	    public int getN1() {  
	        return n1;  
	    }  
	  
	    public int getN2() {  
	        return n2;  
	    }  
	}
	
	public static class AddResult implements Serializable{
		 	/**
		 * 
		 */
		private static final long serialVersionUID = 416779692763168971L;
			private final int n1;  
		    private final int n2;  
		    
		    private int result;
		    
		    public int getResult() {
				return result;
			}

			public void setResult(int result) {
				this.result = result;
			}

			public int getN1() {
				return n1;
			}

			public int getN2() {
				return n2;
			}

			public AddResult(int n1, int n2,int result){
		    	 	this.n1 = n1;  
			        this.n2 = n2;  
			        this.result = result;
		    }
	
	}
	
}
