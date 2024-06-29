<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Image</title>
</head>
<body>
	<h1 style="color: red" align="center">Add Image</h1>

	<div align="center">
		<form action="addImage" method="post" enctype="multipart/form-data">
			Select Image: <input type="file" name="image"> <input type="submit"
				value="add">
		</form>
	</div>
</body>
</html>