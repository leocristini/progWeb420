/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db_classes.DBManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import db_classes.WeekSchedule;
import java.io.File;
import java.sql.Time;
import java.util.Enumeration;

/**
 *
 * @author gianma
 */
public class AddRestaurant extends HttpServlet {
    
    private DBManager manager;
    private String dirName;
    
    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        // inizializza il DBManager dagli attributi di Application
        this.manager = (DBManager)super.getServletContext().getAttribute("dbmanager");
        
        //reading the upload directory from web.xml parameters
        this.dirName = getInitParameter("uploadDir");
        if (dirName == null){
            throw new ServletException("Please provide uploadDir parameter");
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
                
        //File upload and week schedule
        try{
            MultipartRequest multi = new MultipartRequest(request, dirName, 10*1024*1024,
                    "ISO-8859-1", new DefaultFileRenamePolicy());
            
            WeekSchedule week = new WeekSchedule();
            
            Enumeration params = multi.getParameterNames();
            while(params.hasMoreElements()){
                String name = (String)params.nextElement();
                String[] value = multi.getParameterValues(name);
                
                //Getting restaurant name
                if(name.equals("res_name")){
                    System.out.println("Name: "+multi.getParameter(name));
                }
                
                //Getting restaurant address
                if(name.equals("res_addr")){
                    System.out.println("Address: "+multi.getParameter(name));
                }
                
                //Getting civic number
                if(name.equals("res_civic")){
                    System.out.println("Civic number: "+multi.getParameter(name));
                }
                
                //Getting restaurant city
                if(name.equals("res_city")){
                    System.out.println("City: "+multi.getParameter(name));
                }
                
                //Getting restaurant price range
                if(name.equals("price")){
                    System.out.println("Price range: "+multi.getParameter(name));
                }
                
                //Getting restaurant URL
                if(name.equals("web_url")){
                    System.out.println("URL: "+multi.getParameter(name));
                }
                
                //Getting restaurant description
                if(name.equals("descrpt")){
                    System.out.println("Description: "+multi.getParameter(name));
                }
                
                //Getting cuisine types
                if(name.equals("cuisine_type")){
                    System.out.println("Cuisine types: ");
                    for(String s: value){
                        System.out.print(s+" ");
                    }
                }
                
                //Getting week schedule
                if(name.equals("days")){
                    for(String s: value){
                        if(s.equals("Monday")){
                            week.setMonday(true);
                            int monday_l_o_h = Integer.parseInt(multi.getParameter("monday_l_o_h"));
                            int monday_l_o_m = Integer.parseInt(multi.getParameter("monday_l_o_m"));
                            int monday_l_c_h = Integer.parseInt(multi.getParameter("monday_l_c_h"));
                            int monday_l_c_m = Integer.parseInt(multi.getParameter("monday_l_c_m"));

                            Time lunch_op = new Time(monday_l_o_h, monday_l_o_m, 00);
                            Time lunch_cl = new Time(monday_l_c_h, monday_l_c_m, 00);
                            week.setMonday_l_op(lunch_op);
                            week.setMonday_l_cl(lunch_cl);

                            int monday_d_o_h = Integer.parseInt(multi.getParameter("monday_d_o_h"));
                            int monday_d_o_m = Integer.parseInt(multi.getParameter("monday_d_o_m"));
                            int monday_d_c_h = Integer.parseInt(multi.getParameter("monday_d_c_h"));
                            int monday_d_c_m = Integer.parseInt(multi.getParameter("monday_d_c_m"));

                            Time dinner_op = new Time(monday_d_o_h, monday_d_o_m, 00);
                            Time dinner_cl = new Time(monday_d_c_h, monday_d_c_m, 00);
                            week.setMonday_d_op(dinner_op);
                            week.setMonday_d_cl(dinner_cl);

                            System.out.println("Monday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Monday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Tuesday")){
                            week.setTuesday(true);
                            int tuesday_l_o_h = Integer.parseInt(multi.getParameter("tuesday_l_o_h"));
                            int tuesday_l_o_m = Integer.parseInt(multi.getParameter("tuesday_l_o_m"));
                            int tuesday_l_c_h = Integer.parseInt(multi.getParameter("tuesday_l_c_h"));
                            int tuesday_l_c_m = Integer.parseInt(multi.getParameter("tuesday_l_c_m"));

                            Time lunch_op = new Time(tuesday_l_o_h, tuesday_l_o_m, 00);
                            Time lunch_cl = new Time(tuesday_l_c_h, tuesday_l_c_m, 00);
                            week.setTuesday_l_op(lunch_op);
                            week.setTuesday_l_cl(lunch_cl);

                            int tuesday_d_o_h = Integer.parseInt(multi.getParameter("tuesday_d_o_h"));
                            int tuesday_d_o_m = Integer.parseInt(multi.getParameter("tuesday_d_o_m"));
                            int tuesday_d_c_h = Integer.parseInt(multi.getParameter("tuesday_d_c_h"));
                            int tuesday_d_c_m = Integer.parseInt(multi.getParameter("tuesday_d_c_m"));

                            Time dinner_op = new Time(tuesday_d_o_h, tuesday_d_o_m, 00);
                            Time dinner_cl = new Time(tuesday_d_c_h, tuesday_d_c_m, 00);
                            week.setTuesday_d_op(dinner_op);
                            week.setTuesday_d_cl(dinner_cl);

                            System.out.println("Tuesday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Tuesday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Wednesday")){
                            week.setWednesday(true);
                            int wednesday_l_o_h = Integer.parseInt(multi.getParameter("wednesday_l_o_h"));
                            int wednesday_l_o_m = Integer.parseInt(multi.getParameter("wednesday_l_o_m"));
                            int wednesday_l_c_h = Integer.parseInt(multi.getParameter("wednesday_l_c_h"));
                            int wednesday_l_c_m = Integer.parseInt(multi.getParameter("wednesday_l_c_m"));

                            Time lunch_op = new Time(wednesday_l_o_h, wednesday_l_o_m, 00);
                            Time lunch_cl = new Time(wednesday_l_c_h, wednesday_l_c_m, 00);
                            week.setWednesday_l_op(lunch_op);
                            week.setWednesday_l_cl(lunch_cl);

                            int wednesday_d_o_h = Integer.parseInt(multi.getParameter("wednesday_d_o_h"));
                            int wednesday_d_o_m = Integer.parseInt(multi.getParameter("wednesday_d_o_m"));
                            int wednesday_d_c_h = Integer.parseInt(multi.getParameter("wednesday_d_c_h"));
                            int wednesday_d_c_m = Integer.parseInt(multi.getParameter("wednesday_d_c_m"));

                            Time dinner_op = new Time(wednesday_d_o_h, wednesday_d_o_m, 00);
                            Time dinner_cl = new Time(wednesday_d_c_h, wednesday_d_c_m, 00);
                            week.setWednesday_d_op(dinner_op);
                            week.setWednesday_d_cl(dinner_cl);

                            System.out.println("Wednesday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Wednesday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Thursday")){
                            week.setThursday(true);
                            int thursday_l_o_h = Integer.parseInt(multi.getParameter("thursday_l_o_h"));
                            int thursday_l_o_m = Integer.parseInt(multi.getParameter("thursday_l_o_m"));
                            int thursday_l_c_h = Integer.parseInt(multi.getParameter("thursday_l_c_h"));
                            int thursday_l_c_m = Integer.parseInt(multi.getParameter("thursday_l_c_m"));

                            Time lunch_op = new Time(thursday_l_o_h, thursday_l_o_m, 00);
                            Time lunch_cl = new Time(thursday_l_c_h, thursday_l_c_m, 00);
                            week.setThursday_l_op(lunch_op);
                            week.setThursday_l_cl(lunch_cl);

                            int thursday_d_o_h = Integer.parseInt(multi.getParameter("thursday_d_o_h"));
                            int thursday_d_o_m = Integer.parseInt(multi.getParameter("thursday_d_o_m"));
                            int thursday_d_c_h = Integer.parseInt(multi.getParameter("thursday_d_c_h"));
                            int thursday_d_c_m = Integer.parseInt(multi.getParameter("thursday_d_c_m"));

                            Time dinner_op = new Time(thursday_d_o_h, thursday_d_o_m, 00);
                            Time dinner_cl = new Time(thursday_d_c_h, thursday_d_c_m, 00);
                            week.setThursday_d_op(dinner_op);
                            week.setThursday_d_cl(dinner_cl);

                            System.out.println("Thursday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Thursday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Friday")){
                            week.setFriday(true);

                            int friday_l_o_h = Integer.parseInt(multi.getParameter("friday_l_o_h"));
                            int friday_l_o_m = Integer.parseInt(multi.getParameter("friday_l_o_m"));
                            int friday_l_c_h = Integer.parseInt(multi.getParameter("friday_l_c_h"));
                            int friday_l_c_m = Integer.parseInt(multi.getParameter("friday_l_c_m"));

                            Time lunch_op = new Time(friday_l_o_h, friday_l_o_m, 00);
                            Time lunch_cl = new Time(friday_l_c_h, friday_l_c_m, 00);
                            week.setFriday_l_op(lunch_op);
                            week.setFriday_l_cl(lunch_cl);

                            int friday_d_o_h = Integer.parseInt(multi.getParameter("friday_d_o_h"));
                            int friday_d_o_m = Integer.parseInt(multi.getParameter("friday_d_o_m"));
                            int friday_d_c_h = Integer.parseInt(multi.getParameter("friday_d_c_h"));
                            int friday_d_c_m = Integer.parseInt(multi.getParameter("friday_d_c_m"));

                            Time dinner_op = new Time(friday_d_o_h, friday_d_o_m, 00);
                            Time dinner_cl = new Time(friday_d_c_h, friday_d_c_m, 00);
                            week.setFriday_d_op(dinner_op);
                            week.setFriday_d_cl(dinner_cl);

                            System.out.println("Friday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Friday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Saturday")){
                            week.setSaturday(true);

                            int saturday_l_o_h = Integer.parseInt(multi.getParameter("saturday_l_o_h"));
                            int saturday_l_o_m = Integer.parseInt(multi.getParameter("saturday_l_o_m"));
                            int saturday_l_c_h = Integer.parseInt(multi.getParameter("saturday_l_c_h"));
                            int saturday_l_c_m = Integer.parseInt(multi.getParameter("saturday_l_c_m"));

                            Time lunch_op = new Time(saturday_l_o_h, saturday_l_o_m, 00);
                            Time lunch_cl = new Time(saturday_l_c_h, saturday_l_c_m, 00);
                            week.setSaturday_l_op(lunch_op);
                            week.setSaturday_l_cl(lunch_cl);

                            int saturday_d_o_h = Integer.parseInt(multi.getParameter("saturday_d_o_h"));
                            int saturday_d_o_m = Integer.parseInt(multi.getParameter("saturday_d_o_m"));
                            int saturday_d_c_h = Integer.parseInt(multi.getParameter("saturday_d_c_h"));
                            int saturday_d_c_m = Integer.parseInt(multi.getParameter("saturday_d_c_m"));

                            Time dinner_op = new Time(saturday_d_o_h, saturday_d_o_m, 00);
                            Time dinner_cl = new Time(saturday_d_c_h, saturday_d_c_m, 00);
                            week.setSaturday_d_op(dinner_op);
                            week.setSaturday_d_cl(dinner_cl);

                            System.out.println("Saturday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Saturday: "+dinner_op+" to "+dinner_cl);
                        }
                        if(s.equals("Sunday")){
                            week.setSunday(true);

                            int sunday_l_o_h = Integer.parseInt(multi.getParameter("sunday_l_o_h"));
                            int sunday_l_o_m = Integer.parseInt(multi.getParameter("sunday_l_o_m"));
                            int sunday_l_c_h = Integer.parseInt(multi.getParameter("sunday_l_c_h"));
                            int sunday_l_c_m = Integer.parseInt(multi.getParameter("sunday_l_c_m"));

                            Time lunch_op = new Time(sunday_l_o_h, sunday_l_o_m, 00);
                            Time lunch_cl = new Time(sunday_l_c_h, sunday_l_c_m, 00);
                            week.setSunday_l_op(lunch_op);
                            week.setSunday_l_cl(lunch_cl);

                            int sunday_d_o_h = Integer.parseInt(multi.getParameter("sunday_d_o_h"));
                            int sunday_d_o_m = Integer.parseInt(multi.getParameter("sunday_d_o_m"));
                            int sunday_d_c_h = Integer.parseInt(multi.getParameter("sunday_d_c_h"));
                            int sunday_d_c_m = Integer.parseInt(multi.getParameter("sunday_d_c_m"));

                            Time dinner_op = new Time(sunday_d_o_h, sunday_d_o_m, 00);
                            Time dinner_cl = new Time(sunday_d_c_h, sunday_d_c_m, 00);
                            week.setSunday_d_op(dinner_op);
                            week.setSunday_d_cl(dinner_cl);

                            System.out.println("Sunday: "+lunch_op+" to "+lunch_cl);
                            System.out.println("Sunday: "+dinner_op+" to "+dinner_cl);
                        }
                    }
                }
            }
            
            
            
            Enumeration files = multi.getFileNames();
            while(files.hasMoreElements()){
                String name = (String)files.nextElement();
                String filename = multi.getFilesystemName(name);
                String originalFilename = multi.getOriginalFileName(name);
                String type = multi.getContentType(name);
                File f = multi.getFile(name);
                if(f != null){
                    System.out.println("f.toString(): "+f.toString());
                    System.out.println("f.getName(): "+f.getName());
                    System.out.println("f.exists(): "+f.exists());
                    System.out.println("f.lenght(): "+f.length());
                }
            }
            
            
        }catch(IOException ex){
            this.getServletContext().log(ex, "Error reading or saving file");
        }
        
    }

}
