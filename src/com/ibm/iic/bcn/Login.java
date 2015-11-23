package com.ibm.iic.bcn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.iic.bcn.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession(true);
        String user = request.getParameter("usuario");
        String pass = request.getParameter("passw");
        
        UsuarioDAO usuario= new UsuarioDAO();
        boolean existe = usuario.verificarUsuario(user, pass);
        
        if (existe==true) {
        	ses.setAttribute("idUser", user);
        	ses.removeAttribute("ERROR_LOGIN");
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/menuInicio.jsp");
    		rd.forward(request, response);
        } else {
        	
        	ses.setAttribute("ERROR_LOGIN", "El usuario es incorrecto o la contraseña es incorrecta");
        	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
    		rd.forward(request, response);
        }

		
	}
}


