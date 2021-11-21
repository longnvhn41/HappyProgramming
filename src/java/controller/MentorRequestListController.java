/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.DBConnect;
import dao.RatingDAO;
import dao.RequestDao;
import dao.UserDao;
import entity.MentorStatistic;
import entity.Rating;
import entity.Request;
import entity.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tri
 */
@WebServlet(name = "MentorRequestListController", urlPatterns = {"/MentorRequestList"})
public class MentorRequestListController extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            DBConnect db = new DBConnect();
            RequestDao rd = new RequestDao(db);
            UserDao ud = new UserDao(db);
            RatingDAO rtd = new RatingDAO(db);
            User u = (User) request.getSession().getAttribute("user");
//            User u = ud.getUserById(12);
            request.getSession().setAttribute("user", u);
            request.setAttribute("user", u);
            
            ArrayList<Rating> ratings = rtd.getRatingOfMentor(u.getId());
            request.setAttribute("ratings", ratings);
            
            int averageStars = rtd.getAverageRating(u.getId());
            request.setAttribute("averageStars", averageStars);
            
            ArrayList<Request> requests = rd.getRequestsByMentorId(u.getId());
            ArrayList<Request> pending = new ArrayList<>();
            ArrayList<Request> history = new ArrayList<>();
            for (Request r : requests) {
                if (r.getStatus() == 0) {
                    pending.add(r);
                } else {
                    history.add(r);
                }
            }
            request.setAttribute("pending", pending);
            request.setAttribute("history", history);

            MentorStatistic ms = rd.getRequestStatistic(u.getId());
            request.setAttribute("ms", ms);

            request.getRequestDispatcher("mentorRequestList.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(MentorRequestListController.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
