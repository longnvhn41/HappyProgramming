/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MentorDAO;
import entity.MentorEntity;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dao Van Do
 */
public class CreateMentorController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        MentorEntity entity = new MentorEntity();
        
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        Date date = Date.valueOf(request.getParameter("bdate"));
        String sex = request.getParameter("sex");
        String email = request.getParameter("email-address");
        String img = request.getParameter("img");
        String phone = request.getParameter("number");
        String accountName = request.getParameter("account_name");
        String address = request.getParameter("address");
        String profession = request.getParameter("profession");
        String description = request.getParameter("profession-introduct");
        String serviceDescription = request.getParameter("service-description");
        String achievementDescition = request.getParameter("achievement-descition");
        String frameWork = request.getParameter("frame-work");
        String skill = request.getParameter("skill");
        
        entity.setAccountName(accountName);
        entity.setAchievementDescition(achievementDescition);
        entity.setAddress(address);
        entity.setDateOfBird(date);
        entity.setDescription(description);
        entity.setEmail(email);
        entity.setFrameWork(frameWork);
        entity.setName(firstName + " " + lastName);
        entity.setPhone(phone);
        entity.setProfession(profession);
        entity.setServiceDescription(serviceDescription);
        entity.setSex(sex);
        entity.setImg(img);
        entity.setSkill(skill);
        
        MentorDAO mentorDAO = new MentorDAO();
        mentorDAO.createMentor(entity);
           
        request.getRequestDispatcher("MentorController").forward(request, response);
        
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
