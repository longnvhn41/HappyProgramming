/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import context.DBContext;
import entity.Skill;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Nguyen Van Long
 */
public class UserDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public static int randomNumber(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max - min) + 1) + min;
    }

    public String getRandom2(int numberOfCharactor) {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void send(String to, String sub,
            String msg, final String user, final String pass) {
        //Tạo 1 Properties(key-value)
        Properties props = new Properties();

        //Thông số kết nối tới Smtp Server--> đăng nhập email
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addUser(String cname, String account, String password, String email,
            String phone, String dob, int gender, String address, int role, String ava, String framework) {

        int n = 0;
        String sql = "INSERT INTO happyprogramming.`user` (full_name, account, password, email, phone, DOB, gender, address, role) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, dob);
            ps.setInt(7, gender);
            ps.setString(8, address);
            ps.setInt(9, role);
            
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public User checkUserExitsAccount(String user) {
        try {
            String sql = "select * from user where account=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User checkUser(String user, String pass) {
        try {
            String sql = "select * from user where account=? and password=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public User checkExitsEmail(String email) {
        try {
            String sql = "select * from user where email=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User showUserProfile(String account) {
        try {
            String sql = "select * from user where account=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9));
                return u;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void updateUser(String id, String name, String acc, String pass, String email,
            String phone, String dob, String sex, String address) {
        String sql = "update user set full_name=?, account=?, "
                + "password=?,email=?,phone=?, "
                + "DOB=?, gender=?, address=? where id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, acc);
            ps.setString(3, pass);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, dob);
            ps.setString(7, sex);
            ps.setString(8, address);
            ps.setString(9, id);
            ps.executeUpdate();

        } catch (SQLException ex) {

        }
    }

    public void updatePassUser(String email, String password) {
        String sql = "Update user SET password=? WHERE email=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean changePass(String account, String password) {
        try {
            String sql = "  UPDATE User\n"
                    + "SET password = (?) WHERE account =(?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, account);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void addRequestMentor(int userid, int sid, String intro, int status) {
        String sql = "insert into request_mentor_skill(userid, skillid, introduce, status) values (?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, sid);
            ps.setString(3, intro);
            ps.setInt(4, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void changeRoleforUser(int role, int userid) {
        String sql = "Update user SET role=? WHERE id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, role);
            ps.setInt(2, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateRole(String email) {
        String sql = "Update User SET role=0 WHERE email=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateRole2(String email) {
        String sql = "Update User SET role=1 WHERE email=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<User> getPaginatedMentors() {
        try {
            String sql = "SELECT * FROM User WHERE role = 0";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<User> mentors = new ArrayList<User>();
            int i = 0;
            while (rs.next()) {
                mentors.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9)));
            }

            return mentors;

        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void demoteUser(int id) {
        String sql = "Update User SET role=1 WHERE id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxRequest_BecomeMentorId() {
        String sql = "SELECT MAX(id) FROM request_mentor_skill";
        int output = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                output = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return output;
    }

    public void deleteRequestBecomeMentor(int id) {

        String sql = "delete from request_mentor_skill where id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User getUserById(int id) {
        try {
            String sql = "select * from User where id=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9));
                return u;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void updateFramework(String frame, int IdUSer) {
        String sql = "UPDATE user SET framework =? WHERE id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, frame);
            ps.setInt(1, IdUSer);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
    }

    public Skill nameSkill(int IDSkill) {
        try {
            String sql = "select * from skill where id=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, IDSkill);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Skill(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }

        return null;
    }

    

}
