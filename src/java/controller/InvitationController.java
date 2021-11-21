/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.InvitationDao;
import dao.RequestDao;
import dao.SkillDao;
import dao.UserDao;
import entity.Invitation;
import entity.Request;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GHC
 */
public class InvitationController extends HttpServlet {

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
       
        RequestDao Rdao = new RequestDao();
        SkillDao Sdao = new SkillDao(); 
        InvitationDao Idao = new InvitationDao();
        UserDao Udao = new UserDao();
        try (PrintWriter out = response.getWriter()){
            String service = request.getParameter("service");
            if (service.equals("mentorInvitationList")) {
                
                response.sendRedirect("mentorInvitationList.jsp");
            }if (service.equals("mentorAccept")){
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                int requestId = Integer.parseInt(request.getParameter("requestId"));
                Invitation inv = Idao.getInvitationByMentorRequest(user.getId(), requestId);
                
                if(inv.getStatus().equals("Processing")){
                    Rdao.updateRequestStatusById(2, requestId);
                    Rdao.updateRequestMentorById(user.getId(), requestId);
                    Idao.updateInvitationStatus("Accept", inv.getId());
                    out.println(inv.getId());
                    Idao.updateInvitationCancelStatus("Cancel", requestId);
                }
                response.sendRedirect("mentorInvitationList.jsp");
            }if (service.equals("mentorDecline")){
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                int requestId = Integer.parseInt(request.getParameter("requestId"));
                Invitation inv = Idao.getInvitationByMentorRequest(user.getId(), requestId);
                Request req = Rdao.getRequestById(requestId);
                User mentee = Udao.getUserById(req.getMentee_id());
                if(inv.getStatus().equals("Processing")){
                    Idao.updateInvitationStatus("Decline", inv.getId());
                }
                
                Invitation invCheck = Idao.getDeclineInvitationListByRequest(requestId);
                if(invCheck == null){
                    String userfrom = "longnvhn41@gmail.com";
                    String passfrom = "nguyenvanlong98";
                    String subject = "Notification about you request: \"" + req.getTitle() + "\"";
                    String message = "All the mentors declined the request: \"" + req.getTitle() + "\", your request will be cancelled .";
                    UserDao.send(mentee.getEmail(), subject, message, userfrom, passfrom);
                    java.util.Date finish_date = new java.util.Date();
                    Rdao.updateRequestStatusAndDateById(3, requestId, finish_date);
                }
                 response.sendRedirect("mentorInvitationList.jsp");
            }if (service.equals("mentorCallBackAccept")){
                int requestId = Integer.parseInt(request.getParameter("requestId"));
                Idao.updateAllInvitationlStatusByReqId("Processing", requestId);
                Rdao.updateRequestStatusById(1, requestId);
                response.sendRedirect("mentorInvitationList.jsp");
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
            Logger.getLogger(InvitationController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InvitationController.class.getName()).log(Level.SEVERE, null, ex);
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
