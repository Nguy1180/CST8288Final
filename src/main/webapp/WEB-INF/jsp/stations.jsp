<%-- 
    Document   : stations
    Created on : Apr 11, 2026, 2:00:36 a.m.
    Author     : Benilde
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.StationDTO, model.UserDTO, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stations - CESC</title>
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
            <a href="${pageContext.request.contextPath}/stations" class="active">Stations</a>
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
            <h2>Charging Stations ⚡</h2>

            <%
                List<StationDTO> stations =
                    (List<StationDTO>) request.getAttribute("stations");
            %>
            <p class="count-msg">
                <%= stations != null ? stations.size() : 0 %> station(s) in the system.
            </p>

            <table>
                <thead>
                    <tr>
                        <th>Station ID</th>
                        <th>Name</th>
                        <th>Location</th>
                    </tr>
                </thead>
                <tbody>
                <% if (stations == null || stations.isEmpty()) { %>
                    <tr><td colspan="3" class="empty-msg">No stations found.</td></tr>
                <% } else {
                    for (StationDTO st : stations) { %>
                    <tr>
                        <td><%= st.getStationID() %></td>
                        <td><%= st.getName() %></td>
                        <td><%= st.getLocation() %></td>
                    </tr>
                <% } } %>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
