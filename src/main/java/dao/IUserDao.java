/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.UserDTO;

/**
 *
 * @author the_p
 */
public interface IUserDao {
    void addUser(UserDTO user);
    UserDTO getUserByEmail(String email);
    void rewardMaintainer(int userId, double availableHours);
}

