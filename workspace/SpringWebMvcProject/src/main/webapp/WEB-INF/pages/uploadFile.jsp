<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
<h2>Upload</h2>
<form action="upload.controller" method="post" enctype="multipart/form-data">
    Please select file to upload:<br/>
    <input type="file" name="myFiles"/>
    <br>
    <button type="submit" value="upload">Upload</button>
</form>
</body>
</html>