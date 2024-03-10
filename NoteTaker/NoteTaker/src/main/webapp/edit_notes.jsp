<%@page import="org.hibernate.Session"%>
<%@page import="com.notetracker.helper.FactoryProvider"%>
<%@page import="com.notetracker.entity.Note"%>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="allcss_js.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="NavBar.jsp"%>
	</div>
	<%
	int noteId = Integer.parseInt(request.getParameter("id").trim());
	Session session3 = FactoryProvider.getFactory().openSession();
	Note note = session3.get(Note.class, noteId);

	session3.close();
	%>
	<!-- add form -->
	<form action="Updateservlet" method="post">
	<input value = <%=note.getId() %> name = "noteId" type = "hidden">
		<div class="mb-3">
			<label for="updateTitle" class="form-label">Title</label> <input
				type="text" class="form-control" id="updateTitle"
				aria-describedby="emailHelp" value=<%=note.getTitle() %> required>
		</div>
		<div class="mb-3">
			<label  for="updateContent" class="form-label">Enter the content </label>
			<textarea name ="updateContent" id="updateContent"
				class="form-control" style="height: 300px" ><%=note.getDescription() %></textarea>
		</div>
		<div class="container text-center ">
			<button type="submit" class="btn btn-success">Update</button>
		</div>
	</form>
</body>
</html>