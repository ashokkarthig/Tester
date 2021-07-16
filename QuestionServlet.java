package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codeName = request.getParameter("name");
		System.out.println(codeName);
		ArrayList<String> out=new ProgramQuestions().getQuestion(Integer.parseInt(codeName));
		PrintWriter pw = response.getWriter();
		String result="";
		for(String s:out){
			result+=s+"<->";
		}
		pw.print(result);

	}
}