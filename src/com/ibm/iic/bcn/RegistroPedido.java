package com.ibm.iic.bcn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.iic.bcn.dao.PedidoDAO;
import com.ibm.iic.bcn.dao.UsuarioDAO;

/**
 * Servlet implementation class RegistroPedido
 */
@WebServlet("/RegistroPedido")
public class RegistroPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroPedido() {
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
		
		String producto = request.getParameter("producto").trim();        
        int cantidad = Integer.parseInt(request.getParameter("cantidad").trim());
        String usuario = (String) request.getSession().getAttribute("idUser");
        

        HttpSession ses = request.getSession();
        PedidoDAO pedido = new PedidoDAO();           
        pedido.registrarPedido(producto, cantidad, usuario);
        //ses.setAttribute("REGISTRO", "Se registro correctamente " + cantidad + " unidades de " + producto);
        RequestDispatcher rd = request.getRequestDispatcher("/registrarPedido.jsp");
        rd.forward(request, response);                 
        
	
	}

}
