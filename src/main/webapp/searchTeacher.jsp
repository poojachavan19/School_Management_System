<%@page import="Index.Teacher"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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

Teacher t=em.find(Teacher.class,id1);



%>
Id:  <input type="text" value="<%=t.getId() %>" name="id" disabled><br><br>
Name:  <input type="text" value="<%=t.getName() %>" name="name" disabled><br><br>
Contact No:  <input type="text" value="<%=t.getCno() %>" name="cno" disabled><br><br>
Email:  <input type="text" value="<%=t.getEmail() %>" name="email" disabled><br><br>
subject:  <input type="text" value="<%=t.getSub() %>" name="sub" disabled><br><br>
salary:   <input type="text" value="<%=t.getSal() %>" name="sal" disabled><br><br>
</body>
</html>