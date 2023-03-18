package controller;

import java.io.IOException;
import java.security.interfaces.RSAKey;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uid;
	private String pwd;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init(ServletConfig servletConfig) throws ServletException{
		// read info of account in web.xml using init-param
		this.uid = servletConfig.getInitParameter("username"); // someone
		this.pwd = servletConfig.getInitParameter("password"); // somepassword
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * Ma nguon cua servlet “login”
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // vietnamese

		try {

			// collect data from a login form
			String userID = request.getParameter("username");
			String password = request.getParameter("password");

			// read info of account in web.xml using context-param
//			String uid = getServletContext().getInitParameter("username"); // someone
//			String pwd = getServletContext().getInitParameter("password"); // somepassword
			if (userID == null && password == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<br><p></p><br>");
				rd.include(request, response);
			} else if (userID.equals("") && password.equals("")) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<br><p></p><br>");
				rd.include(request, response);
			} else {
				// check account - use validate code in assignment 1 to valid user
				if (password.equals(pwd) && userID.equalsIgnoreCase(uid)) {
					response.sendRedirect("home.jsp");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					response.getWriter().println("<br><p style='text-align:center'>"
							+ "<font color='red'>Username or password is invalid. Please try again!</font></p><br>");
					rd.include(request, response);
				}
			}
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}
}
