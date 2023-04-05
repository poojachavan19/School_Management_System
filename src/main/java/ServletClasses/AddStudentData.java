package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Index.Student;

@WebServlet("/addStudent")
public class AddStudentData extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	  String id=req.getParameter("id");
	  String name=req.getParameter("name");
	  String email=req.getParameter("email");
	  String cno=req.getParameter("cno");
	  String stream=req.getParameter("stream");
	  String fee=req.getParameter("fee");
	  
	  int id1=Integer.parseInt(id);
	  long cno1=Long.parseLong(cno);
	  double fees=Double.parseDouble(fee);
	  
	  Student s=new Student();
	  s.setId(id1);
	  s.setName(name);
	  s.setCno(cno1);
	  s.setEmail(email);
	  s.setFees(fees);
	  s.setStream(stream);
	  
	  et.begin();
	  em.persist(s);
	  et.commit();
	  
	  PrintWriter pw=resp.getWriter();
	  pw.write("Data is added");
	  RequestDispatcher rd=req.getRequestDispatcher("Studentmenu.html");
	  rd.include(req, resp);
	  resp.setContentType("text/html");
	  
}
}
