/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_classes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import info.debatty.java.stringsimilarity.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author gianma
 */
public class DBManager implements Serializable {
    
    private transient Connection con;
    
    public DBManager(String dburl, String dbuser, String dbpassword) throws SQLException{
        try{
            Class.forName("org.postgresql.Driver", true, getClass().getClassLoader());
        } catch(Exception e){
            throw new RuntimeException(e.toString(), e);
        }
        
        Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);
        this.con = con;
    }
    
    public static void shutdown(){
        try{
            DriverManager.getConnection("jdbc:postgresql:;shutdown=true");
        } catch (SQLException ex){
            Logger.getLogger(DBManager.class.getName()).info(ex.getMessage());
        }
    }
    
    /**
    *Autentica un utente in base ad un nome utente e una password
    *@param username: il nome utente
    *@param password: la password
    *@return: null se l'utente non è autenticato, un oggetto User se l'utente esiste ed è autenticato
     * @throws java.sql.SQLException
    */
    
    public User authenticate(String username, String password) throws SQLException{
        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
        
        try{
            stm.setString(1, username);
            stm.setString(2, password);
            
            ResultSet rs = stm.executeQuery();
            
            try{
                if (rs.next()){
                    User user = new User();
                    user.setUsername(username);
                    user.setId(rs.getInt("id"));
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setUsertype(rs.getString("user_type"));
                    
                    return user;
                    
                }else{
                    return null;
                }
            } finally{
                //Ricordarsi SEMPRE di chiudere i ResultSet in un blocco finally
                rs.close();
            }
        } finally{
            //Ricordarsi SEMPRE di chiudere i PreparedStatement in un blocco finally
            stm.close();
        }
    }
    /**
     * 
     * @param firstname dati registrazione
     * @param lastname
     * @param username
     * @param password
     * @return true se registrazione andata a buon fine, false altrimenti
     * @throws SQLException 
     */
    public boolean register(String firstname, String lastname, String username, String password) throws SQLException{
        
        
        int next_id = 0;
        String query1 = "SELECT MAX(id) FROM Users";
        PreparedStatement ps1 = con.prepareStatement(query1);
        ResultSet rs1 = ps1.executeQuery();
        while(rs1.next()){
            next_id = rs1.getInt(1) + 1;
        }
        
        String query = "INSERT INTO Users VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, next_id);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        ps.setString(4, username);
        ps.setString(5, "U");
        ps.setString(6, password);
        
        try{
            ps.executeUpdate();
        }finally{
            ps.close();
        }
        return true;
    }
    /**
     * 
     * @param username nome da verificare se già presente
     * @return User se presente, null altrimenti
     * @throws SQLException 
     */
    public User existingUser(String username) throws SQLException{
        
        String query = "SELECT * FROM Users WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        
        ResultSet rs = ps.executeQuery();
        
        try {
            if (rs.next()){
                User user = new User();
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                return user;
            }
        }finally{
            rs.close();
            ps.close();
        }
        
        return null;
        
        
    }
    
    public boolean badPassword(String pw1, String pw2){
        
        if(!pw1.equals(pw2)){
            return true;
        }
        
        return false;  
    }
    /**
     * @return tutti i ristorant (ma solo id, nome e descrizione)
     */
    public ArrayList<Restaurant> getRestaurants() throws SQLException{
        
        ArrayList<Restaurant> results = new ArrayList<Restaurant>();
        
        String query = "SELECT * FROM restaurants";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        Restaurant tmp = new Restaurant();
        
        try{
            if(rs.next()){
                
                tmp.setId(rs.getInt("id"));
                tmp.setName(rs.getString("name"));
                tmp.setDescription(rs.getString("description"));
                //qua la query per prendere il tipo di cucina
                query = "SELECT cuisines.id "
                        + "FROM (restaurants_cuisine INNER JOIN restaurants ON restaurants_cuisine.id_restaurants = restaurants.id)"
                        + "INNER JOIN cuisines ON restaurant_cuisine.id_cuisine = cuisines.id WHERE restaurants.name = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, tmp.getName());
                ResultSet resu = pst.executeQuery();
                System.out.println(resu.getString("cuisines.id"));
                //tmp.setCuisineTypes(resu.getString("cuisines.id"));
                //qua la query per prendere il sito web
                //tmp.setWebSiteUrl(query);
                //altra query per prendere gli orari d' apertura
                //tmp.setOpeningHours(query);
                results.add(tmp);
                
            }
        }finally{
            rs.close();
            ps.close();
        }
        
        return results;
        
    }
    /**
     * @param search il ristorante da cercare
     * @return a list of restaurants col norme pertinente alla ricerca, massimo 2 errori
     * @throws java.sql.SQLException
     */
    public ArrayList<Restaurant> getRestaurantsByName(String search) throws SQLException{
        
        ArrayList<Restaurant> results = new ArrayList<>();
        //questo mi serve per calcolare gli lcs delle parole
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        
        String query = "SELECT * FROM restaurants";
        PreparedStatement ps = con.prepareStatement(query);
        //ps.setString(1, search+"%");
        ResultSet rs = ps.executeQuery();
        Restaurant tmp = new Restaurant();
        
        try{
            int i = 0;
            while(rs.next()){
                
                System.out.println(""+"search: "+search+" rs.getString: "+rs.getString("name")+" distanza: "+lcs.distance(search, rs.getString("name")));
                int distanza = (int) (lcs.distance(search, rs.getString("name"))/2);
                if(distanza<=2){
                    //setto l' id
                    tmp.setId(rs.getInt("id"));
                    //setto il nome
                    tmp.setName(rs.getString("name"));
                    //setto la descrizione
                    tmp.setDescription(rs.getString("description"));
                    //setto il website
                    tmp.setWebSiteUrl(rs.getString("web_site_url"));
                    //qua la query per prendere il tipo di cucina
                    query = "SELECT c.name "
                            + "FROM (restaurant_cuisine AS rc INNER JOIN restaurants AS r ON rc.id_restaurant = r.id)"
                            + "INNER JOIN cuisines AS c ON rc.id_cuisine = c.id WHERE r.name = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, tmp.getName());
                    ResultSet resu = pst.executeQuery();
                    //if(resu.next()){
                    //    tmp.setCuisineTypes(resu.getString(1));
                    //}
                    resu.close();
                    pst.close(); 
                    //qua la query per prendere foto sito web
                    query = "SELECT path FROM photos WHERE id_restaurant = ?";
                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setInt(1, rs.getInt("id"));
                    ResultSet rst = prs.executeQuery();
                    while(rst.next()){
                        tmp.setPhotoPath(rst.getString(1));
                    }
                    prs.close();
                    rst.close();                   
                    //
                    //altra query per prendere gli orari d' apertura
                    results.add(tmp);
                    
                    
                }
                i++;
                System.out.println(results.size()+" $$ i: "+i);
                
                
            }
        }finally{
            rs.close();
            ps.close();
        }
        
        return results;
        
    }
    
    /**
     * @param search il nome del ristorante da cercare
     * @return Un singolo ristorante che corrisponde al nome cercato
     * @throws java.sql.SQLException
     */
    public Restaurant getRestaurant(String search) throws SQLException{
        
        Restaurant tmp = new Restaurant();
        
        String query = "SELECT * FROM restaurants WHERE name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, search);
        ResultSet rs = ps.executeQuery();
                
        try{
            if(rs.next()){
                
                tmp.setId(rs.getInt("id"));
                    //setto il nome
                tmp.setName(rs.getString("name"));
                //setto la descrizione
                tmp.setDescription(rs.getString("description"));
                //setto il website
                tmp.setWebSiteUrl(rs.getString("web_site_url"));
                //qua la query per prendere il tipo di cucina
                query = "SELECT c.name "
                        + "FROM (restaurant_cuisine AS rc INNER JOIN restaurants AS r ON rc.id_restaurant = r.id)"
                        + "INNER JOIN cuisines AS c ON rc.id_cuisine = c.id WHERE r.name = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, tmp.getName());
                ResultSet resu = pst.executeQuery();
                //if(resu.next()){
                //    tmp.setCuisineTypes(resu.getString(1));
                //}
                query = "SELECT path FROM photos WHERE id_restaurant = ?";
                pst = con.prepareCall(query);
                pst.setInt(1, rs.getInt("id"));
                resu = pst.executeQuery();
                if(resu.next()){
                    tmp.setPhotoPath(resu.getString(1));
                }
                resu.close();
                pst.close();  
                
            }
        }finally{
            rs.close();
            ps.close();
        }
        
        
        return tmp;
        
    }
    //chiamata quando si effettua un commento
    public void addReviewPerRestaurant(String user,String restaurant){
    }
    
    //aggiungi recensione
    public ArrayList<String> getReviewPerRestaurant(String restaurant){
        
        ArrayList<String> restaurantReviews = new ArrayList<>();
        
        
        
        return restaurantReviews;
        
    }
    
    /**
     *
     * @param restaurant that needs to be added to DB
     * @param creator
     * @param isOwner
     * @return
     */
    public boolean addRestaurant(Restaurant restaurant, int creator_id, boolean isOwner){
        
        int next_id = 0;
        
        try {
            //query to get the next free id for restaurant
            String query1 = "SELECT MAX(id) FROM Restaurants";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                next_id = rs1.getInt(1) + 1;
            }
            
            //query to add the restaurant to DB
            String query = "INSERT INTO Restaurants VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, next_id);
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getAddress());
            ps.setInt(4, restaurant.getCivicNumber());
            ps.setString(5, restaurant.getCity());
            ps.setString(6, restaurant.getDescription());
            ps.setString(7, restaurant.getWebSiteUrl());
            ps.setInt(8, 0);
            ps.setInt(9, restaurant.getPrice());
            if(isOwner){
                ps.setInt(10, creator_id);
            }else{
                ps.setInt(10, 0);
            }
            ps.setInt(11, creator_id);
            
            int update = ps.executeUpdate();
            
            //query to add cuisine types to a restaurant_id
            PreparedStatement psk = con.prepareStatement("INSERT INTO restaurant_cuisine VALUES (?,?)");
            for(String s : restaurant.getCuisineTypes()){
                switch (s){
                    case "Italiana":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 1);
                        psk.executeUpdate();
                        break;
                    case "Asiatica":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 2);
                        psk.executeUpdate();
                        break;
                    case "NordAmericana":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 3);
                        psk.executeUpdate();
                        break;
                    case "Africana":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 4);
                        psk.executeUpdate();
                        break;
                    case "Caraibica":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 5);
                        psk.executeUpdate();
                        break;
                    case "SudAmericana":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 6);
                        psk.executeUpdate();
                        break;
                    case "NordEuropea":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 7);
                        psk.executeUpdate();
                        break;
                    case "Mediterranea":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 8);
                        psk.executeUpdate();
                        break;
                    case "MedioOrientale":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 9);
                        psk.executeUpdate();
                        break;
                    case "Vegana":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 10);
                        psk.executeUpdate();
                        break;
                    case "FastFood":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 11);
                        psk.executeUpdate();
                        break;
                    case "Pizzeria":
                        psk.setInt(1, next_id);
                        psk.setInt(2, 12);
                        psk.executeUpdate();
                        break;
                }
            }
            
            //query to add hours_ranges
            PreparedStatement psw = con.prepareStatement("INSERT INTO opening_hours_restaurants VALUES (?,?,?,?,?,?)");
            WeekSchedule rest_week = restaurant.getWeek();
            if(rest_week.isMonday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 1);
                psw.setTime(3, rest_week.getMonday_l_op());
                psw.setTime(4, rest_week.getMonday_l_cl());
                psw.setTime(5, rest_week.getMonday_d_op());
                psw.setTime(6, rest_week.getMonday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isTuesday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 2);
                psw.setTime(3, rest_week.getTuesday_l_op());
                psw.setTime(4, rest_week.getTuesday_l_cl());
                psw.setTime(5, rest_week.getTuesday_d_op());
                psw.setTime(6, rest_week.getTuesday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isWednesday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 3);
                psw.setTime(3, rest_week.getWednesday_l_op());
                psw.setTime(4, rest_week.getWednesday_l_cl());
                psw.setTime(5, rest_week.getWednesday_d_op());
                psw.setTime(6, rest_week.getWednesday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isThursday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 4);
                psw.setTime(3, rest_week.getThursday_l_op());
                psw.setTime(4, rest_week.getThursday_l_cl());
                psw.setTime(5, rest_week.getThursday_d_op());
                psw.setTime(6, rest_week.getThursday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isFriday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 5);
                psw.setTime(3, rest_week.getFriday_l_op());
                psw.setTime(4, rest_week.getFriday_l_cl());
                psw.setTime(5, rest_week.getFriday_d_op());
                psw.setTime(6, rest_week.getFriday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isSaturday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 6);
                psw.setTime(3, rest_week.getSaturday_l_op());
                psw.setTime(4, rest_week.getSaturday_l_cl());
                psw.setTime(5, rest_week.getSaturday_d_op());
                psw.setTime(6, rest_week.getSaturday_d_cl());
                psw.executeUpdate();
            }
            if(rest_week.isSunday()){
                psw.setInt(1, next_id);
                psw.setInt(2, 7);
                psw.setTime(3, rest_week.getSunday_l_op());
                psw.setTime(4, rest_week.getSunday_l_cl());
                psw.setTime(5, rest_week.getSunday_d_op());
                psw.setTime(6, rest_week.getSunday_d_cl());
                psw.executeUpdate();
            }
            
            //query to get the next photo id
            int next_photo_id = 0;
            PreparedStatement psn = con.prepareStatement("SELECT MAX(id) FROM photos");
            ResultSet rsp = psn.executeQuery();
            while(rsp.next()){
                next_photo_id = rsp.getInt(1);
            }
            
            //query to insert photo
            PreparedStatement psp = con.prepareStatement("INSERT INTO photos VALUES (?,?,?,?)");
            psp.setInt(1, next_photo_id);
            psp.setString(2, restaurant.getPhotoPath());
            psp.setInt(3, next_id);
            psp.setInt(4, creator_id);
            
            if(update == 0){
                return false;
            }
            
            ps1.close();
            rs1.close();
            ps.close();
            psk.close();
            psw.close();
            
            
            double [] coordinates = null;
            try {
                coordinates = getCoordinates(restaurant.getAddress(), restaurant.getCivicNumber(), restaurant.getCity());
            } catch (IOException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Lat: "+coordinates[0]+" Long: "+coordinates[1]);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return true;
    }
    
    /**
     *
     * @param address
     * @param civic
     * @param city
     * @return
     * @throws java.io.IOException
     */
    public double[] getCoordinates(String address, int civic, String city) throws IOException{
        String url1 = "http://maps.googleapis.com/maps/api/geocode/json";
        double [] coordinates = new double [2];
        String fulladdress = address+" "+civic+" "+city;
        
        
        
        return coordinates;
    }
    
}
