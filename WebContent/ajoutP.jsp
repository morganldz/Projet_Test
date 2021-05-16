<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un compte</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />

</head>
<body style="
	background-image:url(./assets/images/inscription.jpg);
	background-size: cover;
	background-attachment: fixed;
	font-family: new time roman;"
>

	<div class="container" style="margin-top: 50px;">

		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">FORMULAIRE D'INSCRIPTION</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						Vous avez un compte! <a id="signinlink" href="login.jsp"
							onclick="$('#signupbox').hide(); $('#loginbox').show()">Se
							connecter</a>
					</div>
				</div>
				<div class="panel-body">
					<form id="signupform" class="form-horizontal" role="form" action="ajoutp" method="get">

						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Adresse mail*</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="pMail"
									placeholder="adresse email" required>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Mot de passe*</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="pMdp"
									placeholder="mot de passe" required>
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit"
									class="btn btn-info col-md-12">
									<i class="icon-hand-right"></i> Inscription
								</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>