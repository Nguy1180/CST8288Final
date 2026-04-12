<%-- 
    Document   : scooters
    Created on : Apr 11, 2026, 2:00:06 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ScooterDTO, model.UserDTO, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Scooters - CESC</title>
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
            <a href="${pageContext.request.contextPath}/scooters" class="active">Scooters</a>
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

        <div class="card">
            <h2>All Scooters 🛴</h2>

            <%
                List<ScooterDTO> scooters =
                    (List<ScooterDTO>) request.getAttribute("scooters");
            %>
            <p class="count-msg">
                <%= scooters != null ? scooters.size() : 0 %> scooter(s) in the system.
            </p>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Vehicle Number</th>
                        <th>Manufacturer</th>
                        <th>Model</th>
                        <th>Color</th>
                        <th>Battery Capacity</th>
                        <th>Current Charge</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <% if (scooters == null || scooters.isEmpty()) { %>
                    <tr><td colspan="8" class="empty-msg">No scooters found.</td></tr>
                <% } else {
                    for (ScooterDTO s : scooters) { %>
                    <tr>
                        <td><%= s.getScooterID() %></td>
                        <td><%= s.getVehicleNumber() %></td>
                        <td><%= s.getManufactorer() %></td>
                        <td><%= s.getModel() %></td>
                        <td><%= s.getColor() %></td>
                        <td><%= s.getBatteryCapacity() %> kWh</td>
                        <td><%= s.getCurrentCharge() %>%</td>
                        <td>
                            <span class="badge
                                <%= "available".equalsIgnoreCase(s.getStatus()) ? "badge-available" :
                                   "in-use".equalsIgnoreCase(s.getStatus())    ? "badge-inuse" :
                                   "badge-maintenance" %>">
                                <%= s.getStatus() %>
                            </span>
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
