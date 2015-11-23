package com.ibm.iic.bcn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.iic.bcn.ConnectionMySQL;
import com.ibm.iic.bcn.Pedido;
import com.ibm.iic.bcn.interfaz.PedidoIF;

public class PedidoDAO implements PedidoIF {
	ConnectionMySQL mysql = new ConnectionMySQL();
	
	@Override
	public void registrarPedido(String producto, int cantidad, String usuario) {
		Connection con = null;
        
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO pedido (`producto`, `cantidad`, `usuario`) VALUES (?,?,?);";
				
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1,producto);        
              	pstmt.setInt(2,cantidad);
              	pstmt.setString(3,usuario);
              	
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

	

	@Override
	public void modificarPedido(int idProducto,String producto, int cantidad) {
		Connection con = null;
        PreparedStatement pstmt1 = null;
        
                       
        String sql1 = "UPDATE PEDIDO SET PRODUCTO=?,CANTIDAD=? WHERE IDPEDIDO=?;";
        
        
		try {
			con = mysql.getConnection();
		                
			pstmt1 = con.prepareStatement(sql1);
		                pstmt1.setString(1, producto);
		                pstmt1.setInt(2, cantidad);         
		                pstmt1.setInt(3, idProducto);	                
		                
		                
		                                   
		                pstmt1.executeUpdate();
		                
		               
		                
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
		                        
		                        
		                        
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}



	@Override
	public List<Pedido> mostrarPedido(String user) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                
                
		String sql ="SELECT * FROM pedido WHERE usuario=?;";

                List<Pedido> lpedidos= new <Pedido>ArrayList();
		
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1,user);                            
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				lpedidos.add( new Pedido(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lpedidos;
	}

}
