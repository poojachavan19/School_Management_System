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

@WebServlet("/removeStud")
public class RemoveStudentData extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
	    EntityManager em=emf.createEntityManager();
	    EntityTransaction et=em.getTransaction();
			 
			String id=req.getParameter("id");
			int id1=Integer.parseInt(id);
			Student s=em.find(Student.class,id1);
			
			et.begin();
			em.remove(s);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Student is removed");
			RequestDispatcher rd= req.getRequestDispatcher("Studentmenu.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			 
}
}
