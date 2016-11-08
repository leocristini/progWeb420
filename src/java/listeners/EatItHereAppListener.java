/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import db_classes.DBManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author gianma
 */
@WebListener()
public class EatItHereAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String dburl = sce.getServletContext().getInitParameter("dburl");
        String dbuser = sce.getServletContext().getInitParameter("dbuser");
        String dbpassword = sce.getServletContext().getInitParameter("dbpassword");
        try{
            DBManager manager = new DBManager(dburl, dbuser, dbpassword);
            sce.getServletContext().setAttribute("dbmanager", manager);
        } catch (SQLException ex){
            Logger.getLogger(getClass().getName()).severe(ex.toString());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.shutdown();
    }
}