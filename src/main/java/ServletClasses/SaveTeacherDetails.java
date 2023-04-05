package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Index.Teacher;
@WebServlet("/addTeacher")
public class SaveTeacherDetails extends HttpServlet {
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String id=req.getParameter("id");
	  String name=req.getParameter("name");
	  String email=req.getParameter("email");
	  String cno=req.getParameter("cno");
	  String sub=req.getParameter("sub");
	  String sal=req.getParameter("sal");
	  
	  int id1=Integer.parseInt(id);
	  long cno1=Long.parseLong(cno);
	  double sal1=Double.parseDouble(sal);
	  
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Query q=em.createQuery("select a from Teacher a where a.email=?1");
	  q.setParameter(1, email);
	  List<Teacher> l=q.getResultList();
	  
	  PrintWriter pw=resp.getWriter();
	  Teacher t=new Teacher();
	  if(l.size()>0)
	  {
	     pw.write("Email already present");
	     RequestDispatcher rd=req.getRequestDispatcher("AddTeacher.html");
	     rd.include(req, resp);
	     resp.setContentType("text/html");
	  }
	  
	  else
	  {
		 
		  t.setId(id1);
		  t.setName(name);
		  t.setCno(cno1);
		  t.setEmail(email);
		  t.setSub(sub);
		  t.setSal(sal1);
		  
		  et.begin();
		  em.persist(t);
		  et.commit();
		  pw.write("Teacher Data is added");
		     RequestDispatcher rd=req.getRequestDispatcher("Teachermenu.html");
		     rd.include(req, resp);
		     resp.setContentType("text/html");
	  }
}
}
