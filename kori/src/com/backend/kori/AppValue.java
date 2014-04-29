package com.backend.kori;
/*
 * TODO: Write the daam thing!
 * 
 * holds application wide variables.
 * 
 */
public class AppValue {
	
	public static String getValue(String name){
		
		if(name.equals("UserDatabase")){
			return "users.dat";
		}
		
		return "";
	}
	
	public static void setValue(String name, String value){
		
	}
	
}
