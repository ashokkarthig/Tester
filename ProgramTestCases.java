package controller;

import java.util.HashMap;

public class ProgramTestCases {
	private static HashMap<String, HashMap<String, String>> output=new HashMap<>();
	private static HashMap<String, String> testCases;
	static {
		testCases = new HashMap<>();
		testCases.put("2 3", "5");
		testCases.put("3 3", "6");
		testCases.put("8 3", "11");
		testCases.put("60 36", "96");
		testCases.put("22 333", "355");
		testCases.put("-8 3", "-5");
		output.put("Addition", testCases);
		testCases =new HashMap<>();
		testCases.put("2 3", "-1");
		testCases.put("3 3", "0");
		testCases.put("8 3", "5");
		testCases.put("60 36", "24");
		testCases.put("22 333", "-311");
		testCases.put("-8 3", "-11");
		output.put("Subraction", testCases);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(new ProgramTestCases().getTestCases("Addition")); 
	}

	public HashMap<String, String> getTestCases(String fileName) {
		System.out.println("fileName : "+fileName);
		return output.get(fileName);
	}

}
