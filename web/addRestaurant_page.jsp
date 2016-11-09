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
    <div class="col-md-8">
        <div class="container-fluid">
            <form>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="restaurant_name">Restaurant name:</label>
                            <input type="text" id="restaurant_name" class="form-control" placeholder="Name">
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="cuisine_type">Cuisine type:</label><br>
                            <div class="col-md-4">
                                <input type="checkbox" id="cuisine_type" name="italiana" value="Italiana">Italiana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="pizzeria" value="Pizzeria">Pizzeria
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cinese" value="Cinese">Cinese
                                <br>
                                <input type="checkbox" id="cuisine_type" name="messicana" value="Messicana">Messicana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="indiana" value="Indiana">Indiana
                                <br>
                            </div>
                            <div class="col-md-4">
                                <input type="checkbox" id="cuisine_type" name="giappo" value="Giapponese">Giapponese
                                <br>
                                <input type="checkbox" id="cuisine_type" name="thai" value="Thailandese">Thailandese
                                <br>
                                <input type="checkbox" id="cuisine_type" name="nordica" value="Nordica">Nordica
                                <br>
                                <input type="checkbox" id="cuisine_type" name="selvaggia" value="Selvaggia">Selvaggia
                                <br>
                                <input type="checkbox" id="cuisine_type" name="panineria" value="Panineria">Panineria
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="col-md-2"></div>
    </body>
</html>
