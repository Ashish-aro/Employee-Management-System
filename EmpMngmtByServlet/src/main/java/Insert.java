import java.io.IOException;
import java.io.PrintWriter;

import beans.Employee;
import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Insert")

public class Insert extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("empname");
        String password = request.getParameter("emppass");
        int pass = Integer.parseInt(password);
        String email = request.getParameter("empemail");
        String country = request.getParameter("empcntry");
        
        Employee e = new Employee();
        e.seteName(name);
        e.setEpass(pass);    
        e.setEemail(email);
        e.setEcntry(country);
        
        int status = EmployeeDao.insert(e);
        if(status > 0)
        {
            out.print("<p style='font-family: Arial, Helvetica, sans-serif;'> Record Saved Successfully.</p>");
            request.getRequestDispatcher("home.html").include(request, response);
        }
        else
        {
            out.print("<p style='font-family: Arial, Helvetica, sans-serif;'> Sorry! Unable to Save Record.</p>");
        }
        out.close();
	}
}