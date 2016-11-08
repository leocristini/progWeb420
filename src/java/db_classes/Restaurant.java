/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_classes;

import java.io.Serializable;

/**
 *
 * @author leonardo
 */
public class Restaurant implements Serializable{
    
    private int id;
    private int priority;
    private String name;
    private String description;
    private String webSiteUrl;
    private String cousineType;
    private String openingHours;
    private double price;
    private String photoPath;
    
    /**
     * @return the id
     */
    public int getIt(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    /**
     * @return the priority
     */
    public int getPriority(){
        return priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the webSiteUrl
     */
    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    /**
     * @param webSiteUrl the webSiteUrl to set
     */
    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    /**
     * @return the cousineType
     */
    public String getCousineType() {
        return cousineType;
    }

    /**
     * @param cousineType the cousineType to set
     */
    public void setCousineType(String cousineType) {
        this.cousineType = cousineType;
    }

    /**
     * @return the openingHours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * @param openingHours the openingHours to set
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * @return the photo_path
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * @param photoPath the price to set
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    
    
}
