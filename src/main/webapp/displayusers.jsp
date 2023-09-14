<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<table border="3">
		<tr>
		     <th>ID</th>
		     <th>Name</th>
		     <th>Email</th>
		     <th>Password</th>
		     <th>Action</th>
		
			</tr>
			
			<c:forEach var="user" items="${allusers}" >
			
			<tr>
			
			   <td>${user.id }</td>
			   <td>${user.name }</td>
			   <td>${user.email }</td>
			   <td>${user.password }</td>
			   <td> <a href="deleteUser?id=${user.id }"> <input type="submit" value="DELETE"></a></td>
			   <td><a href="editUser?id=${user.id }"> <input type="submit" value="EDIT"></a></td>
			   </tr>
			   </c:forEach>
		</table>

</body>
</html>