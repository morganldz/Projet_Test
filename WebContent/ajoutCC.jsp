<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un compte courant</title>

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
<body class="compte">

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

	<h1>Ajouter un compte courant</h1>
	
	<img class="im1" alt="" src="./assets/images/bank.png">

	<form class="form-horizontal" action="ajoutcc" method="get">
		<div class="form-group">
			<label for="idNumeroCompte" class="col-sm-4 control-label">Numéro de compte
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idNumeroCompte"
					placeholder="numero de compte" name="pNumeroCompte">
			</div>
		</div>
		<div class="form-group">
			<label for="idSolde" class="col-sm-4 control-label">Solde : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idSolde"
					placeholder="solde" name="pSolde">
			</div>
		</div>
		<div class="form-group">
			<label for="idDecouvert" class="col-sm-4 control-label">Découvert
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idDecouvert"
					placeholder="decouvert" name="pDecouvert">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>

	</form>
	
		<hr />
	<h2>Associer un compte à un client</h2>

	<form class="form-horizontal" action="attrcc" method="post">
		<div class="form-group">
			<label for="idIdClient" class="col-sm-4 control-label">Id du client : </label>
			
			<select style="width: 250px; height: 30px; border-radius: 10px 10px 10px 10px"  name="pIdClient" id="idIdClient">
				<option>id du client</option>
					<c:forEach var="c" items="${cs}">
						<option name="pIdClient">${c.idCl}</option>
					</c:forEach>
			</select> 

		</div>
		<div class="form-group">
			<label for="idIdCompte" class="col-sm-4 control-label">Id du compte : </label>
		
			<select style="width: 250px; height: 30px; border-radius: 10px 10px 10px 10px"  name="pIdCompte" id="idIdCompte">
				<option>id du compte</option>
					<c:forEach var="cc" items="${ccs}">
						<option name="pIdCompte">${cc.idCo}</option>
					</c:forEach>
			</select> 

		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Associer</button>
			</div>
		</div>
	</form>

</body>
</html>