<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Identification</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

<style type="text/javascript" src="./assets/js/bootstrap.js"></style>

<link rel="stylesheet" href="./assets/css/style.css" />

</head>
<body class="login2">


	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 logc2">

				<p style="font-size: 50px; color: white; text-align: center">Connexion</p>

				<form action="log" method="post">
					<input type="email" class="form-control log2" id="inputEmail"
						name="pMail" placeholder="adresse mail"> <input
						type="password" class="form-control log2" name="pMdp"
						placeholder="mot de passe">

					<button type="submit" class="btn btn-info logb2">Se
						connecter</button>
				</form>
				<a href="ajoutP.jsp"><div class="loga2" style="color: white">Pas
						encore de compte ? Inscrivez-vous</div></a>

			</div>
			<div class="col-md-3"></div>
		</div>
	</div>


	<!-- Affichage du modele MVC (message) dans la vue -->
	<p style="color: red; font-size: 50px; text-align: center">${msg}</p>

</body>
</html>