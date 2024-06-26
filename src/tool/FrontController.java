package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class FlontController
*/
@WebServlet("*.action")
public class FrontController extends HttpServlet{

	/**
	 * @see HttpServlet#doget(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//TODO Auto-generated method stub
		try{
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace('/', '.');
			
			Action action =(Action)Class.forName(name).getDeclaredConstructor().newInstance();
			action.execute(request, response);
			
		} catch (Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//TODO Auto-generated method stub
		doGet(request, response);
	}
}