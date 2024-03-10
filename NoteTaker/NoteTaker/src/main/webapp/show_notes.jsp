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
	<div class="noteStyle">
		<div class="row">
			
				<%
				try {
					Session session2 = FactoryProvider.getFactory().openSession();
					Query query = session2.createQuery("from Note");
					List<Note> list = query.list();
					for (Note note : list) {
				%>
				<div class="card mt-3" style="width: 18rem;">
					<img src="images/notes.png" class="card-img-top" alt="...">
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
						<a href="#" class="btn btn-danger"><img src="images/trash.png">Delete</a>
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
