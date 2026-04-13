/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.UserDAO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet handles GET requests to display the login form
 * and POST requests to authenticate a user.
 *
 * @author Benilde
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
     * Handles GET requests by forwarding to the login JSP page.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to login page
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
               .forward(request, response);
    }

    /**
     * Handles POST requests by validating user credentials.
     * On success, creates a session and redirects to dashboard.
     * On failure, returns an error message to the login page.
     *
     * @param request  the HttpServletRequest containing form data
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read form fields
        String email    = request.getParameter("email");
        String password = request.getParameter("password");

        // Basic blank field validation
        if (email == null || email.isBlank() ||
            password == null || password.isBlank()) {
            request.setAttribute("errorMessage", "Email and password are required.");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                   .forward(request, response);
            return;
        }

        // Look up user by email
        UserDAO userDAO = new UserDAO();
        UserDTO user = userDAO.getUserByEmail(email.trim());

        // Check if user exists and password matches
        if (user == null || user.getPassword() == null || !user.getPassword().equals(password)) {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                   .forward(request, response);
            return;
        }

        // Create session and store logged-in user
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", user);
        session.setAttribute("userRole", user.getRole());

        // Redirect to dashboard
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
