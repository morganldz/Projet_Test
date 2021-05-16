<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parametres</title>

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

<body style="background-color: #FF8F8F">
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

	<h1 style="text-align: center; font-weight: bold;">Modifier
		son compte</h1>

	<form class="form-horizontal" action="modifp" method="post">
		<div class="form-group">
			<label for="idId" class="col-sm-4 control-label">Id : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idId" placeholder="id"
					name="pId" value="${pModif.id}">
			</div>
		</div>
		<div class="form-group">
			<label for="idMail" class="col-sm-4 control-label">Adresse
				mail : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMail"
					placeholder="mail" name="pMail" value="${pModif.mail}">
			</div>
		</div>
		<div class="form-group">
			<label for="idMdp" class="col-sm-4 control-label">Mot de
				passe :</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="idMdp"
					placeholder="motdepasse" name="pMdp" value="${pModif.mdp}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-4">
				<button type="submit" class="btn btn-warning">Modifier</button>
			</div>
		</div>
	</form>

	<form class="form-horizontal">
		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-4">
				<button id="idSup" type="button" class="btn btn-danger">Supprimer
					le compte</button>
			</div>
		</div>
	</form>

	<div id="sup-confirm" class="modal" data-backdrop="static"
		data-keyboard="false">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title  text-center">Attention</h4>
					</div>
					<div class="modal-body">
						<p class="text-center">Etes-vous sur de vouloir supprimer
							votre compte ?</p>
						<form action="supp" method="get">
							<div class="text-center">
								<button class=" btn btn-primary " type="submit">Oui</button>
								<button class=" btn btn-primary " type="button"
									data-dismiss="modal">Non</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<script>
	$('#idSup').on('click',function(){ $('#sup-confirm').modal('show'); });
</script>

	<c:if test="${erreur == 0 }">
		<h1 style="color: red; text-align: center;">La modification a
			échoué</h1>
	</c:if>
</body>
</html>