package com.jonas;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonUni {

	public static void main(String[] args) throws IOException, ParseException {
		
		int encodeTipe;
		String result= null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Encode: unicode - [1] " +" '\\x6e' - [2]" );
		
		encodeTipe=sc.nextInt();
		
		
		
		BufferedReader JsonBuff = new BufferedReader(new FileReader("/Users/jonas/eclipse-workspace/JsonFile/src/com/jonas/file1.json"));
	    

	        JSONParser parser = new JSONParser();
	        Object obj = (Object) parser.parse(JsonBuff);
	        JSONObject jsonObj = (JSONObject) obj;
	        
	        
	      if(encodeTipe == 1) {
	    	  result = StringUnicodeEncoder.encodeStringToUnicodeSequence(jsonObj.toString());
	    	  try {
					FileWriter fileWriter = new FileWriter("/Users/jonas/eclipse-workspace/JsonFile/src/com/jonas/file2.json");
					fileWriter.write(result.toString().replace("\\u0074\\u0072\\u0075\\u0065","true"));
					fileWriter.flush();
					System.out.println("DONE");
					fileWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }else if(encodeTipe == 2) {
	    	  result = StringGeneratorEncoder.encodeStringToUnicodeSequence(jsonObj.toString());
	    	  try {
					FileWriter fileWriter = new FileWriter("/Users/jonas/eclipse-workspace/JsonFile/src/com/jonas/file2.json");
					fileWriter.write(result.toString().replace("\\x74\\x72\\x75\\x65","true"));
					fileWriter.flush();
					System.out.println("DONE");
					fileWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }else {
	    	  System.out.println("incorrect");
	      }
	      sc.close();
	     
	        
	        System.out.println(result);
	        
	        
 
	       
			
	        
	}

}
