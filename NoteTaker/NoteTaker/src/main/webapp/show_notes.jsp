<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.notetracker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notetracker.entity.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<%@include file="allcss_js.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="NavBar.jsp"%>
	</div>
	<div class="noteStyle text-center">
		<div class="row">

			<%
			try {
				Session session2 = FactoryProvider.getFactory().openSession();
				Query query = session2.createQuery("from Note");
				List<Note> list = query.list();
				for (Note note : list) {
			%>
			<div class="card mt-3" style="width: 18rem">
				<h6 class="date margin-right:5px position:relative float:right">
					<%
					out.println(note.getCreatedDate().toGMTString());
					%>
				</h6>
				<img src="images/notes.png" class="card-img-top" alt="..." height =40 width = 20>
				<div class="card-body">
					<h5 class="card-title">
						<%
						out.println(note.getId());
						%>
					</h5>
					<p class="card-text">
						<%
						out.println(note.getDescription());
						%>
					</p>
					<div class="container text-centre" >
						<a href="Deleteservlet?id=<%=note.getId()%>"
							class="btn btn-danger"><img src="images/trash.png" height = 20 width = 20>Delete</a>
						<a href="edit_notes.jsp?id=<%=note.getId()%>"
							class="btn btn-primary text-centre">Edit</a>
					</div>
				</div>
			</div>

			<%
			}
			session2.close();
			} catch (Exception e) {
			}
			%>


		</div>

	</div>
</body>
</html>
