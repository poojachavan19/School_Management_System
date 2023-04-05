<%@page import="java.io.PrintWriter"%>
<%@page import="Index.Student"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String id=request.getParameter("id");
int id1=Integer.parseInt(id);

EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();

Student s=em.find(Student.class,id1);

if(s!=null){

%>
Id:  <input type="text" value="<%=s.getId() %>" name="id" disabled><br><br>
Name:  <input type="text" value="<%=s.getName() %>" name="name" disabled><br><br>
Contact No:  <input type="text" value="<%=s.getCno() %>" name="cno" disabled><br><br>
Email:  <input type="text" value="<%=s.getEmail() %>" name="email" disabled><br><br>
Stream:  <input type="text" value="<%=s.getStream() %>" name="stream" disabled><br><br>
Fee:   <input type="text" value="<%=s.getFees() %>" name="fee" disabled><br><br>

<%
}
else
{
	 PrintWriter pw=response.getWriter();
	  pw.write("Student Data is not found");
	  RequestDispatcher rd=request.getRequestDispatcher("Studentmenu.html");
	  rd.include(request, response);
	  response.setContentType("text/html");
	  	
}
%>
</body>
</html>