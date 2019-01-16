package com.jonas;


public class StringUnicodeEncoder {
    private final static String UNICODE_PREFIX = "\\u";

    public static String encodeStringToUnicodeSequence(String txt) {
        StringBuilder result = new StringBuilder();
        char char1 = '{';
        char char2 = '"';
        char char3 = ':';
        char char4 = '[';
        char char5 = ',';
        char char6 = '}';
        char char7 = ']';
        char char8 = '1';
        
        
        if (txt != null && !txt.isEmpty()) {
            for (int i = 0; i < txt.length(); i++) {
            	
            	if(Character.codePointAt(txt, i)== char1 ) {
            		
            		result.append(char1+"\n");
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                }else if (Character.codePointAt(txt, i)== char2 ){
                	result.append(char2);
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                	
                }else if(Character.codePointAt(txt, i)== char3 ){
                	result.append(char3);
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                }else if(Character.codePointAt(txt, i)== char4 ){
                	result.append(char4);
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                }else if(Character.codePointAt(txt, i)== char5 ){
                	result.append(char5+"\n");
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                }else if(Character.codePointAt(txt, i)== char6 ){
                    	result.append(char6+"\n");
                		if (Character.isHighSurrogate(txt.charAt(i))) {
                            i++;
                        }
                }else if(Character.codePointAt(txt, i)== char7 ){
                        	result.append(char7);
                    		if (Character.isHighSurrogate(txt.charAt(i))) {
                                i++;
                            }
                }else if(Character.codePointAt(txt, i)== char8 ){
                	result.append(char8);
            		if (Character.isHighSurrogate(txt.charAt(i))) {
                        i++;
                    }
                }else{
                		result.append(convertCodePointToUnicodeString(Character.codePointAt(txt, i)));
                        if (Character.isHighSurrogate(txt.charAt(i))) {
                            i++;
                        }
                }
 	
            }
        }
        return result.toString();
    }
    

    
    private static String convertCodePointToUnicodeString(int codePoint) {
        StringBuilder result = new StringBuilder(UNICODE_PREFIX);
        String codePointHexStr = Integer.toHexString(codePoint);
        codePointHexStr = codePointHexStr.startsWith("0") ? codePointHexStr.substring(1) : codePointHexStr;
        if (codePointHexStr.length() <= 4) {
            result.append(getPrecedingZerosStr(codePointHexStr.length()));
        }
        result.append(codePointHexStr);
        return result.toString();
    }

    
    
    
    private static String getPrecedingZerosStr(int codePointStrLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <4 - codePointStrLength; i++) {
            result.append("0");
        }
        return result.toString();
    }
    

    
}
