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
    private int global_value;
    private String name;
    private String address;
    private int civicNumber;
    private String city;
    private String description;
    private String webSiteUrl;
    private String[] cuisineTypes;
    private WeekSchedule week;
    private int price;
    private String photoPath;
    private int id_owner;
    
    /**
     * @return the id
     */
    public int getIt(){
        return getId();
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the civicNumber
     */
    public int getCivicNumber() {
        return civicNumber;
    }

    /**
     * @param civicNumber the civicNumber to set
     */
    public void setCivicNumber(int civicNumber) {
        this.civicNumber = civicNumber;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the cuisineTypes
     */
    public String[] getCuisineTypes() {
        return cuisineTypes;
    }

    /**
     * @param cuisineTypes the cuisineTypes to set
     */
    public void setCuisineTypes(String[] cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    /**
     * @return the week
     */
    public WeekSchedule getWeek() {
        return week;
    }

    /**
     * @param week the week to set
     */
    public void setWeek(WeekSchedule week) {
        this.week = week;
    }

    /**
     * @return the global_value
     */
    public int getGlobal_value() {
        return global_value;
    }

    /**
     * @param global_value the global_value to set
     */
    public void setGlobal_value(int global_value) {
        this.global_value = global_value;
    }

    /**
     * @return the id_owner
     */
    public int getId_owner() {
        return id_owner;
    }

    /**
     * @param id_owner the id_owner to set
     */
    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }
    
}
