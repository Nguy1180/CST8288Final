/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.UserDAO;
import model.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RegisterServlet handles GET requests to display the registration form
 * and POST requests to create a new user account.
 *
 * @author Benilde
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
     * Handles GET requests by forwarding to the register JSP page.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
               .forward(request, response);
    }

    /**
     * Handles POST requests by validating input and creating a new user.
     * On success, redirects to login page.
     * On failure, returns an error message to the register page.
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
        String name     = request.getParameter("name");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        String role     = request.getParameter("role");

        // Basic blank field validation
        if (name == null || name.isBlank() ||
            email == null || email.isBlank() ||
            password == null || password.isBlank() ||
            role == null || role.isBlank()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
                   .forward(request, response);
            return;
        }

        // Check if email already exists
        UserDAO userDAO = new UserDAO();
        UserDTO existing = userDAO.getUserByEmail(email.trim());
        if (existing != null) {
            request.setAttribute("errorMessage", "An account with this email already exists.");
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
                   .forward(request, response);
            return;
        }

        // Build new user DTO and insert
        UserDTO newUser = new UserDTO();
        newUser.setName(name.trim());
        newUser.setEmail(email.trim());
        newUser.setPassword(password);
        newUser.setRole(role);
        userDAO.addUser(newUser);

        // Redirect to login with success message
        response.sendRedirect(request.getContextPath() + "/login?registered=true");
    }
}
