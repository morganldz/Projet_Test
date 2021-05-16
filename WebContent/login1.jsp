<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Identification</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

<link rel="stylesheet" href="./assets/css/style.css" />

</head>
<body class="login">

	<h1>Connexion</h1>



	<form class="form-horizontal" action="log" method="post">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-4 control-label">Email
				: </label>
			<div class="col-sm-4">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="email" name="pMail">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-4 control-label">Mot de passe :</label> 
			<div class="col-sm-4">
			<input
				type="password" class="form-control" id="inputPassword3"
				placeholder="mot de passe" name="pMdp">
		</div>
		</div>
		<div class="form-group">
		<div class="col-sm-offset-4 col-sm-4">
			<button type="submit" class="btn btn-default">Se connecter</button>
		</div>
		</div>
	</form>
	<a class="col-sm-offset-4 col-sm-4" href="ajoutP.jsp"
		style="color: white; font-family: Courier new, monospace">Ajouter
		un compte </a>


	<!-- Affichage du modele MVC (message) dans la vue -->
	<h1 style="color: red">${msg}</h1>

</body>
</html>