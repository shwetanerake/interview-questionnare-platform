package com.platform.service;

import java.util.HashMap;
import java.util.Map;

public class Utility {

	public static Map<String, Object> buildResponseMap(String message, int exitCode, String resultKey, Object resultVal) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		responseMap.put("message", message);
		responseMap.put("exit_code", exitCode);
		
		resultMap.put(resultKey, resultVal);
		
		responseMap.put("result", resultMap);
		return responseMap;

	}
	
	public static Map<String, Object> buildErrorResponseMap(String message, int exitCode){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("message", message);
		responseMap.put("exit_code", exitCode);
		return responseMap;

	}

}