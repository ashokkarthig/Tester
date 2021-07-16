package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgramQuestions {
	private static HashMap<Integer, ArrayList<String>> questions = new HashMap<>();
	private static ArrayList<String> data;
	static {
		System.out.println("HAi");
		data = new ArrayList<>();
		data.add("Addition");
		data.add(
				"Get Two integer number from the Command line Argumen and Find the Sum of two number and print the result");
		data.add("public class Addition{\n" + "public static void main(String args[]){\n"
				+ "int i=Integer.parseInt(args[0]);\n" + "int j=Integer.parseInt(args[1]);\n"
				+ "System.out.println(i+j);\n" + "}\n" + "}");
		questions.put(1, data);
		data = new ArrayList<>();
		data.add("Subraction");
		data.add(
				"Get Two integer number from the Command line Argumen and Find the difference of two number and print the result");
		data.add("public class Subraction{\n" + "public static void main(String args[]){\n"
				+ "int i=Integer.parseInt(args[0]);\n" + "int j=Integer.parseInt(args[1]);\n"
				+ "System.out.println(i-j);\n" + "}\n" + "}");
		questions.put(2, data);
	}

	public ArrayList<String> getQuestion(int key) {
		return questions.get(key);
	}

}
