/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.MaintenanceDAO;
import model.MaintenanceDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * MaintenanceServlet handles GET requests to display all pending maintenance alerts.
 * Only accessible by users with the Maintainer role.
 *
 * @author Benilde
 */
@WebServlet("/maintenance")
public class MaintenanceServlet extends HttpServlet {

    /**
     * Handles GET requests by fetching pending maintenance records
     * and forwarding to maintenance.jsp.
     * Redirects to login if no session, or dashboard if not a Maintainer.
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

        // Only Maintainers can access this page
        String role = (String) session.getAttribute("userRole");
        if (!"Maintainer".equals(role)) {
            request.setAttribute("errorMessage",
                    "Access denied. Only Maintainers can view maintenance records.");
            request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp")
                   .forward(request, response);
            return;
        }

        try {
            // Fetch all pending maintenance records
            MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
            List<MaintenanceDTO> maintenance = maintenanceDAO.getPendingMaintenance();

            // Pass list to JSP
            request.setAttribute("maintenance", maintenance);
            request.getRequestDispatcher("/WEB-INF/jsp/maintenance.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error loading maintenance: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/maintenance.jsp")
                   .forward(request, response);
        }
    }
}
