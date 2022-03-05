<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			New Question
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<header>
			<h1>
				What is your question?
			</h1>
		</header>
		<main>
			<div class="container">
				<form:form method="POST" action="/questions/new" modelAttribute="newQuestion">
					<div class="justify">
						<form:label path="question" for="question" class="inp">
							<form:textarea path="question" class="inp-input inp-textarea" name="question" id="question" placeholder=" " />
					    	<span class="inp-label inp-label-textarea">Question</span>
					  		<span class="inp-focus"></span>
					  		<form:errors path="question" class="error"/>
						</form:label>
					</div>
					<div class="justify">
						<form:label path="subject" for="subject" class="inp">
							<form:input path="subject" type="text" class="inp-input" name="subject" id="subject" placeholder=" " />
					    	<span class="inp-label">Tags</span>
					  		<span class="inp-focus"></span>
					  		<form:errors path="subject" class="error"/>
					  		<p class="error">
					  			<c:out value="${tagError}"/>
					  		</p>
						</form:label>
					</div>
					<button type="submit" class="submit" >
						Submit
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