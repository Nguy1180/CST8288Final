/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.StationDAO;
import dto.StationDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * StationServlet handles GET requests to display all charging stations.
 * Requires the user to be logged in via session.
 *
 * @author Benilde
 */
@WebServlet("/stations")
public class StationServlet extends HttpServlet {

    /**
     * Handles GET requests by fetching all stations and forwarding to stations.jsp.
     * Redirects to login if no active session is found.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            // Fetch all stations from database
            StationDAO stationDAO = new StationDAO();
            List<StationDTO> stations = stationDAO.getAllStations();

            // Pass list to JSP
            request.setAttribute("stations", stations);
            request.getRequestDispatcher("/WEB-INF/jsp/stations.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error loading stations: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/stations.jsp")
                   .forward(request, response);
        }
    }
}
