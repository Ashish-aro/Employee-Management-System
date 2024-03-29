import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import beans.Employee;
import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/View")

public class View extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 664441809635191803L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.print("<html><head><style='text/css'></style><link rel='stylesheet' href='style.css'><title>View Employees</title></head>");
			out.print("<body style='background-image:url(https://wallpapercave.com/wp/wp9783863.jpg);'>");
            out.print("<div class='he1'><h1>Employees List</h1></div>");
            out.print("<a href='home.html' class='btn-1 btn-2'>Add New Employees</a>");
            List<Employee> list = EmployeeDao.getEmployees();
            out.print("<table border = '1' class='tbl' width=100%>");
            out.println("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email Address</th>"
            		+ "<th>Country</th><th>Edit</th><th>Delete</th></tr>");
            for(Employee e:list)
            {               
                out.print("<tr><td>"+e.geteId()+"</td><td>"+e.geteName()+"</td><td>"+e.getEpass()+"</td><td>"+e.getEemail()+
                		"</td><td>"+e.getEcntry()+"</td><td class='edit'><a style='\r\n"
                				+ "	text-decoration:none; color:whitesmoke;' href='Edit?id="+e.geteId()+
                		"'>Edit</a></td> <td class='edit'><a style='\r\n"
                		+ "	text-decoration:none; color:whitesmoke;' href='Delete?id="+e.geteId()+"'>Delete</a></td></tr>");
            }
            out.print("</table>");
            out.print("<br>");
            out.print("</body></html>");
	}
	}
}