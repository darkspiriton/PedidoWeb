<%@page contentType="text/html" pageEncoding="UTF-8"%>    
<jsp:useBean id="ERROR_REGISTRO" class="java.lang.String" scope="session" />

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
				Comunidad Online
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
			
		</ul>
	</nav>

	<div  class="container">
		<div class="main_content">
			<div class="header">
				<h5>Registrate</h5>
				<div class="hit">¿Ya tienes una cuenta? <a href="/index.jsp">Inicia Sesion</a>
				</div>
			</div>
			<div class="body">
                    <form action="Registro" method="post">	   
                        <p><label for="usuario">Usuario</label><input placeholder="Ingrese su usuario" id="usuario" name="usuario" type="text" required/></p>                  
                        <p><label for="pass1">Contraseña</label><input placeholder="Ingrese su contraseña" id="pass1" name="pass1" type="password" required/></p>
                        <p><label for="pass2">Confirmar Contraseña</label><input placeholder="Reingrese su contraseña" id="pass2" name="pass2" type="password" required/></p>
                        <span class="boton"><input name="commit" type="submit" value="Registrar Usuario"></span>                        
                    </form>
                    				 	
			</div>
			<div class="footer">
 				<span class="error"><%= ERROR_REGISTRO %></span>
 			</div>					                
		</div>	
	</div>
              
	
	<footer>
       <jsp:include page="//layout/footer.jsp"/>
	</footer>

  
</body>
</html>