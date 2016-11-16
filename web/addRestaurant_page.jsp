<%-- 
    Document   : addRestaurant_page
    Created on : 9-nov-2016, 14.35.56
    Author     : gianma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%@include file="header.jsp" %>
        
    <div class="col-md-2"></div>
    <div class="col-md-10">
        <div class="container-fluid">
            <form>
                <div class="row">
                    <h3>Add a restaurant to our service!</h3>
                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="restaurant_name">Name:</label>
                            <input type="text" id="restaurant_name" class="form-control" placeholder="Name">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="restaurant_website">Website URL:</label>
                            <input type="text" id="restaurant_website" class="form-control" placeholder="URL">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="restaurant_address">Address:</label>
                            <input type="text" id="restaurant_address" class="form-control" placeholder="Address">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="restaurant_city">City:</label>
                            <input type="text" id="restaurant_city" class="form-control" placeholder="City">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="cuisine_type">Cuisine type:</label><br>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="italiana" value="Italiana">Italiana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="asiatica" value="Asiatica">Asiatica
                                <br>
                                <input type="checkbox" id="cuisine_type" name="nordamerica" value="NordAmericana">Nord Americana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="africana" value="Africana">Africana
                                <br>
                            </div>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="caraibica" value="Caraibica">Caraibica
                                <br>
                                <input type="checkbox" id="cuisine_type" name="sudamericana" value="SudAmericana">Sud Americana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="nordeuropea" value="NordEuropea">Nord Europea
                                <br>
                                <input type="checkbox" id="cuisine_type" name="mediterranea" value="Mediterranea">Mediterranea
                                <br>
                            </div>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="medioorientale" value="MedioOrientale">Medio Orientale
                                <br>
                                <input type="checkbox" id="cuisine_type" name="vegana" value="Vegana">Vegana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="fastfood" value="FastFood">Fast Food
                                <br>
                                <input type="checkbox" id="cuisine_type" name="pizzeria" value="Pizzeria">Pizzeria
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    
                </div>
            </form>
        </div>
    </div>
    <script src="media/js/jquery-3.1.1.min.js"></script>
    <script src="media/js/scripts.js"></script>
    </body>
</html>
