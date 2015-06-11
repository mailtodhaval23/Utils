package org.dsystems.utils;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.text.StrSubstitutor;

import com.google.gson.internal.LinkedTreeMap;

public class Utils  implements Serializable{


	private static final long serialVersionUID = 1L;

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	public static boolean isArithMeticOperator(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("%") || str.equals("/") || str.equals("^"))
			return true;
		else
			return false;
	}

	public static boolean isComparisionOperator(String str) {
		if (str.equals(">") || str.equals("<") || str.equals(">=") || str.equals("<=") || str.equals("=") || str.equals("!="))
			return true;
		else
			return false;
	}

	public static boolean isKeyword(String str) {
		if (str.equalsIgnoreCase("If") || str.equalsIgnoreCase("Then") )
			return true;
		else
			return false;
	}
	public static boolean isLogicalOperator(String str) {
		if (str.equals("AND") || str.equals("OR") )
			return true;
		else
			return false;
	}

	public static String strSubstitute(String str, String pattern, LinkedTreeMap<String, Object> map) {
		System.out.println("Running Utils.strSubstitute : str:" + str + " Pattern: " + pattern);
		Pattern p = Pattern.compile(pattern);
		//List<String> list = new ArrayList<String>();
		Map<String, Object> newMap = new HashMap<String, Object>();
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println("Found match");
			newMap.put(m.group(), map.get(m.group()));
		    //list.add(m.group());
		}
		StrSubstitutor sub = new StrSubstitutor( newMap, "${", "}");
		return sub.replace(str);
		//return str;
	}
	
}
