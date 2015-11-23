<%@page contentType="text/html" pageEncoding="UTF-8"%>
   

<jsp:useBean id="ERROR_LOGIN" class="java.lang.String" scope="session" />

<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="//layout/head.jsp"/>
</head>
<body>

	<header>
		<div class="logo">
			<img src="/imagenes/logo.png" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Iniciar Sesion
			</h1>
			<div>
				<a href="#" class="filtro">
					PEDIDOS WEB
				</a>
				

			</div>

		</div>
	</header>

	<nav>
		<ul class="menu">
		<li><a href="#">Administrador</a></li>	
		</ul>
	</nav>

	<div class="container">

		<div class="main_content">

			<div class="header">
				<h5>Iniciar sesión</h5>
			</div>

			<div class="body">

				<form action="Login" method="post">
				    
				    <p><label for="usuario">Usuario</label><input placeholder="Ingrese su usuario" id="usuario" name="usuario" type="text" /></p>
                    <p><label for="passw">Contraseña</label><input placeholder="Ingrese su contrase" id="passw" name="passw" type="password" /></p>
				    <span class="boton"><input name="commit" type="submit" value="Iniciar sesión"></span>
 				 </form>

 			</div>
 			<div class="footer">
 				<span class="error"><%= ERROR_LOGIN %></span>
 				<a class="registro_link" href="/registro.jsp">¿No tienes una cuenta? Registrate aqui</a>
 				
 			</div>
		</div>	 
                
	</div>      
	<footer>
            <jsp:include page="//layout/footer.jsp"/>
	</footer>

</body>
</html>