<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.QuestionTitles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tester</title>
<link rel="stylesheet" href="Tester.css">
</head>
<body>
	<ul>
		<li><a class="default">Program Questions</a></li>
		<%
			HashMap<Integer, String> questionTitles = new QuestionTitles().getQuestionTitles();
			int count = 1;
			for (Map.Entry<Integer, String> titles : questionTitles.entrySet()) {
				String p = count + "";
				String q = p + "-";
				count++;
		%>
		<li><input type="submit"
			style="height: 50px; width: 100%; font-size: large; text-align: left;"
			id="<%=p%>" value=<%=titles.getValue()%> readonly="readonly" /><input
			type="hidden" id=<%=q%> value=<%=titles.getKey()%>
			readonly="readonly"></li>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#<%=p%>").click(function() {
					jQuery.ajax({
						method : "POST",
						url : "question",
						data : {
							name : $("#<%=q%>").val(),
						},
						success : function(data) {
							var datas = data.split("<->");
							$("#name").html(datas[0]);
							$("#fileName").val(datas[0]);
							$("#description").html(datas[1]);
							$("#codeArea").val(datas[2]);
						}
					});
				});
				jQuery.ajax({
					method : "POST",
					url : "question",
					data : {
						name : $("#1-").val(),
					},
					success : function(data) {
						var datas = data.split("<->");
						$("#name").html(datas[0]);
						$("#fileName").val(datas[0]);
						$("#description").html(datas[1]);
						$("#codeArea").html(datas[2]);
					}
				});
			});
		</script>
		<%
			}
		%>

	</ul>
	<div class="programbody">
		<h2 id="name">Addition of Two Number</h2>
		<input type="hidden" id="fileName" value=""/>
		<p id="description">Find the sum of two numbers and display the
			output</p>
		<textarea name="area" id="codeArea" class="area"></textarea>
		<button id="compile" class="compile" type="submit">compile</button>
		<button id="run" class="run" type="submit">run</button>
		<br> <span id="pass"></span> <span id="fail"></span>
		<textarea rows="10" cols="100" id="output" class="output" type="text"
			style="display: none;" readonly></textarea>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#compile").click(function() {
				jQuery.ajax({
					method : "POST",
					url : "compile",
					data : {
						area : $("#codeArea").val(),name:$("#fileName").val()
					},
					success : function(data) {
						if (data == 0) {
							$("#pass").html("Compilation SuccessFull").css({
								'color' : 'green',
								'font-size' : '150%'
							});
							$("#output").css("display", "none");
						} else {
							$("#pass").html("Compilation Error").css({
								'color' : 'red',
								'font-size' : '150%'
							});
							$("#output").css("display", "block");
							$("#output").html(data);

						}
					}
				});
			});
			$("#run").click(function() {
				jQuery.ajax({
					method : "POST",
					url : "run",
					data : {
						name:$("#fileName").val()
					},
					success : function(data) {
						if (data == 0) {
							$("#pass").html("Test case Passed").css({
								'color' : 'green',
								'font-size' : '150%'
							});
							$("#output").css("display", "none");
						} else {
							$("#pass").html("Test Case Failed").css({
								'color' : 'red',
								'font-size' : '150%'
							});
							$("#output").css("display", "block");
							$("#output").html(data);
						}
					}
				});
			});
		});
	</script>
</body>
</html>
