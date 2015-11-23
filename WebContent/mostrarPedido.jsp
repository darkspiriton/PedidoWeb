<%@page import="com.ibm.iic.bcn.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listaPedidos" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,  initial-scale=1, maximum-scale=1">
	<title>PedidoWeb</title>
	<link rel="stylesheet" href="/css/estilos.css"/>
	<link rel="stylesheet" href="/css/normalize.css"/>
	<link rel="stylesheet" href="/css/bootstrap.min.css"/>	
	
</head>
<body>
    <% if (idUser.equals("") ) { %>
	Necesita esta Logeado para acceder  
        <%}else {%>   

	<header>
		<div class="logo">
			<img src="/imagenes/logo.png" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Comunidad Online
			</h1>
			<div>
				<a href="#" class="filtro">
					PedidosWeb
				</a>
				<a href="#" class="organizar">
					Salir
				</a>
			</div>

		</div>
		<div class="usuario">
			<figure class="avatar">
				<img src="/imagenes/avatar.png" alt="user">
			</figure>
			<a href="Out" class="opcion">
				X
			</a>
		</div>
	</header>

	<nav>
		<jsp:include page="//layout/nav.jsp"/>
	</nav>
        
	<div class="container">
		<div class="main_content">
			<div class="header">
				<h5>PEDIDOS REGISTRADOS</h5>
                                <div class="hit"><a href="/registrarPedido.jsp">Regresar Registro</a>
				</div>
				
			</div>
			
                        
			<section class="partidos">

                <% if (listaPedidos!= null ) { %>  
                    <table class="table table-bordered">
                                    <tr>
                                     <td class="active">N°</td>
                                     <td class="active">Producto</td>
                                     <td class="active">Cantidad</td>
                                     <td class="active">Usuario</td>
                                     <td class="active">Modificar</td>                                                                          
                                    </tr>
                
                    <%for (int i=0; i < listaPedidos.size(); i++ ) {Pedido o = (Pedido)listaPedidos.get(i);%>

				<tr>
                                     <td class="success"><%=i+1%></td>
                                     <td ><%= o.getProducto() %></td>
                                     <td ><%= o.getCantidad() %></td>
                                     <td ><%= o.getUsuario() %></td>   
                                     <td ><a href="ModificarPedido?idProducto=<%= o.getId()%>&producto=<%= o.getProducto()%>&cantidad=<%= o.getCantidad()%>">Modificar Pedidos</a></td>                                        
                                    </tr>

                                
                             <%} %></table><% }else { %>
                            <h5>NO HAY PEDIDOS REGISTRADOS</h5>
                        <%}%>                                                                                      

			</section>

                        
                        
                </div>	
	</div>
	
	
	<footer>
            <jsp:include page="//layout/footer.jsp"/>
	</footer>
        <%}%>
</body>
</html>