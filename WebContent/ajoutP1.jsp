<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un compte</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

<link rel="stylesheet" href="./assets/css/style.css" />

</head>
<body style="background-color: #D8D8D8">

<h1>Ajouter un compte</h1>

<form class="form-horizontal" action="ajoutp" method="get">
		<div class="form-group">
			<label for="idMail" class="col-sm-4 control-label">Adresse mail* : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMail" placeholder="mail"
					name="pMail" required>
			</div>
		</div>
		<div class="form-group">
			<label for="idMdp" class="col-sm-4 control-label">Mot de passe* : 
			</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="idMdp"
					placeholder="motdepasse" name="pMdp" required>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
	</form>
	
</body>
</html>