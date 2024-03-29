import java.io.IOException;
import java.io.PrintWriter;

import beans.Employee;
import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Edit")

public class Edit extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><head><style='text/css'></style><link rel='stylesheet' href='style.css'><title>Edit Details</title></head>");
        out.print("<body class='main-container'style='text-align: center;'>");
        out.println("<h1 class='he1' >Update Employee</h1>");
        String sid = request.getParameter("id");
        int id =Integer.parseInt(sid);
        
        Employee e = EmployeeDao.getEmployee(id);
        
        out.print("<form action = 'Edit2' method='post'>");
        out.print("<table class='center-2' style='height:350px'>");
        out.print("<tr><td>Id:</td><td><input style='width:100%; border:0; background-color:whitesmoke;' type='text' name='empId' value ='"+e.geteId()+"' /></td></tr>");
        out.print("<tr><td>Name:</td><td><input style='width:100%;' type='text' name='empname' value='"+e.geteName()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input style='width:100%;' type='text' name='emppass' value='"+e.getEpass()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input style='width:100%;' type='Email' name='empemail' value='"+e.getEemail()+"'/></td></tr>");
        out.print("<tr><td>Country:</td>");
        out.print("<td><select name='empcntry' style='width:100%'>");
        out.print("<option>India</option>");
        out.print("<option>USA</option>");
        out.print("<option>UK</option>");
        out.print("<option>France</option>");
        out.print("<option>Other</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input class='btn-1' style='font-size:medium; width:100%;' type='submit' value='Edit & Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("</body></html>");
        out.close();
        
        
    }
}