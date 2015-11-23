package com.ibm.iic.bcn.dao;

import com.ibm.iic.bcn.ConnectionMySQL;
import com.ibm.iic.bcn.interfaz.UsuarioIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO implements UsuarioIF {
	
	ConnectionMySQL mysql = new ConnectionMySQL();

	@Override
	public boolean verificarUsuario(String usuario, String passw) {
		String nickAux;
		String sql = "SELECT USUARIO, PASS FROM USUARIO WHERE USUARIO=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existe=false;
		con = mysql.getConnection();
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, usuario);
			rs = pstmt.executeQuery();
						
			while(rs.next()){
				nickAux=rs.getString(1);
				
				if (usuario.equals(nickAux) && rs.getString(2).equals(passw)){					
						existe=true;
						break;				
				} 
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
                               
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return existe; 
	}

	@Override
	public void registrarUsuario(String usuario, String pass) {
		
		Connection con = null;
                
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO usuario (`usuario`, `pass`) VALUES (?,?);";
				
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1,usuario.toLowerCase());        
              	pstmt.setString(2,pass);
              	
              	pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
                    
		} finally {
			try {
				
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
