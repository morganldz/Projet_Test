<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>

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
<body class="accueil">

	<h1>Bienvenue dans votre espace</h1>
	<br/>
	<br/>
	<h5 style="font-size: 25px;">Vous pouvez consulter les clients de la banque,</h5>
	<h5 style="font-size: 25px;">ainsi que les différents comptes</h5>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<div class="carousel-inner">
			<div class="item active">
				<table class="table table-bordered">
					<tr class="danger">
						<th>ID</th>
						<th>Numéro de compte</th>
						<th>Solde</th>
						<th>Taux</th>
					</tr>

					<c:forEach var="ce" items="${ces}">
						<!-- Dans les crochets : attribut d'une session ou d'une requete -->
						<tr class="info">
							<td>${ce.idCo}</td>
							<td>${ce.numeroCompte}</td>
							<td>${ce.solde}</td>
							<td>${ce.taux}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="item">
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
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="item">
				<table class="table table-bordered">
					<tr class="danger">
						<th>ID</th>
						<th>Numéro de compte</th>
						<th>Solde</th>
						<th>Découvert</th>
					</tr>

					<c:forEach var="cc" items="${ccs}">
						<!-- Dans les crochets : attribut d'une session ou d'une requete -->
						<tr class="info">
							<td>${cc.idCo}</td>
							<td>${cc.numeroCompte}</td>
							<td>${cc.solde}</td>
							<td>${cc.decouvert}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#myCarousel" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#myCarousel" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>

</body>
</html>