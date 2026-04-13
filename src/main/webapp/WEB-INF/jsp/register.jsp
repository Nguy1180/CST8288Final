<%-- 
    Document   : register
    Created on : Apr 11, 2026, 1:56:42 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - CESC</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-wrapper">
    <div class="auth-wrapper">
        <div class="auth-card">

            <h2>Create Account</h2>
            <p class="subtitle">Campus E-scooter Sharing CoOp</p>

            <%-- Show error message if registration failed --%>
            <% String error = (String) request.getAttribute("errorMessage"); %>
            <% if (error != null) { %>
                <div class="alert-error-glass"><%= error %></div>
            <% } %>

            <%-- Registration form submits via POST to RegisterServlet --%>
            <form method="post" action="${pageContext.request.contextPath}/register">

                <%-- Full name field --%>
                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" id="name" name="name" placeholder="e.g. Alice Brown">
                </div>

                <%-- Email field --%>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="e.g. alice@algonquincollege.com">
                </div>

                <%-- Password field --%>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Create a password">
                </div>

                <%-- Role dropdown - User, Sponsor, or Maintainer --%>
                <div class="form-group">
                    <label for="role">Role</label>
                    <select id="role" name="role">
                        <option value="">-- Select your role --</option>
                        <option value="User">User</option>
                        <option value="Sponsor">Sponsor</option>
                        <option value="Maintainer">Maintainer</option>
                    </select>
                </div>

                <div style="margin-top: 24px;">
                    <input type="submit" class="btn btn-white" value="Create Account">
                </div>

            </form>

            <%-- Link back to login page --%>
            <div class="auth-link">
                Already have an account?
                <a href="${pageContext.request.contextPath}/login">Login here</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>
