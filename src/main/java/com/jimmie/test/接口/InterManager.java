package com.jimmie.test.接口;

public class InterManager {

	
    private volatile Helper helper;
    
    Tool getTool() throws Exception
    {
        return (helper != null) ? helper.getTool() : null;
    }

    
    public void reset(){
    	helper = new Helper(){
    		private Tool tool = null;
    		
    		@Override
    		public Tool getTool() {
    			if(tool==null){
    				tool = new Tool();
    			}
    			/*helper = new Helper(){

					@Override
					public Tool getTool() {
						// TODO Auto-generated method stub
						return tool;
					}
    				
    			};*/
				return tool;
    		}
    	};
    }
}
