/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import dao.IUserDao;
import dao.UserDAO;
import dto.UserDTO;

/**
 *
 * @author the_p
 */
public class UserService {
    private IUserDao user = null;
    
    public UserService() {
        user = new UserDAO();
    }
    
    public void addUser(UserDTO userdto) {
        user.addUser(userdto);
    }
    
    public UserDTO getUserByEmail(String email) {
        
        return user.getUserByEmail(email);
    }
    
    public void rewardMaintainer(int userId, double availableHours) {
        user.rewardMaintainer(userId, availableHours);
    }
}
