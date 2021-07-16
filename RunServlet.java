package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/run")
public class RunServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		ArrayList<String> output=new RunFile().runFile(name);
		PrintWriter pw = response.getWriter();
		int k=1;
		if(output.size()==0){
			k=0;
			pw.print(k);
		}
		else{
			String out="The First Test case Failed \n\n";
			for(String s:output){
				out+=s+"\n\n";
			}
			System.out.println(out);
			pw.print(out);
		}
	}
}