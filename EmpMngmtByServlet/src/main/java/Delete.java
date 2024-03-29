import java.io.*;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Delete")

public class Delete extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8802449375154714625L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		String empId = request.getParameter("id");
        int id = Integer.parseInt(empId);
        EmployeeDao.delete(id);
        response.sendRedirect("View");
	}
}