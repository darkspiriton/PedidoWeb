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

/**
 * Servlet implementation class MostrarPedido
 */
@WebServlet("/MostrarPedido")
public class MostrarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		String usuario = (String) request.getSession().getAttribute("idUser");
		
		
		PedidoDAO pedido = new PedidoDAO();
		
		HttpSession ses = request.getSession();
		ses.removeAttribute("listaPedidos");
		
		ses.setAttribute("listaPedidos", pedido.mostrarPedido(usuario));
		
		RequestDispatcher rd = request.getRequestDispatcher("/mostrarPedido.jsp");
        rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
