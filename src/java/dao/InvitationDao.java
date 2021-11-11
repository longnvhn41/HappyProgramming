/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBConnect;
import entity.Invitation;
import entity.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Van Long
 */
public class InvitationDao {

    Connection conn = null;

    DBConnect dbConn = null;

    public InvitationDao(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbConn = dbconn;
    }

    public int countRequestByMentor(int mentorID) {

        int num = 0;
        String query = "SELECT COUNT(*) FROM request WHERE mentor_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, mentorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return num;
    }
    
    public int getUserByEmail(String email) {
        int n = 0;
        String sql = "select id from [user] where email=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return n;
    }

    public int maxRequestID() {
        String query = "SELECT MAX(id) FROM request";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public int menteeInSystem() {
        String query = "SELECT COUNT(id) FROM [user]where role=1";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public int countComment(int id) {
        String query = "select COUNT(mentee_id) from rating where mentor_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public int rateting(int id) {
        int count=0;
        List<String> list= new ArrayList<>();
        String query = "select comment from rating where mentor_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getString(1)!=(null)){
                     list.add(rs.getString(1));
                     count=list.size();
                }
               
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
    public int mentorInSystem() {
        String query = "SELECT COUNT(id) FROM [user]where role=0";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public int skillsInSystem() {
        String query = "SELECT COUNT(id) FROM skill";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public void createInvitation(Invitation invitation) throws Exception {
        String query = "insert into invitation values (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, invitation.getRequest_id());
            ps.setInt(2, invitation.getMentor_id());
            ps.setString(3, invitation.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Invitation getInvitationByMentorRequest(int mentorID, int requestID) {

       
        String query = "select * from invitation where mentor_id=? and request_id=?";

        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, mentorID);
            ps.setInt(2, requestID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new Invitation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
            }
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Invitation> getInvitationListByMentorId(int id){
        List<Invitation> ls = new ArrayList<Invitation>();
        String query = "SELECT * From Invitation where mentor_id = (?)";
        try {
            conn = new DBConnect().con;

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 ls.add(new Invitation(rs.getInt("id"), rs.getInt("request_id"), rs.getInt("mentor_id"), rs.getString("status")));
            }
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ls;
    }
    
    public void updateInvitationStatus(String status, int inv_id){
        String query = "UPDATE Invitation SET status = (?) WHERE id = (?)";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, inv_id);
            ps.executeUpdate();
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateInvitationCancelStatus(String status, int request_id){
        String query = "UPDATE Invitation SET status = (?) where request_id = (?) and status = 'Processing'";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, request_id);
            ps.executeUpdate();
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Invitation getDeclineInvitationListByRequest(int requestID) {

       
        String query = "select * from invitation where request_id = (?) and status = 'Processing'";

        try {       
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, requestID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new Invitation(rs.getInt("id"), rs.getInt("request_id"), rs.getInt("mentor_id"), rs.getString("status"));
            }
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        DBConnect dbconn = new DBConnect();
        InvitationDao idao = new InvitationDao(dbconn);
        idao.updateInvitationStatus("Accept", 8);
        System.out.println("ahihi");
        Invitation i1 = idao.getDeclineInvitationListByRequest(12);
        System.out.println(i1.getId());

    }

}
