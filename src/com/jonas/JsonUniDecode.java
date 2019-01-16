package com.jonas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUniDecode {
	
	
	
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader JsonBuff = new BufferedReader(new FileReader("/Users/jonas/eclipse-workspace/JsonFile/src/com/jonas/file2.json"));
	    

        JSONParser parser = new JSONParser();
        Object obj = (Object) parser.parse(JsonBuff);
        JSONObject jsonObj = (JSONObject) obj;
        
        
        String result = jsonObj.toString();
       
        
        
        
        try {
			FileWriter fileWriter = new FileWriter("/Users/jonas/eclipse-workspace/JsonFile/src/com/jonas/fileDeCode2.json");
			fileWriter.write(result);
			fileWriter.flush();
			fileWriter.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
	}
	
	


}
