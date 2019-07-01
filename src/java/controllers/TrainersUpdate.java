/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Trainer;
import htmlcomponents.HtmlComponents;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TrainerService;

/**
 *
 * @author giorgos
 */
public class TrainersUpdate extends HttpServlet {
    
    TrainerService tserv = new TrainerService();
    HtmlComponents html = new HtmlComponents();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainersUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainersUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        long id = Long.parseLong(request.getParameter("id"));
        Trainer t = tserv.getTrainer(id);
        RequestDispatcher rd = request.getRequestDispatcher("updatetrainer.jsp");

        request.setAttribute("id", t.getId());
        request.setAttribute("fname", t.getTfname());
        request.setAttribute("lname", t.getTlname());
        request.setAttribute("subject", t.getTsubject());
        rd.forward(request, response);
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
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String subject = request.getParameter("subject");
        long id = Long.parseLong(request.getParameter("id"));
        Trainer t = new Trainer(id, fname, lname, subject);
        if(tserv.updateTrainer(t)){
            try (PrintWriter out = response.getWriter()) {
                out.println(html.startHTML("Update success"));
                out.println("<a href='/TrainersJPA'>Home</a>");
                out.println("<h1>Trainer updated successfully</h1>");
                out.println(html.endHTML());
            }
//            RequestDispatcher rd = request.getRequestDispatcher("trainers");    // ---------------------------------------------------------------
//            rd.forward(request, response);          // ΓΙΑ ΚΑΠΟΙΟ ΛΟΓΟ ΕΝΩ ΚΑΝΕΙ ΤΟ UPDATE, ΔΕΝ ΠΗΓΑΙΝΕΙ ΣΤΟ trainers
//            // -----------------------------------------------------------------------------------
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println(html.startHTML("Failed to update"));
                out.println("<a href='/TrainersJPA'>Home</a>");
                out.println("<h1>Failed to update</h1>");
                out.println(html.endHTML());
            }
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
