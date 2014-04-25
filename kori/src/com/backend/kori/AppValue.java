package com.backend.kori;

public class AppValue {
	
	public static String getValue(String name){
		
		if(name.equals("UserDatabase")){
			return "C:\\JavaDev\\Users";
		}
		
		return "";
	}
	
	public static void setValue(String name, String value){
		
	}
	
}
