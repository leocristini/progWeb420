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
            <form enctype="multipart/form-data" method="POST" action="AddRestaurant">
                <div class="row">
                    <h3>Add a restaurant to our service!</h3>
                    <br>
                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="restaurant_name">Name:</label>
                            <input type="text" required="true" name="res_name" id="restaurant_name" class="form-control" placeholder="Name">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="restaurant_website">Website URL:</label>
                            <input type="text" required="true" name="web_url" id="restaurant_website" class="form-control" placeholder="URL">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="restaurant_address">Address:</label>
                            <input type="text" required="true" name="res_addr" id="restaurant_address" class="form-control" placeholder="Address">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="form-group">
                            <label for="civic_number">Civic number:</label>
                            <input type="number" required="true" name="res_civic" id="civic_number" class="form-control" placeholder="Number">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="restaurant_city">City:</label>
                            <input type="text" required="true" name="res_city" id="restaurant_city" class="form-control" placeholder="City">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="cuisine_type">Cuisine type(s):</label><br>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Italiana">Italiana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Asiatica">Asiatica
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="NordAmericana">Nord Americana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Africana">Africana
                                <br>
                            </div>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Caraibica">Caraibica
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="SudAmericana">Sud Americana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="NordEuropea">Nord Europea
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Mediterranea">Mediterranea
                                <br>
                            </div>
                            <div class="col-md-3 checkbox-inline">
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="MedioOrientale">Medio Orientale
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Vegana">Vegana
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="FastFood">Fast Food
                                <br>
                                <input type="checkbox" id="cuisine_type" name="cuisine_type" value="Pizzeria">Pizzeria
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-md-2">
                                    <label for="days">Open days:</label>
                                </div>
                                <div class="col-md-4">
                                    <label for="lunch_op">Lunch:</label>
                                </div>
                                <div class="col-md-4">
                                    <label for="lunch_cl">Dinner:</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Monday">Lunedì
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="monday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="monday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="monday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="monday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="monday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="monday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="monday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="monday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Tuesday">Martedì
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="tuesday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="tuesday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="tuesday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="tuesday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="tuesday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="tuesday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="tuesday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="tuesday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Wednesday">Mercoledì
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="wednesday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="wednesday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="wednesday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="wednesday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="wednesday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="wednesday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="wednesday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="wednesday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Thursday">Giovedì
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="thursday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="thursday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="thursday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="thursday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="thursday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="thursday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="thursday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="thursday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Friday">Venerdì
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="friday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="friday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="friday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="friday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="friday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="friday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="friday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="friday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Saturday">Sabato
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="saturday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="saturday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="saturday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="saturday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="saturday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="saturday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="saturday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="saturday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="col-md-2 checkbox-inline">
                                        <input type="checkbox" id="days" name="days" value="Sunday">Domenica
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="sunday_l_o_h" id="lunch_op_hr">
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="sunday_l_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="sunday_l_c_h" id="lunch_cl_hr">
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                    </select>
                                    <select name="sunday_l_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    Da:
                                    <select name="sunday_d_o_h" id="dinner_op_hr">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                    <select name="sunday_d_o_m" id="lunch_op_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    A:
                                    <select name="sunday_d_c_h" id="lunch_cl_hr">
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                    </select>
                                    <select name="sunday_d_c_m" id="lunch_cl_min">
                                        <option value="00">00</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-2">
                            <label for="price_range">Categoria prezzi:</label>
                            <select name="price" id="price_range">
                                <option>Alta</option>
                                <option>Media</option>
                                <option>Bassa</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="image_upload">Immagine:</label>
                            <input id="image_upload" required="true" name="rest_photo" type="file" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <br>
                            <div class="col-md-6 checkbox-inline">
                                <input type="checkbox" name="isOwner" value="true">I am the owner of this restaurant
                            </div>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-8">
                            <label for="descr_area">Descrizione:</label>
                            <textarea class="form-control" required="true" id="descr_area" name="descrpt" cols="60" rows="5">
                            </textarea>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-default">Submit</button>
                       </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <hr>
            <br>
        </div>
        <div class="col-md-2"></div>
    </div>
    <script src="media/js/jquery-3.1.1.min.js"></script>
    <script src="media/js/scripts.js"></script>
    </body>
</html>
