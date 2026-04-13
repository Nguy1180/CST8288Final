<%-- 
    Document   : transactions
    Created on : Apr 11, 2026, 2:01:37 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transactions - CESC</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="page-wrapper">

    <%-- Navigation Bar --%>
    <%
        UserDTO loggedInUser = (UserDTO) session.getAttribute("loggedInUser");
        String role = (String) session.getAttribute("userRole");
    %>
    <nav class="navbar">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard"> CESC
            <span>Campus E-scooter Sharing CoOp</span>
        </a>
        <div class="navbar-links">
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/scooters">Scooters</a>
            <a href="${pageContext.request.contextPath}/stations">Stations</a>
            <% if ("Maintainer".equals(role)) { %>
                <a href="${pageContext.request.contextPath}/maintenance">Maintenance</a>
            <% } %>
            <a href="${pageContext.request.contextPath}/transactions" class="active">Transactions</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a>
        </div>
    </nav>

    <div class="content">

        <%-- Success message if transaction was added --%>
        <% String success = (String) request.getAttribute("successMessage"); %>
        <% if (success != null) { %>
            <div class="alert alert-success">✓ <%= success %></div>
        <% } %>

        <%-- Error message if any --%>
        <% String error = (String) request.getAttribute("errorMessage"); %>
        <% if (error != null) { %>
            <div class="alert alert-error"><%= error %></div>
        <% } %>

        <div class="card">
            <h2>Add Transaction 💳</h2>
            <p class="subtitle">
                Submit a credit or debit transaction for your account.
            </p>

            <%-- Transaction form submits via POST to TransactionServlet --%>
            <form method="post" action="${pageContext.request.contextPath}/transactions">

                <%-- Amount field --%>
                <div class="form-group">
                    <label for="amount">Amount ($)</label>
                    <input type="number" id="amount" name="amount"
                           placeholder="e.g. 5.00" step="0.01" min="0">
                </div>

                <%-- Transaction type dropdown --%>
                <div class="form-group">
                    <label for="type">Transaction Type</label>
                    <select id="type" name="type">
                        <option value="">-- Select type --</option>
                        <option value="CREDIT">Credit</option>
                        <option value="DEBIT">Debit</option>
                    </select>
                </div>

                <%-- Description field --%>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" id="description" name="description"
                           placeholder="e.g. Scooter rental fee">
                </div>

                <div style="display:flex; gap:10px; margin-top:24px;">
                    <input type="submit"  class="btn btn-primary"   value="Submit Transaction">
                    <input type="reset"   class="btn btn-secondary" value="Clear">
                </div>

            </form>
        </div>
    </div>

</div>
</body>
</html>
