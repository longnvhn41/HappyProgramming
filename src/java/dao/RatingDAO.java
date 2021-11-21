/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tri
 */
public class RatingDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Rating> getRatingOfMentor(int id) {
        try {
            String sql = "select r.id, r.mentee_id, r.mentor_id, r.rate, r.comment, u.full_name\n"
                    + "from rating r "
                    + "left join user u "
                    + "on r.mentee_id = u.id "
                    + "where mentor_id=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            ArrayList<Rating> ratings = new ArrayList<Rating>();
            while (rs.next()) {
                int ratingId = rs.getInt(1);
                int menteeId = rs.getInt(2);
                int mentorId = rs.getInt(3);
                int stars = rs.getInt(4);
                String comment = rs.getString(5);
                String menteeName = rs.getString(6);

                Rating rating = new Rating(ratingId, menteeId, mentorId, stars, comment);
                rating.setMenteeName(menteeName);

                ratings.add(rating);

            }
            return ratings;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addRating(int menteeId, int mentorId, int rate, String comment) {
        try {
            String sql = "insert into rating (mentee_id, mentor_id, rate, comment) values (?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, menteeId);
            ps.setInt(2, mentorId);
            ps.setInt(3, rate);
            ps.setString(4, comment);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRating(int id, int rate, String comment) {
        try {
            String sql = "update rating set rate = ?, comment = ? where id = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rate);
            ps.setString(2, comment);
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAverageRating(int id) {
        try {
            String sql = "select AVG(r.rate)\n"
                    + "from rating r "
                    + "left join user u "
                    + "on r.mentee_id = u.id "
                    + "where mentor_id=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            ArrayList<Rating> ratings = new ArrayList<Rating>();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void deleteRating(int id) {
        try {
            String sql = "delete from rating where id = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
