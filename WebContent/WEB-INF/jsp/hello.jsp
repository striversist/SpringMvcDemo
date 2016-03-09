<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
   	<title>Hello Spring MVC</title>
</head>
<body>
	<h2>${message}</h2>
	
	
    <h2>Spring Page Redirection</h2>
    <p>Click below button to redirect the result to new page</p>
    <form:form method="GET" action="/SpringMvcDemo/redirect">
        <table>
            <tr>
                <td><input type="submit" value="Redirect Page" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>