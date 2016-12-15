/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
public class LogoutServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session.getAttribute("user") != null) {

            session.removeAttribute("user");

            session.invalidate();

        }

        req.setAttribute("message", "Logout effettuato con successo");

        

        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");

        rd.forward(req, resp);

    }
}