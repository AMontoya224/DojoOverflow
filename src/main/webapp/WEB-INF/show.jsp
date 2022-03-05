<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Question Profile
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<header class="column">
			<h1>
				<c:out value="${question.getQuestion()}"/>
			</h1>
			<h2>
				Tags: 
				<c:forEach var="tag" items="${question.getTags()}">
               		<c:out value="${tag.getSubject()}"/>
               	</c:forEach>
			</h2>
		</header>
		<main class="row">
			<table>
	        	<thead>
			        <tr>
			            <th>Answers</th>
			        </tr>
			    </thead>
	        	<tbody>
					<c:forEach var="answer" items="${question.getAnswersList()}">
						<tr>
	                        <td>
								<c:out value="${answer.getAnswer()}"/>
	                        </td>
						</tr>
	            	</c:forEach>
				</tbody>
			</table>
			<div class="container">
				<h2>
					Add your answer:
				</h2>
				<form:form method="POST" action="/questions/${question.getId()}/answer" modelAttribute="newAnswer">
					<div class="justify">
						<form:label path="answer" for="answer" class="inp">
							<form:textarea path="answer" class="inp-input inp-textarea" name="answer" id="answer" placeholder=" " />
					    	<span class="inp-label inp-label-textarea">Answer</span>
					  		<span class="inp-focus"></span>
					  		<form:errors path="answer" class="error"/>
						</form:label>
					</div>
					<button type="submit" class="submit" >
						Answer it!
					</button>
				</form:form>
				<form method="GET" action="/questions/">
					<button type="submit" class="cancel" >
						Cancel
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