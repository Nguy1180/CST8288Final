/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.ScooterDAO;
import dao.StationDAO;
import dao.MaintenanceDAO;
import dto.ScooterDTO;
import dto.StationDTO;
import dto.MaintenanceDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * DashboardServlet handles GET requests to display the main dashboard.
 * Shows summary statistics for scooters, stations and maintenance.
 * Requires the user to be logged in via session.
 *
 * @author Benilde
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    /**
     * Handles GET requests by fetching summary data and forwarding to dashboard.jsp.
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
            // Fetch summary data for dashboard stats
            ScooterDAO scooterDAO         = new ScooterDAO();
            StationDAO stationDAO         = new StationDAO();
            MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

            List<ScooterDTO>     scooters    = scooterDAO.getAllScooters();
            List<StationDTO>     stations    = stationDAO.getAllStations();
            List<MaintenanceDTO> maintenance = maintenanceDAO.getPendingMaintenance();

            // Pass counts to dashboard JSP
            request.setAttribute("scooterCount",     scooters.size());
            request.setAttribute("stationCount",     stations.size());
            request.setAttribute("maintenanceCount", maintenance.size());

            // Pass recent scooters list (first 5) for quick view
            request.setAttribute("recentScooters",
                    scooters.size() > 5 ? scooters.subList(0, 5) : scooters);

            request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error loading dashboard: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp")
                   .forward(request, response);
        }
    }
}
