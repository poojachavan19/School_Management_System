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
import Index.Teacher;

@WebServlet("/updateStud")
public class updateStudentData extends HttpServlet
{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id=req.getParameter("id");
		  String name=req.getParameter("name");
		  String email=req.getParameter("email");
		  String cno=req.getParameter("cno");
		  String stream=req.getParameter("stream");
		  String fee=req.getParameter("fee");
		  
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction et=em.getTransaction();
		  
		  
		  int id1=Integer.parseInt(id);
		  double fees=Double.parseDouble(fee);
		  long cno1=Long.parseLong(cno);
		  
		 Student s=new Student();
		  s.setId(id1);
		  s.setName(name);
		  s.setEmail(email);
		  s.setStream(stream);
		  s.setCno(cno1);
		  s.setFees(fees);;
		  
		  et.begin();
		  em.merge(s);
		  et.commit();
		  
		  PrintWriter pw=resp.getWriter();
		  pw.write("Student Data is updated");
		  RequestDispatcher rd=req.getRequestDispatcher("Studentmenu.html");
		  rd.include(req, resp);
		  resp.setContentType("text/html");
		  
	}
	
}
