package controller;

import java.util.HashMap;

public class QuestionTitles {
	HashMap<Integer, String> titles=new HashMap<>();
	
	public HashMap<Integer, String> getQuestionTitles(){
		titles.put(1,"Addition Of Number");
		titles.put(2,"Subraction Of Number");
		titles.put(3,"Multiplication Of Number");
		titles.put(4,"Division Of Number");
		titles.put(5,"Print Array Of Number");
		titles.put(6,"Sum Array Of Number");
		titles.put(7,"Rotate Array");
		titles.put(8,"Find Factorial");
		return titles;
	}

}
