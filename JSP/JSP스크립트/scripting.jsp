<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%! //<%!안에 선언되는 변수나 method 들은 생성되는 servlet의 member로 들어간다.
			int count =3; //멤버변수
			String makeItLower(String data){
				return data.toLowerCase();
			}
		%>
		
		<% //<% 안에 선언되는 변수는 servlet의 servise의 지역변수가 된다.
			int year = 2021; //지역변수
			out.println("year :" + year + "<br>");
			out.println("count :" + count + "<br>");
			
			for(int i = 0; i <count ; i++){
				out.println(i +"<br>" );
			}//end for
			
			List<String> list = new ArrayList<>(); //자바의 외부class를 이용하기 위해서는 import가 필요하다.
			list.add("안녕하세요");
			list.add("이우길입니다.");
			list.add("잘 부탁드립니다.");
			
			Calendar cal = new GregorianCalendar();
			int year2 = cal.get(Calendar.YEAR);
			int bornyear = 1996;
			int myAge = (year2-bornyear)+1;
			String myName = "이우길";
			
			
			Set<Integer> set = new TreeSet<>();
			while(true){
				if(set.size()>5){
					break;
				}
				set.add((int)(Math.random()*45)+1);
			}
		%>
		
		<table border="1">
			<tr>
		<%
			for(int i = 1; i < 32; i ++){
				
		%>	
			<td><%=i%></td>
		<%
				if(i%7==0){
		%>
				</tr>
				<tr>
		<%	
				}
			}
		%>
			</tr>
		</table>
		
		<hr>
		<%= count %><br>
		<%= year %><br>
		<%= makeItLower("LEEWOOGIL") %><br>
		<%= list %><br>
		<%= myAge %><br>
		<%= myName %><br>
		<%= set %><br>
	</body>
</html>