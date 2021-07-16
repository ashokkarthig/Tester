package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RunFile {
	HashMap<String, String> testCases = new HashMap<>();
	ArrayList<String> output = new ArrayList<>();

	ArrayList<String> runFile(String name) {
		File file = new File(name + ".java");
		testCases = new ProgramTestCases().getTestCases(name);
		System.out.println(testCases);
		for (Map.Entry<String, String> cases : testCases.entrySet()) {
			if (file.exists()) {
				try {
					if (!runProcess("java " + name + " " + cases.getKey(), cases.getKey())) {
						return output;
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}

	private boolean printLines(String cmd, BufferedReader in, String key) throws Exception {
		String result = "";
		String line = "";
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + "    " + line);
			result += line;
		}
		if (result.equals(testCases.get(key))) {
			System.out.println("true");
			return true;
		} else {
			output.add("Input           : " + key);
			output.add("Expected output : " + testCases.get(key));
			output.add("Actual output   : " + result);
			System.out.println("false");
			return false;
		}
	}

	private void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			output.add(line);
			System.out.println(cmd + "  " + line);
		}
	}

	private boolean runProcess(String command, String key) throws Exception {
		boolean res = false;
		long startTime = System.currentTimeMillis();
		Process pro = Runtime.getRuntime().exec(command);
		long endTime=System.currentTimeMillis();
		System.out.println("Time Taken : "+(endTime-startTime));
		if(endTime-startTime>5){
			output.add("Time Limit Exceeded");
			return false;
		}
		InputStream ins = pro.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		res = printLines(command + " stdout:", in, key);
		printLines(command + " stderr:", pro.getErrorStream());
		if (output != null) {
			return false;
		}
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
		return res;
	}
}
