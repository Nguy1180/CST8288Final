<%-- 
    Document   : dashboard
    Created on : Apr 11, 2026, 1:59:52 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.UserDTO, model.ScooterDTO, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - CESC</title>
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
            <a href="${pageContext.request.contextPath}/dashboard" class="active">Dashboard</a>
            <a href="${pageContext.request.contextPath}/scooters">Scooters</a>
            <a href="${pageContext.request.contextPath}/stations">Stations</a>
            <% if ("Maintainer".equals(role)) { %>
                <a href="${pageContext.request.contextPath}/maintenance">Maintenance</a>
            <% } %>
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

        <%-- Welcome message --%>
        <div class="card">
            <h2>Welcome, <%= loggedInUser != null ? loggedInUser.getName() : "User" %>! 👋</h2>
            <p class="subtitle">Role: <%= role %> — Here's a summary of the system.</p>
        </div>

        <%-- Stats Cards --%>
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-number"><%= request.getAttribute("scooterCount") %></div>
                <div class="stat-label">Total Scooters</div>
            </div>
            <div class="stat-card">
                <div class="stat-number"><%= request.getAttribute("stationCount") %></div>
                <div class="stat-label">Charging Stations</div>
            </div>
            <div class="stat-card">
                <div class="stat-number"><%= request.getAttribute("maintenanceCount") %></div>
                <div class="stat-label">Pending Maintenance</div>
            </div>
        </div>

        <%-- Recent Scooters Table --%>
        <div class="card">
            <h2>Recent Scooters</h2>
            <%
                List<ScooterDTO> recentScooters =
                    (List<ScooterDTO>) request.getAttribute("recentScooters");
            %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Vehicle Number</th>
                        <th>Model</th>
                        <th>Color</th>
                        <th>Status</th>
                        <th>Battery</th>
                    </tr>
                </thead>
                <tbody>
                <% if (recentScooters == null || recentScooters.isEmpty()) { %>
                    <tr><td colspan="6" class="empty-msg">No scooters found.</td></tr>
                <% } else {
                    for (ScooterDTO s : recentScooters) { %>
                    <tr>
                        <td><%= s.getScooterID() %></td>
                        <td><%= s.getVehicleNumber() %></td>
                        <td><%= s.getModel() %></td>
                        <td><%= s.getColor() %></td>
                        <td>
                            <span class="badge
                                <%= "available".equalsIgnoreCase(s.getStatus()) ? "badge-available" :
                                   "in-use".equalsIgnoreCase(s.getStatus())    ? "badge-inuse" :
                                   "badge-maintenance" %>">
                                <%= s.getStatus() %>
                            </span>
                        </td>
                        <td><%= s.getCurrentCharge() %>%</td>
                    </tr>
                <% } } %>
                </tbody>
            </table>
            <div style="margin-top:16px;">
                <a href="${pageContext.request.contextPath}/scooters" class="btn btn-primary">
                    View All Scooters
                </a>
            </div>
        </div>
    </div>

</div>
</body>
</html>
