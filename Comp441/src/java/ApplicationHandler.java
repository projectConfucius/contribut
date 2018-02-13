/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Users.Application;
import Data.DataIO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Makosi
 */
@WebServlet(name="ApplicationHandler", urlPatterns = {"confucius"})
public class ApplicationHandler extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       request.getRequestDispatcher("confucius/applicationFormHandler.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       // get parameters from the form
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       String fname = request.getParameter("fname");
       String lname = request.getParameter("lname");
       String choice = request.getParameter("choice");
       String regNo = request.getParameter("regNo");
       String gender = request.getParameter("gender");
       
       HttpSession session = request.getSession(false);
       if(session!=null)
           session.setAttribute("fname", fname);
       
       
       if(DataIO.validate(fname, lname, choice, gender, regNo))
       {
           RequestDispatcher rd=request.getRequestDispatcher("proficiencyTest.html");
           rd.forward(request, response);
       }
       else
       {
           out.print("<p style=\"color:red\">Sorry Fields error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("applicationHandler.jsp");  
            rd.include(request,response);
       }
       out.close();
       // create the User object from the parameters
       Application user = new Application(fname, lname, choice, gender, regNo);
       
       // Validate the parameters
       String message = "";
       String url = "";
       
       if (fname.length() == 0 || lname.length() == 0 || choice.length() == 0 || gender.length()== 0 ||
               regNo.length() == 0)
       {
           message = "Please fill out missing values in the text boxes.";
           url = "confucius/applicationFormHandler.jsp";
       }
       else
       {
           message = "";
           
           url = "confucius/applicationFormHandler.jsp"; // *show you the entry.
       }
       request.setAttribute("user", user);
       request.setAttribute("message", message);
       
       // forward request and response objects to JSP page
       
       if (choice == "no")
       {
           url = "confucius/goodBye.jsp";
       }
       else
       {
           url = "confucius/proficiencyTest.html";
       }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
