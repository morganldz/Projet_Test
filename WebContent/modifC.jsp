<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un client</title>

<script type="text/javascript" src="./assets/js/jquery-3.6.0.js"></script>

<script type="text/javascript" src="./assets/js/bootstrap.js"></script>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

</head>
<body
	style="background-color: #D6FFBE; font-family: Courier new, monospace;">
	<h1 style="color: #FA6731; text-align: center; font-weight: bold;">Formulaire
		de modification</h1>

<div style="box-shadow: -1px 1px 40px 10px black; width: 650px; height: 510px; margin: 50px auto; display: block; border-radius: 50px 50px 50px 50px; background: rgba(0, 0, 0, 0.1);">
	<form class="form-horizontal" action="modifc" method="post">
		<div class="form-group">
			<label style="margin-top:20px;" for="idId" class="col-sm-4 control-label">Id : </label>
			<div style="margin-top:20px;" class="col-sm-4">
				<input type="text" class="form-control" id="idId" placeholder="Id"
					name="pId" value="${clModif.idCl}">
			</div>
		</div>
		<div class="form-group">
			<label for="idNom" class="col-sm-4 control-label">Nom : </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idNom" placeholder="Nom"
					name="pNom" value="${clModif.nom}">
			</div>
		</div>
		<div class="form-group">
			<label for="idPrenom" class="col-sm-4 control-label">Prénom :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idPrenom"
					placeholder="Prenom" name="pPrenom" value="${clModif.prenom}">
			</div>
		</div>
		<div class="form-group">
			<label for="idAdresse" class="col-sm-4 control-label">Adresse
				:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idAdresse"
					placeholder="Adresse" name="pAdresse" value="${clModif.adresse}">
			</div>
		</div>
		<div class="form-group">
			<label for="idCodePostal" class="col-sm-4 control-label">Code
				Postal :</label>
			<div class="col-sm-4">
				<input type="number" class="form-control" id="idCodePostal"
					placeholder="CodePostal" name="pCodePostal"
					value="${clModif.codePostal}">
			</div>
		</div>
		<div class="form-group">
			<label for="idVille" class="col-sm-4 control-label">Ville :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idVille"
					placeholder="Ville" name="pVille" value="${clModif.ville}">
			</div>
		</div>
		<div class="form-group">
			<label for="idTelephone" class="col-sm-4 control-label">Téléphone
				:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idTelephone"
					placeholder="Telephone" name="pTelephone"
					value="${clModif.telephone}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-7">
				<button type="submit" class="btn btn-warning">Modifier</button>
			</div>
		</div>
		<div class="form-group">
			<label for="idMail" class="col-sm-4 control-label"> Adresse email
				:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idMail"
					placeholder="adresse mail" name="pMail">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-6 col-sm-4">
				<button type="submit" class="btn btn-info" name="bouton">Modifier et envoyer le rapport</button>
			</div>
		</div>
	</form>
</div>
	<c:if test="${erreur == 0 }">
		<h1 style="color: red; text-align: center;">La modification a
			échoué</h1>
	</c:if>
	
	<form style="margin-left: 20px" action="listec" method="get">
		<button type="submit" class="btn btn-danger" name="bouton">Retour</button>
	</form>	
	
</body>
</html>