package com.rozetka.steps.Variables;

public class Variables {
	private static Variables instance;
	
	public String searchTerm;
	
	private Variables(){		
	}
	
	public static synchronized Variables getVariables(){
		if(instance==null){
			instance = new Variables();
		}
		return instance;
	}
	

}
