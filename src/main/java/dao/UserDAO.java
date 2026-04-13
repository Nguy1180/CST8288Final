/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import dto.UserDTO;

/**
 * DAO class for handling user-related operations.
 * @author tomye
 */
public class UserDAO implements IUserDao{
    
    /**
     * Inserts new user into the db.
     * @param user UserDTO object containing user details.
     */
    @Override
    public void addUser(UserDTO user) {
        // Establishes connection to the DB.
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to insert a new user.
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            // Prepares SQL statement.
            PreparedStatement ps = conn.prepareStatement(sql);
            // Sets value from the DTO into the query parameters.
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            // Executes the insert.
            ps.executeUpdate();
        } catch (Exception e) {
            // Prints if error occurs.
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves a user from the database by email.
     * @param email Email used to search for the user.
     * @return UserDTO object if found, otherwise null.
     */
    public UserDTO getUserByEmail(String email) {
        // Initialize user object as null.
        UserDTO user = null;
        // Establish connection to the db.
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to find user by email.
            String sql = "SELECT * FROM users WHERE email = ?";
            // Prepare statement and sets email parameter.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            // If matching user is found.
            if (rs.next()) {
                // Creates objects and populates the fields.
                user = new UserDTO();
                user.setUserID(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            // Prints if error occurs.
            e.printStackTrace();
        }
        // Return user object or null if not found.
        return user;
    }
    
    public String getUserRole(int id) {
        String role = "";
        // Establish connection to the db.
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to find user by email.
            String sql = "SELECT * FROM users WHERE role = ?";
            // Prepare statement and sets email parameter.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            // If matching user is found.
            if (rs.next()) {
                // Creates objects and populates the fields.
                role = rs.getString("role");
                
            }
        } catch (Exception e) {
            // Prints if error occurs.
            e.printStackTrace();
        }
        // Return user object or null if not found.
        return role;        
    }
    
    public boolean isAdmin(int userId) throws Exception {
        return "ADMIN".equalsIgnoreCase(getUserRole(userId));
    }
    
    public void rewardMaintainer(int userId, double availableHours) {
        try (Connection conn = DBConnection.getConnection()) {
            double credit = availableHours * 0.5;

    String sql = "INSERT INTO transactions (user_id, amonut, type, description) VALUES (?, ?, 'CREDIT', ?)";

    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, userId);
    stmt.setDouble(2, credit);
    stmt.setString(3, "\"Sponsor scooter availability reward\"");

    stmt.executeUpdate();
            
        }
        catch(Exception e) {
            
        }   
    }
}