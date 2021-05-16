<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test remplir liste deroulante avec DWR</title>

<script type="text/javascript">
function recupValue(){
	
	var x = document.getElementById("id1");
	
	var valeur = x.value;
	
	var x2 = document.getElementById("id2");
	
	x2.value = valeur;
	
}
</script>

</head>
<body>

<form>
  Sélectionnez une valeur dans la liste déroulante
  <select>
    <option>J'aime jQuery</option>
    <option>J'adore jQuery</option>
    <option>Je raffole de jQuery</option>
    <option>jQuery ? Jamais entendu parler !</option>
  </select>
</form><br />

<span id="resultat"></span><br />

<script src="./assets/js/jquery-3.6.0.js"></script>
<script>
  $(function() {
    $('select').change(function() {
        $('#resultat').text('Vous venez de sélectionner "' + $(this).val() +'".');
    });
  });
</script>

</body>
</html>