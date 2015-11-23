package com.ibm.iic.bcn.interfaz;

import java.util.List;
import com.ibm.iic.bcn.Pedido;

public interface PedidoIF {
	public void registrarPedido(String producto,int cantidad, String usuario);
	public void modificarPedido(int idProducto,String producto,int cantidad);
	public List<Pedido> mostrarPedido(String user); 	
	
}
