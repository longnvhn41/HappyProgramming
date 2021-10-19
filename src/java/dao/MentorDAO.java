/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBConnect;
import entity.MentorEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorDAO {

    Connection conn = null;

    public List<MentorEntity> getListMentor() {
        List<MentorEntity> mentors = new ArrayList<>();
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            String sql = "select * from mentor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mentors.add(new MentorEntity(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    public List<MentorEntity> getListMentorByName(String name) {
        List<MentorEntity> mentors = new ArrayList<>();
        try {
            DBConnect connect = new DBConnect();
            conn = connect.con;
            String sql = "select * from mentor where name like '%" + name + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mentors.add(new MentorEntity(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }
}
