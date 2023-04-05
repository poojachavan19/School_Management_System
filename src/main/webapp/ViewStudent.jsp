<%@page import="Index.Student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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
	
	Query q=em.createQuery("select a from Student a");
	List<Student> l=q.getResultList();
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

<%for(Student s:l)
{ %>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getCno() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getStream() %></td>
<td><%= s.getFees() %></td>
</tr>
<%} %>

</table>
	
		
	
	

</body>
</html>