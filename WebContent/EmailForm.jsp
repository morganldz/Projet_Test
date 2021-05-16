<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Envoyer un email</title>
</head>
<body>
 <form action="em" method="post">
        <table border="0" width="35%" align="center">
            <caption><h2>Envoyer un nouvel email</h2></caption>
            <tr>
                <td width="50%">Destinataire </td>
                <td><input type="text" name="email" size="50"/></td>
            </tr>
            <tr>
                <td>Sujet </td>
                <td><input type="text" name="subject" size="50"/></td>
            </tr>
            <tr>
                <td>Mail </td>
                <td><textarea rows="10" cols="39" name="message"></textarea> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>