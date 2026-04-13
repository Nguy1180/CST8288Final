/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import dao.TransactionDAO;
import dto.TransactionDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TransactionServlet handles GET requests to display the transaction form
 * and POST requests to submit a new transaction.
 * Requires the user to be logged in via session.
 *
 * @author Benilde
 */
@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {

    /**
     * Handles GET requests by forwarding to transactions.jsp.
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

        request.getRequestDispatcher("/WEB-INF/jsp/transactions.jsp")
               .forward(request, response);
    }

    /**
     * Handles POST requests by reading form data and adding a new transaction.
     * On success, redirects to dashboard. On failure, shows error message.
     *
     * @param request  the HttpServletRequest containing form data
     * @param response the HttpServletResponse
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Get logged in user from session
        UserDTO loggedInUser = (UserDTO) session.getAttribute("loggedInUser");

        // Read form fields
        String amountStr    = request.getParameter("amount");
        String type         = request.getParameter("type");
        String description  = request.getParameter("description");

        // Basic blank field validation
        if (amountStr == null || amountStr.isBlank() ||
            type == null || type.isBlank() ||
            description == null || description.isBlank()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("/WEB-INF/jsp/transactions.jsp")
                   .forward(request, response);
            return;
        }

        try {
            // Build transaction DTO and insert
            TransactionDTO t = new TransactionDTO();
            t.setUserID(loggedInUser.getUserID());
            t.setAmount(Double.parseDouble(amountStr));
            t.setType(type);
            t.setDescription(description.trim());

            TransactionDAO transactionDAO = new TransactionDAO();
            transactionDAO.addTransaction(t);

            // Redirect to dashboard with success message
            request.setAttribute("successMessage", "Transaction added successfully!");
            request.getRequestDispatcher("/WEB-INF/jsp/transactions.jsp")
                   .forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid amount entered.");
            request.getRequestDispatcher("/WEB-INF/jsp/transactions.jsp")
                   .forward(request, response);
        }
    }
}
