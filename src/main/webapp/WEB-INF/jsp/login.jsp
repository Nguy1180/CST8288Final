<%-- 
    Document   : login
    Created on : Apr 11, 2026, 1:56:24 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - CESC</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-wrapper">
    <div class="auth-wrapper">
        <div class="auth-card">

            <h2>Welcome Back 👋</h2>
            <p class="subtitle">Campus E-scooter Sharing CoOp</p>

            <%-- Show success message if coming from registration --%>
            <% if ("true".equals(request.getParameter("registered"))) { %>
                <div class="alert alert-success">Account created! Please log in.</div>
            <% } %>

            <%-- Show error message if login failed --%>
            <% String error = (String) request.getAttribute("errorMessage"); %>
            <% if (error != null) { %>
                <div class="alert-error-glass"><%= error %></div>
            <% } %>

            <%-- Login form submits via POST to LoginServlet --%>
            <form method="post" action="${pageContext.request.contextPath}/login">

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="e.g. alice@algonquincollege.com">
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password">
                </div>

                <div style="margin-top: 24px;">
                    <input type="submit" class="btn btn-white" value="Login">
                </div>

            </form>

            <%-- Link to registration page --%>
            <div class="auth-link">
                Don't have an account?
                <a href="${pageContext.request.contextPath}/register">Register here</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>
