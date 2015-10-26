package com.rozetka.thucydides.steps.Variables;

import java.util.HashMap;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class Variables {
	private static Variables instance;
	
	private HashMap<String, String> keyValue = new HashMap<String, String>();
	
	private Variables(){		
	}
	
	private static synchronized Variables getVariables(){
		if(instance==null){
			instance = new Variables();
		}
		return instance;
	}
	
	public static String getValue(String key){
		if(getVariables().keyValue.containsKey(key)){
			return getVariables().keyValue.get(key);
		}else return null;
	}
	
	public static void putValue(String key, String value){
		if(getVariables().keyValue.containsKey(key)){
			getVariables().keyValue.replace(key, value);
		}else {
			getVariables().keyValue.put(key, value);
		}
	}

}
