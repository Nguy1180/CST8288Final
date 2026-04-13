/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.ScooterDAO;
import dto.ScooterDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ScooterServlet handles GET requests to display all scooters in the system.
 * Requires the user to be logged in via session.
 *
 * @author Benilde
 */
@WebServlet("/scooters")
public class ScooterServlet extends HttpServlet {

    /**
     * Handles GET requests by fetching all scooters and forwarding to scooters.jsp.
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
            // Fetch all scooters from database
            ScooterDAO scooterDAO = new ScooterDAO();
            List<ScooterDTO> scooters = scooterDAO.getAllScooters();

            // Pass list to JSP
            request.setAttribute("scooters", scooters);
            request.getRequestDispatcher("/WEB-INF/jsp/scooters.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error loading scooters: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/scooters.jsp")
                   .forward(request, response);
        }
    }
}
