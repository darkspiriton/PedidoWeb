<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,  initial-scale=1, maximum-scale=1">
	<title>PedidosWeb</title>
	<link rel="stylesheet" href="css/estilos.css"/>
	<link rel="stylesheet" href="css/normalize.css"/>
		
	
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
			<jsp:include page="//layout/logOut.jsp"/>
		</div>
	</header>

	<nav>
		<jsp:include page="//layout/nav.jsp"/>
	</nav>
        
	<div  class="container">
		<div class="main_content">
			<div class="header">
				<h5>Registra tu Pedido</h5>
				<div class="hit">Ingresa el nombre de producto y la cantidad para realizar el pedido
				</div>
			</div>
			<div class="body">
                    <form action="RegistroPedido" method="post">                   	
				        <p><label for="producto">Producto</label>	
					        <select name="producto">
							  <option value="producto1">Producto1</option>
							  <option value="producto2">Producto2</option>
							  <option value="producto3">Producto3</option>
							  <option value="producto4">Producto4</option>
							  <option value="producto5">Producto5</option>
							  <option value="producto6">Producto6</option>
							  <option value="producto7">Producto7</option>
							  <option value="producto8">Producto8</option>
							</select>
						</p>                        
                        <p><label for="cantidad">Cantidad</label><input placeholder="Ingrese la cantidad"	 id="cantidad" name="cantidad" type="text" required/></p>                        
                        <span class="boton"><input name="commit" type="submit" value="Registrar Pedido"></span>                        
                    </form>
                    				 	
			</div>
			<div class="footer">
 			</div>					                
		</div>	
	</div>
	
	
	<footer>
            <jsp:include page="//layout/footer.jsp"/>
	</footer>
        <%}%>
</body>
</html>