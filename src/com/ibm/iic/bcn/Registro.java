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
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		
		String user = request.getParameter("usuario").trim();        
        String pass1 = request.getParameter("pass1").trim();
        String pass2 = request.getParameter("pass2").trim();
        

        HttpSession ses = request.getSession();
        
       if (pass1.equals(pass2)){           
                           
           UsuarioDAO usuario = new UsuarioDAO();           
           usuario.registrarUsuario(user, pass1);
           ses.removeAttribute("ERROR_LOGIN");
           ses.removeAttribute("ERROR_REGISTRO");
           RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
           rd.forward(request, response);
                 
        }else{
            ses.setAttribute("ERROR_REGISTRO", "Las contraseña son diferentes");
            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
            rd.forward(request, response);
           
       }
		
	}

}
