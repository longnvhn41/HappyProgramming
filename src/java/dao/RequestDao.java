/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBConnect;
import entity.MentorStatistic;
import entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Long
 */
public class RequestDao {

    Connection conn = null;

    DBConnect dbConn = null;

    public RequestDao(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbConn = dbconn;
    }

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public int getMaxRequestId() {
        String query = "SELECT MAX(id)FROM Request";
        int output = 0;
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                output = rs.getInt(1);
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
                con.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println(e);
            output = -2;
        }
        return output;
    }

    public void createRequest(Request request) {
        String query = "insert into request values (?, null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, request.getMentee_id());
            ps.setString(2, request.getMess());
            ps.setDate(3, request.getDeadline() == null ? null : new java.sql.Date(request.getDeadline().getTime()));
            ps.setDate(4, request.getCreationDate() == null ? null : new java.sql.Date(request.getCreationDate().getTime()));
            ps.setDate(5, request.getFinishDate() == null ? null : new java.sql.Date(request.getFinishDate().getTime()));
            ps.setInt(6, request.getStatus());
            ps.setFloat(7, request.getDeadlineHour());
            ps.setString(8, request.getTitle());
            ps.executeUpdate();

            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Request getRequestById(int id){
        String query = "SELECT * From Request where id = (?)";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Request(rs.getInt("id"), rs.getInt("mentee_id"), 
                        rs.getInt("mentor_id"), rs.getString("message"),rs.getString("title"), 
                        rs.getDate("deadline_date"), rs.getDate("creation_date"), rs.getDate("finish_date"), 
                        rs.getInt("status"), rs.getFloat("hours"));
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
                con.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Request> getListRequestById(int id){
        List<Request> ls = new ArrayList<Request>();
        String query = "SELECT * From Request where mentee_id = (?)";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                 ls.add(new Request(rs.getInt("id"), rs.getInt("mentee_id"), 
                        rs.getInt("mentor_id"), rs.getString("message"),rs.getString("title"), 
                        rs.getDate("deadline_date"), rs.getDate("creation_date"), rs.getDate("finish_date"), 
                        rs.getInt("status"), rs.getFloat("hours")));
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
                con.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ls;
    }
    
    public void updateRequestByMentee(int requestId, String message, int status, float hours, String title, Date deadline_date, Date finish_date){
        String query = "Update request set message=(?), status=(?), hours=(?) , title =(?) , deadline_date=(?), finish_date=(?) where id =(?);";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, message);
            ps.setInt(2, status);
            ps.setFloat(3, hours);
            ps.setString(4, title);
            ps.setDate(5, new java.sql.Date(deadline_date.getTime()));
            ps.setDate(6, finish_date == null ? null : new java.sql.Date(finish_date.getTime()));
            ps.setInt(7, requestId);
            ps.executeUpdate();
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int getMentorNumberById(int id){
        String query = "SELECT COUNT(distinct mentor_id) FROM request WHERE mentee_id = (?)";
        try {
            conn = new DBConnect().con;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
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
                con.close();
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }
    
    /*public static void main(String[] args) throws SQLException {
        DBConnect dconn = new DBConnect();
        RequestDao r =new RequestDao(dconn);
        List<Request> r1 = r.getListRequestById(1);
        System.out.println(r1.get(1).getMess());
    }*/
    
    public ArrayList<Request> getRequestsByMentorId(int mentorId) {
        try {
            String sql = "select r.id, u.full_name, r.title, r.message, r.status, r.creation_date \n"
                    + "from request r \n"
                    + "left join user u on r.mentee_id = u.id\n"
                    + "where r.mentor_id = ?\n"
                    + "order by r.creation_date DESC";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mentorId);

            ResultSet rs = pre.executeQuery();

            ArrayList<Request> requests = new ArrayList<>();
            while (rs.next()) {
                Request rq = new Request();
                rq.setId(rs.getInt("id"));
                rq.setMenteeName(rs.getString("full_name"));
                rq.setTitle(rs.getString("title"));
                rq.setMess(rs.getString("message"));
                rq.setStatus(rs.getInt("status"));
                rq.setCreationDate(rs.getDate("creation_date"));

                requests.add(rq);
            }
            return requests;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public MentorStatistic getRequestStatistic(int mentorId) {
        try {
            String sql = "select t.totalRequest, p.pendingRequest, a.acceptedRequest, r.rejectedRequest \n"
                    + "from (\n"
                    + "	select COUNT(id) as totalRequest\n"
                    + "	from request \n"
                    + "	where mentor_id = ?\n"
                    + ") as t\n"
                    + ", (\n"
                    + "	select COUNT(id) as pendingRequest\n"
                    + "	from request\n"
                    + "	where mentor_id =? and status = 0\n"
                    + ") as p\n"
                    + ", (\n"
                    + "	select COUNT(id) as acceptedRequest\n"
                    + "	from request\n"
                    + "	where mentor_id =? and status = 1\n"
                    + ") as a\n"
                    + ", (\n"
                    + "	select COUNT(id) as rejectedRequest\n"
                    + "	from request\n"
                    + "	where mentor_id =? and status = 2\n"
                    + ") as r";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mentorId);
            pre.setInt(2, mentorId);
            pre.setInt(3, mentorId);
            pre.setInt(4, mentorId);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                int totalRequest = rs.getInt("totalRequest");
                int pendingRequest = rs.getInt("pendingRequest");
                int acceptedRequest = rs.getInt("acceptedRequest");
                int rejectedRequest = rs.getInt("rejectedRequest");

                MentorStatistic ms = new MentorStatistic(totalRequest, pendingRequest, acceptedRequest, rejectedRequest);
                
                System.out.println(ms.getAcceptedRequest());
                return ms;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
