/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Van Long
 */
public class InvitationDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int countRequestByMentor(int mentorID) {

        int num = 0;
        String query = "SELECT COUNT(*) FROM request WHERE mentor_id=?";
        try {
            conn = new testDao().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, mentorID);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return num;
    }
    public int getUserByEmail(String email) {
        int n=0;
        String sql = "select id from [user] where email=?";
        try {
            conn = new testDao().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                n=rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return n;
    }
    public int getHighestRequestID() {
        String query = "SELECT MAX(id) FROM request";
        try {
            conn = new testDao().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
          
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
