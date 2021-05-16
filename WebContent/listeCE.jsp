<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des comptes épargnes</title>

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
<body class="comptee">

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

	<h1>Liste des comptes épargnes</h1>

	<h4>Rechercher un compte épargne</h4>

	<form class="form-horizontal" action="rechce" method="post">
		<div class="form-group">
			<label for="idIdCeR" class="col-sm-2 control-label">Id du
				compte : </label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="idIdCeR"
					placeholder="id" name="pIdCeR">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>
	</form>

	<c:if test="${not empty cerech}">
		<h3>Le compte épargne recherché :</h3>

		<div class="container">
			<table class="table table-bordered">
				<tr class="danger">
					<th>ID</th>
					<th>Numéro de compte</th>
					<th>Solde</th>
					<th>Taux</th>
				</tr>

				<tr class="info">
					<td>${cerech.idCo}</td>
					<td>${cerech.numeroCompte}</td>
					<td>${cerech.solde}</td>
					<td>${cerech.taux}</td>
				</tr>
			</table>
		</div>
	</c:if>

	<form class="form-horizontal" action="rechbce" method="post">
		<div class="form-group">
			<label for="idIdCR" class="col-sm-2 control-label">Id du
				client : </label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="idIdCR" placeholder="id"
					name="pIdCR">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>
	</form>

	<c:if test="${not empty cerechbc}">
		<h3>Le compte épargne recherché :</h3>

		<div class="container">
			<table class="table table-bordered">
				<tr class="danger">
					<th>ID</th>
					<th>Numéro de compte</th>
					<th>Solde</th>
					<th>Taux</th>
				</tr>

				<tr class="info">
					<td>${cerechbc.idCo}</td>
					<td>${cerechbc.numeroCompte}</td>
					<td>${cerechbc.solde}</td>
					<td>${cerechbc.taux}</td>
				</tr>
			</table>
		</div>
	</c:if>

	<c:if test="${erreur == 0 }">
		<h1 style="color: red; text-align: center;">Le compte épargne
			n'existe pas</h1>
	</c:if>

	<div class="container">
		<table class="table table-bordered">
			<tr class="danger">
				<th style="width:10%">ID</th>
				<th style="width:20%">Numéro de compte</th>
				<th style="width:20%">Solde</th>
				<th style="width:20%">Taux</th>
				<th style="width:30%">Operation</th>
			</tr>

			<c:forEach var="ce" items="${ces}">
				<!-- Dans les crochets : attribut d'une session ou d'une requete -->
				<tr class="info">
					<td>${ce.idCo}</td>
					<td>${ce.numeroCompte}</td>
					<td>${ce.solde}</td>
					<td>${ce.taux}</td>
					<td><a href="modifce?pIdCE=${ce.idCo}">Modifier</a> <a
						href="supce?pId=${ce.idCo}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>