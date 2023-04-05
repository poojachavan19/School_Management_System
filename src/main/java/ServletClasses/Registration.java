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

import Index.Account;

@WebServlet("/Reg")
public class Registration extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String name=req.getParameter("name");
	  String cno=req.getParameter("cno");
	  String email=req.getParameter("email");
	  String pass=req.getParameter("pass");
	  String cpass=req.getParameter("cpass");
	  
	  
	  
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Account a=new Account();
	  
	  
	
	   Query q=em.createQuery("select a from Account a where a.email=?1");
	    q.setParameter(1, email);
	   List<Account> l=q.getResultList();
	   
	   if(l.size()>0)
	   {
		        PrintWriter pw=resp.getWriter();
			    pw.write("Email Already Present");
				RequestDispatcher rd=req.getRequestDispatcher("Reg.html");
			    rd.include(req, resp);
			    resp.setContentType("text/html");
	   }
	   else
	   {
	    if(cpass.equals(pass))
		  {
	    	  a.setEmail(email);
		   	  a.setName(name);
		   	  a.setCno(cno);
			  a.setCpass(cpass);
			  a.setPass(pass); 
			  
			  et.begin();
			  em.persist(a);
			  et.commit();
			  
			  PrintWriter pw=resp.getWriter();
			  pw.write("Account is created");
				RequestDispatcher rd=req.getRequestDispatcher("Index.html");
			    rd.include(req, resp);
			    resp.setContentType("text/html");
			  
		  }
		  else
		  {
			  PrintWriter pw=resp.getWriter();
			  pw.write("Password dosen't match");
			  RequestDispatcher rd=req.getRequestDispatcher("Reg.html");
			    rd.include(req, resp);
			    resp.setContentType("text/html");
		  }
	 
	 
	   }

}
}
