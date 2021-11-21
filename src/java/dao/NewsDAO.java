/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.News;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewsDAO {

    Connection conn = null;

    public List<News> getListNews() {
        List<News> users = new ArrayList<>();
        try {
            DBContext connect = new DBContext();
            conn = connect.getConnection();
            String sql = "select * from happyprogramming.news";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                users.add((new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
