/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import context.DBContext;
import entity.Request_Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Long
 */
public class RequestHandleDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int addRequest(int menteeID, String mess, int status) {
        int n = 0;
        //String sql="insert into request(mentee_id, [message],request_date,[status]) values (?,?,?,?)";
        String sql = "insert into request(mentee_id, [message],[status]) values (?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, menteeID);
            ps.setString(2, mess);
            ps.setInt(3, status);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public ArrayList<Request_Skill> getRequestSkillListByRequest(int requestID) {
        ArrayList<Request_Skill> requestSkillList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM request_skill where request_id = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, requestID);
            rs = ps.executeQuery();
            while (rs.next()) {
                requestSkillList.add(new Request_Skill(rs.getInt(1), rs.getInt(2)));
            }
            return requestSkillList;
        } catch (Exception e) {
        }
        return null;
    }

    public int countRequestByMentor(int mentorID) {

        int num = 0;
        String sql = "select count(*) from request WHERE mentor_id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mentorID);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            
        }

        return num;
    }
    public void updateStatusRequest(int requestId) {
        String sql = "update request set status=3 where id = ?";

        try {       
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, requestId);            
            ps.executeUpdate();           
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public String findEmailByIDrq(int IDrq) {

        String email=null;
        String sql = "select u.email from request as rq join user as u on u.id=rq.mentee_id where rq.id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, IDrq);
            rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString(1);
            }
        } catch (Exception e) {
            
        }

        return email;
    }
    
}
