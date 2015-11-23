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
 * Servlet implementation class ModificarPedido
 */
@WebServlet("/ModificarPedido")
public class ModificarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProducto = request.getParameter("idProducto");
		String producto = request.getParameter("producto"); 
		String cantidad = request.getParameter("cantidad"); 
		
		
		HttpSession ses = request.getSession();
		
		ses.setAttribute("idP", idProducto);
		ses.setAttribute("prod", producto);
		ses.setAttribute("cant", cantidad);	
		
		
				
		RequestDispatcher rd = request.getRequestDispatcher("/modificarPedido.jsp");
        rd.forward(request, response);  
        
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProducto = (String) request.getSession().getAttribute("idP");
		String producto = request.getParameter("producto").trim(); 
		String cantidad = request.getParameter("cantidad").trim(); 
		String usuario = (String) request.getSession().getAttribute("idUser");
		
		
		PedidoDAO pedido = new PedidoDAO();
		pedido.modificarPedido(Integer.parseInt(idProducto), producto, Integer.parseInt(cantidad));
		
		HttpSession ses = request.getSession();
		ses.removeAttribute("idP");
		ses.removeAttribute("prod");
		ses.removeAttribute("cant");
		
		
		ses.removeAttribute("listaPedidos");
		
		ses.setAttribute("listaPedidos", pedido.mostrarPedido(usuario));
		
		RequestDispatcher rd = request.getRequestDispatcher("mostrarPedido.jsp");
        rd.forward(request, response);
        
	}

}
