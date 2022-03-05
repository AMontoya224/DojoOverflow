<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Questions Dashboard
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<header>
			<h1>
				Questions Dashboard
			</h1>
		</header>
		<main>
			<div class="container">
				<table>
		        	<thead>
				        <tr>
				            <th>Question</th>
				            <th>Tags</th>
				        </tr>
				    </thead>
		        	<tbody>
						<c:forEach var="question" items="${questionsList}">
							<tr>
		                        <td>
		                        	<form method="GET" action="/questions/${question.getId()}">
										<button type="submit" class="link" >
											<c:out value="${question.getQuestion()}"/>
										</button>
									</form>
		                        </td>
		                        <td>
		                        	<c:forEach var="tag" items="${question.getTags()}">
		                        		<c:out value="${tag.getSubject()}"/>
		                        	</c:forEach>
		                        </td>
							</tr>
		            	</c:forEach>
					</tbody>
				</table>
				<form method="GET" action="/questions/new">
					<button type="submit" class="submit" >
						New Question
					</button>
				</form>
			</div>
		</main>
		<footer>
			<p>
                Developed by <a href="https://github.com/AMontoya224" target="_blank">Andres Montoya</a> 
            </p>
		</footer>
	</body>
</html>