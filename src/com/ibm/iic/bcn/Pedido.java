package com.ibm.iic.bcn;

import java.io.Serializable;

public class Pedido implements Serializable{
	private int id;
	private String producto;
    private int cantidad;
    private String usuario;
    
    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Pedido(){
    	
    }
    
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido(int id, String producto, int cantidad, String usuario) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.usuario = usuario;
	}

	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
    
}
