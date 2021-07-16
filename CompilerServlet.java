package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/compile")
public class CompilerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = "";
		String name="";
		try {
			code = request.getParameter("area");
			name = request.getParameter("name");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	    ArrayList<String> error= new CompileFile().writeFile(code,name);
		PrintWriter pw = response.getWriter();
		if(error==null)
		{
			int k=0;
		pw.println(k);
		}
		else{
			String err="";
			for(String s:error){
			     err+=s+"\n\n";
			}
			pw.print(err);
		}
	}
}