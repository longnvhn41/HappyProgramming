/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.DBConnect;
import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Van Long
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setAttribute("mess", "");
        response.setContentType("text/html;charset=UTF-8");
        DBConnect dBConnect = new DBConnect();
        UserDao d = new UserDao(dBConnect);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            ServletContext sc = getServletContext();
            if (service.equals("Signup")) {
                String name = request.getParameter("fullname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String account = request.getParameter("username");
                String pass = request.getParameter("password");
                String rpass = request.getParameter("rpassword");
                String dob = request.getParameter("birthday");
                int gender = Integer.parseInt(request.getParameter("gender"));
                String address = request.getParameter("address");
                int role = 1;
                User user = new User(name, account, pass, email, phone, dob, gender, address, role);
                sc.setAttribute("newuser", user);

                User u = d.checkUserExits(account);
                if (u == null) {
                    if (!pass.equals(rpass)) {
                        request.setAttribute("mess", "The Password you entered did not match, please try again!");
                        request.getRequestDispatcher("signup.jsp").forward(request, response);
                    } else {
                        String userfrom = "longnvhn41@gmail.com";
                        String passfrom = "nguyenvanlong98";
                        String code = d.getRandom();
                        String subject = "User Email Verification";
                        String message = ("Registered successfully.Please verify your account using this code: " + code);
                        HttpSession session = request.getSession();
                        session.setAttribute("check", code);
                        UserDao.send(email, subject, message, userfrom, passfrom);
                        response.sendRedirect("verify.jsp");
                    }

                } else {
                    request.setAttribute("alert", "Account already exists!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }

            }
            if (service.equals("checkCode")) {
                HttpSession session = request.getSession();
                String codeAuth = session.getAttribute("check").toString();
                User user = (User) sc.getAttribute("newuser");
                String code = request.getParameter("authcode");
                if (code.equals(codeAuth)) {
                    d.addCustomer(user.getName(), user.getAccount(), user.getPassword(), user.getEmail(),
                            user.getPhone(), user.getDob(), user.getGender(), user.getAddress(), user.getRole());
                    out.println("Correct");
                } else {
                    out.println("Incorrect verification code");
                }
            }
            if(service.equals("login")){
                String acc = request.getParameter("username");
                String password = request.getParameter("password");
                User u=d.checkUser(acc, password);
                if(u==null){
                    HttpSession session=request.getSession();
                    session.removeAttribute("acc");
                    response.sendRedirect("login.jsp");
                }else{
                    HttpSession session=request.getSession();
                    session.setAttribute("user", u);
                    request.getRequestDispatcher("homepage.jsp").forward(request, response);
                }
            }
            if(service.equals("logout")){
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("homepage.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
