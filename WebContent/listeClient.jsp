<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>

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

	<h1>Liste des Clients</h1>

	<h4>Rechercher un client</h4>

	<form class="form-horizontal" action="rechc" method="post">
		<div class="form-group">
			<label for="idIdClR" class="col-sm-2 control-label">Id : </label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="idIdClR"
					placeholder="id" name="pIdClR">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>

	</form>

	<c:if test="${not empty clrech}">
		<h3>Le client recherché :</h3>

		<div class="container">
			<table class="table table-bordered">
				<tr class="danger">
					<th>ID</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Adresse</th>
					<th>Code postal</th>
					<th>Ville</th>
					<th>Téléphone</th>
				</tr>

				<tr class="info">
					<td>${clrech.idCl}</td>
					<!-- Va exécuter e.getId -->
					<td>${clrech.nom}</td>
					<td>${clrech.prenom}</td>
					<td>${clrech.adresse}</td>
					<td>${clrech.codePostal}</td>
					<td>${clrech.ville}</td>
					<td>${clrech.telephone}</td>
				</tr>
			</table>
		</div>
	</c:if>

	<c:if test="${erreur == 0 }">
		<h1 style="color: red; text-align: center;">Le client n'existe
			pas</h1>
	</c:if>

	<div class="container">
		<table class="table table-bordered">
			<tr class="danger">
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Adresse</th>
				<th>Code postal</th>
				<th>Ville</th>
				<th>Téléphone</th>
				<th>Operation</th>
			</tr>

			<c:forEach var="c" items="${clients}">
				<!-- Dans les crochets : attribut d'une session ou d'une requete -->
				<tr class="info">
					<td>${c.idCl}</td>
					<!-- Va exécuter e.getId -->
					<td>${c.nom}</td>
					<td>${c.prenom}</td>
					<td>${c.adresse}</td>
					<td>${c.codePostal}</td>
					<td>${c.ville}</td>
					<td>${c.telephone}</td>
					<td><a href="modifc?pIdCl=${c.idCl}">Modifier</a> <a
						href="supc?pId=${c.idCl}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>