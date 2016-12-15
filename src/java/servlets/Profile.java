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
public class Profile extends HttpServlet {
    
    
    private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
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
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //prendo il nome del ristorante passato come parametro
        String tmp = new String();
        tmp = request.getParameter("name");
        String restName = new String();
        restName = tmp.replaceAll("_", " ");
                
        out.println("<html><head><title>"+restName+"</title>");
        request.getRequestDispatcher("header.jsp").include(request, response);
        
        Restaurant res_tmp = new Restaurant();
        res_tmp = manager.getRestaurant(restName);
        out.println("<div class=\"jumbotron\" id=\"jumbo-res\" background=\""+ res_tmp.getPhotoPath() +"\">");
        System.out.println("nome: "+res_tmp.getName());
        out.println("<h1 id=\"profile-res-title\">"+res_tmp.getName()+"</h1>");
        if(request.getSession().getAttribute("user")!=null){
            //puo settare il voto con le stelline solo se loggato
            out.println("<div name=\"rating\" class=\"col-md-offset-8 acidjs-rating-stars\">"+
                        "<form>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-0\" value=\"5\" /><label for=\"group-2-0\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-1\" value=\"4\" /><label for=\"group-2-1\"></label>"+
                            "<input type=\"radio\" checked=\"checked\" name=\"group-2\" id=\"group-2-2\" value=\"3\" /><label for=\"group-2-2\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-3\" value=\"2\" /><label for=\"group-2-3\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-4\"  value=\"1\" /><label for=\"group-2-4\"></label>"+
                        "</form></div>");
            }else{
                //vuol dire che non è loggato e non puo settare le stelline
                out.println("<div name=\"rating\" class=\"col-md-offset-8 acidjs-rating-stars acidjs-rating-disabled\">"+
                        "<form>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-0\" value=\"5\" /><label for=\"group-2-0\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-1\" value=\"4\" /><label for=\"group-2-1\"></label>"+
                            "<input type=\"radio\"  name=\"group-2\" id=\"group-2-2\" value=\"3\" /><label for=\"group-2-2\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-3\" value=\"2\" /><label for=\"group-2-3\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-4\"  value=\"1\" /><label for=\"group-2-4\"></label>"+
                        "</form></div>");
            }
        //provo a stampare il punteggio
        
        out.println("</div>");
        
        
        
        //qui ci metto descrizione ristorante + stelline
        out.println("<div class=col-md-2></div>");
        
        out.println("<div class=col-md-6>");
        
        //qua descrizione
        out.println(res_tmp.getDescription()
        +"<br><h3>Oradi di apertura:</h3> "+res_tmp.getOpeningHours()
        +"<br><h3>Prices:"//prendo la fascia di prezzo
        +"<br><h3>Where are we:<br></h3>");
        //qui andrebbe mappa
           
        
        out.println("</div><div class=col-md-2></div>");
        out.println("<div class=\"row\"><div class=\"col-md-6 col-md-offset-2\">");
        if(request.getSession().getAttribute("user")!=null){
            //se è loggato allora ha l' opportunità di commentare e mettere le stelline
            
            //qua invece è il commento vero e proprio
            out.println("<form action=\"AddComment\" type=\"post\">"
                    + "<label for=\"comment\">Add a review for this restaurant</label><br>"
                    //le stelline
                    +"<div name=\"rating\" class=\" acidjs-rating-stars\">"+
                        ""+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-0\" value=\"5\" /><label for=\"group-2-0\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-1\" value=\"4\" /><label for=\"group-2-1\"></label>"+
                            "<input type=\"radio\" checked=\"checked\" name=\"group-2\" id=\"group-2-2\" value=\"3\" /><label for=\"group-2-2\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-3\" value=\"2\" /><label for=\"group-2-3\"></label>"+
                            "<input type=\"radio\" name=\"group-2\" id=\"group-2-4\"  value=\"1\" /><label for=\"group-2-4\"></label>"+
                        "</div>"
                    
                    + "Title: <input type=\"text\" id=\"title\" name=\"title\"/><br>"
                    + "<textarea class=\"form-control\" rows=\"4\" cols=\"50\" type=\"text\" name=\"description\"></textarea>"
                    + "<input type=\"file\" name=\"image\" accept=\"image/*\">"
                    + "<button type=\"submit\">Add review</button>");
            out.println("</form>");
            HttpSession session = request.getSession(true);
            session.setAttribute("RestName", restName);
        }
        else{
        
            out.println("<label for=\"comment\">Add a comment for this restaurant</label><br>"
                    + "<a href=\"login_page.jsp\">You must be logged in to add a review</a>"
                    + "<br>");
        
        }
        
        //devo prendere una lista di tutte le review per il dato ristorante
        
        
        
        out.println("</div><script src=\"media/js/jquery-3.1.1.min.js\"></script>\n" +
"        <script src=\"media/js/scripts.js\"></script>");
        
        out.println("</body></html>");
        
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
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
