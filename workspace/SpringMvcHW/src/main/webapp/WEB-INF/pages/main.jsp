<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Member</title>
</head>

<body>
	<h3>新增會員</h3>
	<form method="POST" action="insertMem.controller" enctype="multipart/form-data"
		modelAttribute="member">
		<table>
			<tr>
				<td>Account: </td>
				<td><input type="text" name="account"></input></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="text" name="password"></input></td>
			</tr>
			<tr>
				<td>Nickname: </td>
				<td><input type="text" name="nickname"></input></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email"></input></td>
			</tr>
			<tr>
				<td>Photo: </td>
				<td><input type="file" name="photo" /></td>
			</tr>
			<tr>
				<td colspan="2"><button value="send">Send</button></td>
			</tr>
		</table>

	</form>
</body>

</html>