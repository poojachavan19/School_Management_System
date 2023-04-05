<%@page import="Index.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityTransaction"%>
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
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Query q=em.createQuery("select a from Teacher a");
	List<Teacher> l=q.getResultList();
%>
<center><h3>Teacher Data</h3></center><br>
<table border="2px" align="center">
<tr>
<th>Id</th>
<th>Name</th>
<th>Contact No</th>
<th>Email</th>
<th>Subject</th>
<th>Salary</th>
</tr>

<%for(Teacher t:l)
{ %>
<tr>
<td><%= t.getId() %></td>
<td><%= t.getName() %></td>
<td><%= t.getCno() %></td>
<td><%= t.getEmail() %></td>
<td><%= t.getSub() %></td>
<td><%= t.getSal() %></td>
</tr>
<%} %>

</table>
	
		
	
	

</body>
</html>