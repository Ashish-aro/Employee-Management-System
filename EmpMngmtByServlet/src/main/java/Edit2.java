import java.io.IOException;
import java.io.PrintWriter;

import beans.Employee;
import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Edit2")

public class Edit2 extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String sid = request.getParameter("empId");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("empname");
        String password = request.getParameter("emppass");
        int pass = Integer.parseInt(password);
        String email = request.getParameter("empemail");
        String country = request.getParameter("empcntry");
        
        Employee e = new Employee();
        e.seteId(id);
        e.seteName(name);
        e.setEpass(pass);
        e.setEemail(email);
        e.setEcntry(country);
        
        int status = EmployeeDao.update(e);
        if(status > 0)
        {
        	
            response.sendRedirect("View");
        }
        else
        {
            out.println("Sorry! Unable to Update Record.");
        }
        
        out.close();
    }
}