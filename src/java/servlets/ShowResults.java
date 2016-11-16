/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db_classes.DBManager;
import db_classes.Restaurant;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leonardo
 */
public class ShowResults extends HttpServlet {

    private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //setto il printwriter per stampare fuori la pagina
        PrintWriter out = response.getWriter();
        //dico che la pagina è text html
        response.setContentType("text/html");
        //prendo il campo cercato
        String target = request.getParameter("search_bar");
        ArrayList<Restaurant> searched_res = new ArrayList<>();
        
        try {
            out.println("<html><head>");
            searched_res = manager.getRestaurantsByName(target);
            request.getRequestDispatcher("header.jsp").include(request, response);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/media/js/dataTables.js");
            
            //qua c'è la tabella centrata con l' elenco dei risto
            out.println("<div class=\"col-md-2\"></div><div class=\"col-md-6\">"
                    + "<form action=\"Profile\" method=\"POST\">"
                    + "<table id=\"res_tab\">");
            if(searched_res.size()!= 0){
                
                
                
                for(int i = 0; i<searched_res.size();i++){ 
                        HttpSession session = request.getSession(false);
                        String newName = searched_res.get(i).getName();
                        String tmp = new String();
                        tmp = newName.replaceAll("\\s+","_");
                        session.setAttribute("name", searched_res.get(i).getName());
                        out.println("<tr>");
                        out.println("<ul><h1><a href=\"Profile?name="+tmp+"\" id=\"res_name\">"+searched_res.get(i).getName()+" </a></h1></ul>");
                        out.println("<ul> "+searched_res.get(i).getDescription()+" </ul>");
                        out.println("<ul> "+searched_res.get(i).getCousineType()+" </ul>");
                        out.println("<ul><a href=\""+searched_res.get(i).getWebSiteUrl()+"\">"+searched_res.get(i).getWebSiteUrl()+"</a> </ul>");
                        out.println("</tr>");
                }                
                
            }
            
            out.println("</table></form></div><div class=\"col-md-2\"></div>"
                    +"<script src=\"media/js/jquery-3.1.1.min.js\"></script>"
                    +"<script src=\"media/js/scripts.js\"></script>"
                    + "</body></html>");
        } catch (SQLException ex) {
            Logger.getLogger(ShowResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
