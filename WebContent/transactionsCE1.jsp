<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>

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
				<li><a href="ajoutCC.jsp">Ajouter un compte courant</a></li>
				<li><a href="listecc">Liste des comptes courants</a></li>
				<li><a href="transc">Transactions</a></li>
			</ul></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Comptes épargnes<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="ajoutCE.jsp"></a>Ajouter un compte épargne</li>
				<li><a href="listece">Liste des comptes épargnes</a></li>
				<li><a href="transactionsCE.jsp">Transactions</a></li>
			</ul></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="modifp">Parametres</a></li>
		<li><a href="login.jsp">Deconnexion</a></li>
	</ul>
	</nav>
	
	<h1>Transactions</h1>
	
	<img class="im1" alt="" src="./assets/images/transfert.png">

	<h2>Retirer de l'argent</h2>

	<form class="form-horizontal" action="retce" method="post">
		<div class="form-group">
			<label for="idIdCompte" class="col-sm-4 control-label">Id du
				compte : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idIdCompte"
					placeholder="id" name="pIdCompte">
			</div>
		</div>
		<div class="form-group">
			<label for="idMontant" class="col-sm-4 control-label">Montant
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMontant"
					placeholder="montant" name="pMontant">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Confirmer</button>
			</div>
		</div>
	</form>

	<c:if test="${erreurR == 0 }">
		<p style="color: red;">Le retrait n'est pas possible</p>
	</c:if>

	<hr />
	<h2>Deposer de l'argent</h2>

	<form class="form-horizontal" action="depce" method="post">
		<div class="form-group">
			<label for="idIdCompte" class="col-sm-4 control-label">Id du
				compte : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idIdCompte"
					placeholder="id" name="pIdCompte">
			</div>
		</div>
		<div class="form-group">
			<label for="idMontant" class="col-sm-4 control-label">Montant
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMontant"
					placeholder="montant" name="pMontant">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Confirmer</button>
			</div>
		</div>
	</form>

	<c:if test="${erreurD == 0 }">
		<p style="color: red;">Le dépôt n'est pas possible</p>
	</c:if>

	<hr />
	<h2>Transfert d'argent entre comptes</h2>

	<form class="form-horizontal" action="transce" method="post">
		<div class="form-group">
			<label for="idIdCompteDeb" class="col-sm-4 control-label">Id
				du compte à débiter : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idIdCompteDeb"
					placeholder="id" name="pIdCompteDeb">
			</div>
		</div>
		<div class="form-group">
			<label for="idIdCompteCred" class="col-sm-4 control-label">Id
				du compte à créditer : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idIdCompteCred"
					placeholder="id" name="pIdCompteCred">
			</div>
		</div>
		<div class="form-group">
			<label for="idMontant" class="col-sm-4 control-label">Montant
				: </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMontant"
					placeholder="montant" name="pMontant">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-primary">Confirmer</button>
			</div>
		</div>
	</form>

	<c:if test="${erreurT == 0 }">
		<p style="color: red;">Le transfert n'est pas possible</p>
	</c:if>

</body>
</html>