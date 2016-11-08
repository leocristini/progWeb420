/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db_classes.DBManager;
import db_classes.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gianma
 */
public class LoginServlet extends HttpServlet {

    private DBManager manager;
    
    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
    }
    
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //controllo nel DB se esiste un utente con lo stesso username + password
        User user = null;
        try {
            //metodo della classe DBManager per effettuare authentication
            user = manager.authenticate(username, password);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
        // se non esiste, ridirigo verso pagina di login con messaggio di errore
        if (user == null) {
            
            // metto il messaggio di errore come attributo di Request, così nel JSP si vede il messaggio
            req.setAttribute("message", "Username e/o password non esistente/i!");
            RequestDispatcher rd = req.getRequestDispatcher("login_page.jsp");
            rd.forward(req, resp);

        } else {

            //imposto l'utente connesso come attributo di sessione
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);

            //mando un redirect alla home page
            resp.sendRedirect(req.getContextPath()+ "/index.jsp");
        }
    }
}