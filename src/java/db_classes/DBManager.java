/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_classes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import info.debatty.java.stringsimilarity.*;


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
                    user.setEmail(rs.getString("email"));
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
                tmp.setCousineType(resu.getString("cuisines.id"));
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
                    if(resu.next()){
                        tmp.setCousineType(resu.getString(1));
                    }
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
                if(resu.next()){
                    tmp.setCousineType(resu.getString(1));
                }
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
    
}
