<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="Index.Teacher"%>
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
  
  String id=request.getParameter("id");
  int id1=Integer.parseInt(id);
  Teacher t=em.find(Teacher.class, id1);
  
  

%>

<form action="update" method="post">

Id:  <input type="text" value="<%=t.getId() %>" name="id"><br><br>
Name:  <input type="text" value="<%=t.getName() %>" name="name"><br><br>
Contact No:  <input type="text" value="<%=t.getCno() %>" name="cno"><br><br>
Email:  <input type="text" value="<%=t.getEmail() %>" name="email"><br><br>
subject:  <input type="text" value="<%=t.getSub() %>" name="sub"><br><br>
salary:   <input type="text" value="<%=t.getSal() %>" name="sal"><br><br>
<input type="submit" value="Update">
</form>
</body>
</html>