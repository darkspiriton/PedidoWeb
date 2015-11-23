package com.ibm.iic.bcn.interfaz;

public interface UsuarioIF {
	
	public boolean verificarUsuario(String usuario,String passw); 
	public void registrarUsuario(String usuario,String passw); 

}
