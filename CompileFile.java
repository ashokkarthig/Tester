package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

import javax.annotation.processing.Filer;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import com.sun.tools.javac.Main;

public class CompileFile {
	ArrayList<String> error=new ArrayList<>();
	ArrayList<String> writeFile(String code,String name) {
		try {
			File fileName = new File(name+".java");
			if (fileName.createNewFile()) {
				System.out.println("File is created!");
			}
			FileWriter fw = new FileWriter(fileName);
			fw.write(code);
			fw.close();
			FileReader fr = new FileReader(fileName);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			fr.close();
            System.out.println("\n");
			try {
				 runProcess("C:\\Program Files\\Java\\jdk1.8.0_281\\bin\\javac "+name+".java");
				return error;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	private void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			error.add(line);
			System.out.println(cmd + "  " + line);
		}
	}

	private int runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
		return pro.exitValue();
	}

}
