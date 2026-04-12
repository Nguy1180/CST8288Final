<%-- 
    Document   : maintenance
    Created on : Apr 11, 2026, 2:01:13 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.MaintenanceDTO, model.UserDTO, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maintenance - CESC</title>
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
            <a href="${pageContext.request.contextPath}/maintenance" class="active">Maintenance</a>
            <a href="${pageContext.request.contextPath}/transactions">Transactions</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a>
        </div>
    </nav>

    <div class="content">

        <%-- Error message if any --%>
        <% String error = (String) request.getAttribute("errorMessage"); %>
        <% if (error != null) { %>
            <div class="alert alert-error"><%= error %></div>
        <% } %>

        <div class="card">
            <h2>Pending Maintenance Alerts 🔧</h2>

            <%
                List<MaintenanceDTO> maintenance =
                    (List<MaintenanceDTO>) request.getAttribute("maintenance");
            %>
            <p class="count-msg">
                <%= maintenance != null ? maintenance.size() : 0 %> pending alert(s).
            </p>

            <table>
                <thead>
                    <tr>
                        <th>Maintenance ID</th>
                        <th>Scooter ID</th>
                        <th>Issue</th>
                        <th>Scheduled Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <% if (maintenance == null || maintenance.isEmpty()) { %>
                    <tr><td colspan="5" class="empty-msg">No pending maintenance alerts.</td></tr>
                <% } else {
                    for (MaintenanceDTO m : maintenance) { %>
                    <tr>
                        <td><%= m.getMaintenanceID() %></td>
                        <td><%= m.getScooterID() %></td>
                        <td><%= m.getIssue() %></td>
                        <td><%= m.getScheduledDate() %></td>
                        <td>
                            <span class="badge badge-pending"><%= m.getStatus() %></span>
                        </td>
                    </tr>
                <% } } %>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
