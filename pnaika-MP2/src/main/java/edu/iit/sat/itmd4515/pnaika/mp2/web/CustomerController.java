/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.web;
import edu.iit.sat.itmd4515.pnaika.mp2.model.DelCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.service.CrmService;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Compiler.command;
import java.rmi.ServerException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.codegen.Compiler.LOG;
import java.util.Date;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prashanth
 */

@WebServlet(name = "CustomerController", urlPatterns = {"/index",
                                                        "/readCustomer",
                                                        "/insertCustomerAdds",
                                                        "/updateCustomer",
                                                        "/deleteCustomer"})

public class CustomerController extends HttpServlet {
    @Inject
    private CrmService svc;
    
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
            HttpSession session = request.getSession();
        switch(request.getServletPath()){
            case "/readCustomer":
                request.setAttribute("customer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/readCustomer.jsp").forward(request, response);
                break;
            case "/insertCustomerAdds":
                request.getRequestDispatcher("/WEB-INF/pages/actor/insertCustomerAdds.jsp").forward(request, response);
                break;
            case "/updateCustomer":
                request.setAttribute("updateCustomer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/updateCustomer.jsp").forward(request, response);
                break;
            case "/deleteCustomer":
                request.setAttribute("deleteCustomer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/deleteCustomer.jsp").forward(request, response);
                break;    
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
        HttpSession session = request.getSession();
        switch(request.getServletPath()){
            case "/readCustomer":                
                short ID = Short.parseShort(request.getParameter("customerId"));
                session.setAttribute("cust", svc.findCustomer(ID));                
                request.setAttribute("customer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/readCustomer.jsp").forward(request, response);
                break;
            case "/insertCustomerAdds":
                String iAddress = new String();
                String iDistrict = new String();
                String iPhone = new String();
                String iFirstName = new String();
                String iLastName = new String();
                String iemail = new String();
                iFirstName = request.getParameter("firstName");
                iLastName = request.getParameter("lastName");
                iemail = request.getParameter("email");
                iAddress = request.getParameter("address");
                iDistrict = request.getParameter("district");
                iPhone = request.getParameter("phone");
                Date dt = new Date();
                Timestamp ts = new Timestamp(dt.getTime());
                int test = svc.insertCustomerAdds(iAddress, iDistrict, iPhone);               
                request.setAttribute("insertCustomerAdds", test);
                int test2 = svc.insertCustomer(iFirstName, iLastName, iemail, ts);
                request.setAttribute("insertCustomer", test2);
                request.setAttribute("customer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/readCustomer.jsp").forward(request, response);                break;
            case "/updateCustomer":
                String uFirstName = new String();
                String uLastName = new String();
                String uAddress = new String();
                String uDistrict = new String();
                String uemail = new String();
                String uPhone = new String();
                uFirstName = request.getParameter("firstName");
                uLastName = request.getParameter("lastName");
                uAddress = request.getParameter("address");
                uDistrict = request.getParameter("district");
                uemail = request.getParameter("email");
                uPhone = request.getParameter("phone");
                request.setAttribute("updateCustomer", svc.findCustomer());
                short uCustomerIdU = Short.parseShort(request.getParameter("customerId"));
                request.setAttribute("updateCustomer2", svc.updCustomer(uCustomerIdU, uFirstName, uLastName,uAddress,uDistrict,uemail,uPhone));
                request.setAttribute("customer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/readCustomer.jsp").forward(request, response);
                break;
            case "/deleteCustomer":
                request.setAttribute("deleteCustomer", svc.findCustomer());
                short customerId = Short.parseShort(request.getParameter("customerId"));
                request.setAttribute("deleteactor",svc.remCustomer(customerId));
                request.setAttribute("customer", svc.findCustomer());
                request.getRequestDispatcher("/WEB-INF/pages/actor/readCustomer.jsp").forward(request, response);
                break;        
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
