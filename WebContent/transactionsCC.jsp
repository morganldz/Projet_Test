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

<script type="text/javascript" src="./assets/js/script.js"></script>

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

	<h1>Transactions</h1>

	<img class="im1" alt="" src="./assets/images/transfert.png">

	<div style="width: 800px; height: 300px; margin: auto; margin-bottom: 1px;">
		<div style="font-family: Courier new, monospace; font-size: 90%; float: left; margin-top: 20px">
			<form style="background: transparent;" action="retcc" method="post">

				<fieldset style="display: inline-block; vertical-align: middle; padding: 0 20px 20px 20px; margin-bottom: 10px; border: 1px solid #DF3F3F;">
					<legend style="color: #DF3F3F; font-weight: bold"> Retirer de l'argent </legend>
					<label for="idIdCompte" class="col-sm-6 control-label">Id du compte :</label> 
		
					<div  style="width: 1px">
					<select style="width: 150px; height: 30px; border-radius: 10px 10px 10px 10px" name="pIdCompte" id="idIdCompte">
						<option>id du compte</option>
						<c:forEach var="cc" items="${ccs}">
							<option name="pIdCompte">${cc.idCo}</option>
						</c:forEach>
					</select> 
					</div> 
					
					<label style="margin-top: 10px" for="idMontant" class="col-sm-6 control-label">Montant :</label> 
					<input style="margin-top: 10px; border-radius: 10px 10px 10px 10px" type="text" class="form-control" id="idMontant" placeholder="montant" name="pMontant">
					<div style="margin-top: 10px">
						<button type="submit" class="btn btn-primary">Confirmer</button>
						<button type="reset" class="btn btn-primary">Annuler</button>
					</div>
				</fieldset>

				<c:if test="${erreurR == 0 }">
					<p style="color: red;">Le retrait n'est pas possible</p>
				</c:if>

			</form>
		</div>

		<div style="font-family: Courier new, monospace; font-size: 90%; float: right; margin-top: 20px">
			<form style="background: transparent;" action="depcc" method="post">

				<fieldset style="display: inline-block; vertical-align: middle; padding: 0 20px 20px 20px; margin-bottom: 10px; border: 1px solid #DF3F3F;">
					<legend style="color: #DF3F3F; font-weight: bold"> Déposer de l'argent </legend>
					<label for="idIdCompte" class="col-sm-6 control-label">Id du compte :</label> 
					
					<div style="width: 1px">
					<select style="width: 150px; height: 30px; border-radius: 10px 10px 10px 10px"  name="pIdCompte" id="idIdCompte">
						<option>id du compte</option>
						<c:forEach var="cc" items="${ccs}">
							<option name="pIdCompte">${cc.idCo}</option>
						</c:forEach>
					</select> 
					</div>
					
					<label style="margin-top: 10px" for="idMontant" class="col-sm-6 control-label">Montant :</label> 
					<input style="margin-top: 10px; border-radius: 10px 10px 10px 10px" type="text" class="form-control" id="idMontant" placeholder="montant" name="pMontant">
					<div style="margin-top: 10px">
						<button type="submit" class="btn btn-primary">Confirmer</button>
						<button type="reset" class="btn btn-primary">Annuler</button>
					</div>
				</fieldset>

				<c:if test="${erreurD == 0 }">
					<p style="color: red;">Le dépôt n'est pas possible</p>
				</c:if>

			</form>
		</div>
	</div>

	<div style="font-family: Courier new, monospace; font-size: 90%; width: 450px; height: 300px; margin: auto; margin-bottom: 20px;">
		<form style="background: transparent;" action="transcc" method="post">

			<fieldset style="display: inline-block; vertical-align: middle; padding: 0 20px 20px 20px; border: 1px solid #DF3F3F;">
				<legend style="color: #DF3F3F; font-weight: bold"> Transfert d'argent entre comptes</legend>
				<label for="idIdCompteDeb" class="col-sm-7 control-label">Id du compte à débiter :</label>
				
				<div style="width: 1px">
					<select style="width: 250px; height: 30px; border-radius: 10px 10px 10px 10px"  name="pIdCompteDeb" id="idIdCompteDeb">
						<option>id du compte à débiter</option>
						<c:forEach var="cc" items="${ccs}">
							<option name="pIdCompteDeb">${cc.idCo}</option>
						</c:forEach>
					</select> 
				</div>
				
				<label style="margin-top: 10px" for="idIdCompteCred" class="col-sm-7 control-label">Id du compte à créditer :</label> 
				
				<div style="width: 1px">
					<select style="width: 250px; height: 30px; border-radius: 10px 10px 10px 10px"  name="pIdCompteCred" id="idIdCompteCred">
						<option>id du compte à créditer</option>
						<c:forEach var="cc" items="${ccs}">
							<option name="pIdCompteCred">${cc.idCo}</option>
						</c:forEach>
					</select> 
				</div>
				
				<label style="margin-top: 10px" for="idMontant" class="col-sm-6 control-label">Montant :</label> 
				<input style="margin-top: 10px; border-radius: 10px 10px 10px 10px" type="text" class="form-control" id="idMontant" placeholder="montant" name="pMontant">
				<div style="margin-top: 10px">
					<button type="submit" class="btn btn-primary">Confirmer</button>
					<button type="reset" class="btn btn-primary">Annuler</button>
				</div>
			</fieldset>

			<c:if test="${erreurT == 0 }">
				<p style="color: red;">Le transfert n'est pas possible</p>
			</c:if>

		</form>
	</div>


</body>
</html>