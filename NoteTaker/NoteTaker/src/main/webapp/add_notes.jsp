<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="allcss_js.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="NavBar.jsp"%>
	</div>
	<!-- add form -->
	<form action="Noteservlet" method="post">
		<div class="mb-3">
			<label for="Title" class="form-label">Title</label> <input
				type="text" class="form-control" id="Title"
				aria-describedby="emailHelp" placeholder="enter the title here" name = "title" required>
		</div>
		<div class="mb-3">
			<label  for="Content" class="form-label">Enter the content </label>
			<textarea name ="content" id="Content" placeholder="Enter your content "
				class="form-control" style="height: 300px" required ></textarea>
		</div>
		<div class="container text-center ">
			<button type="submit" class="btn btn-primary">Add</button>
		</div>
	</form>
</body>
</html>