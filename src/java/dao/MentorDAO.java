/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBConnect;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dao Van Do
 */
public class MentorDAO {

    Connection conn = null;

    public List<User> getListMentor() {
        List<User> users = new ArrayList<>();
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            String sql = "select * from happyprogramming.user where role = 0";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                users.add((new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11),
                        rs.getString(12))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> getListMentorByName(String name) {
        List<User> users = new ArrayList<>();
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            String sql = "select * from happyprogramming.user where full_name like '%" + name + "%' and role = 0";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                users.add((new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getString(17), rs.getInt(18))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createMentor(User user) {
        String sql = "UPDATE happyprogramming.user\n"
                + "SET role = ?, framework = ?, profession = ?, description =?, "
                + "serviceDescription = ?, achievementDescition = ?, skill = ?\n"
                + "WHERE id = ?;";
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, 0);
            pre.setString(2, user.getFramework());
            pre.setString(3, user.getProfession());
            pre.setString(4, user.getDescription());
            pre.setString(5, user.getServiceDescription());
            pre.setString(6, user.getAchievementDescition());
            pre.setString(7, user.getSkill());
            pre.setInt(8, user.getId());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getMentorById(int id) {
        User user = new User();
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            String sql = "select * from happyprogramming.user where id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getString(17), rs.getInt(18));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
