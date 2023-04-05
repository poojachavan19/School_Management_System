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

@WebServlet("/Log")
public class LoginValidate extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
    String email=req.getParameter("email");
    String pass=req.getParameter("pass");
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("school");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    
    Query q=em.createQuery("select a from Account a where a.email=?1 and pass=?2");
    q.setParameter(1, email);
    q.setParameter(2, pass);
    
    List<Account> l=q.getResultList();
    
    if(l.size()>0)
    {
    	RequestDispatcher rd=req.getRequestDispatcher("Choice.html");
    	rd.forward(req, resp);
    }
    else
    {
    	PrintWriter pw=resp.getWriter();
    	pw.write("Invalid Credentials...");
    	RequestDispatcher rd=req.getRequestDispatcher("Log.html");
    	rd.include(req, resp);
    	resp.setContentType("text/html");
    }
}
}
