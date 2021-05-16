<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un client</title>

<script type="text/javascript" src="./assets/js/jquery-3.6.0.js"></script>

<script type="text/javascript" src="./assets/js/bootstrap.js"></script>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

<link rel="stylesheet" href="./assets/css/style.css" />

<style>
/* Modify the background color */
.navbar-custom {
	background-color: #D8D8D8;
}
</style>

</head>
<body class="client">

	<nav class="navbar navbar-custom">
	<ul class="nav navbar-nav">
		<li><a href="ac">Accueil</a></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Clients<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="ajoutC.jsp">Ajouter un client</a></li>
				<li><a href="listec">Liste des clients</a></li>
			</ul></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Comptes courants<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="attrcc">Ajouter un compte courant</a></li>
				<li><a href="listecc">Liste des comptes courants</a></li>
				<li><a href="transc">Transactions</a></li>
			</ul></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Comptes épargnes<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="attrce"></a>Ajouter un compte épargne</li>
				<li><a href="listece">Liste des comptes épargnes</a></li>
				<li><a href="transe">Transactions</a></li>
			</ul></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="modifp">Parametres</a></li>
		<li><a href="login.jsp">Deconnexion</a></li>
	</ul>
	</nav>

	<h1>Ajouter un client</h1>

<div style="box-shadow: -1px 1px 40px 10px black; width: 500px; height: 440px; margin: 50px auto; display: block; border-radius: 50px 50px 50px 50px; background: rgba(0, 0, 0, 0.1);">
	<img class="im1" alt="" src="./assets/images/customer.png">

	<form class="form-horizontal" action="ajoutc" method="get">
		<div class="form-group">
			<label for="idNom" class="col-sm-4 control-label">Nom : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idNom" placeholder="nom"
					name="pNom">
			</div>
		</div>
		<div class="form-group">
			<label for="idPrenom" class="col-sm-4 control-label">Prénom :
			</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idPrenom"
					placeholder="prenom" name="pPrenom">
			</div>
		</div>
		<div class="form-group">
			<label for="idAdresse" class="col-sm-4 control-label">Adresse
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idAdresse"
					placeholder="adresse" name="pAdresse">
			</div>
		</div>
		<div class="form-group">
			<label for="idCodePostal" class="col-sm-4 control-label">Code
				Postal : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idCodePostal"
					placeholder="code postal" name="pCodePostal">
			</div>
		</div>
		<div class="form-group">
			<label for="idVille" class="col-sm-4 control-label">Ville : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idVille"
					placeholder="ville" name="pVille">
			</div>
		</div>
		<div class="form-group">
			<label for="idTelephone" class="col-sm-4 control-label">Téléphone
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idTelephone"
					placeholder="telephone" name="pTelephone">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>

	</form>
</div>

</body>
</html>