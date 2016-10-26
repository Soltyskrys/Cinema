<%-- 
    Document   : index
    Created on : Oct 17, 2016, 2:27:45 PM
    Author     : Krystian
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="/resources/html/menu.html" %>

        <div class="container">
            <div class ="row">
                <div class="col-md-2"> </div>
                <div class="col-md-8">
                    <%@include  file="/resources/html/jumbotron.html" %>
                    
                    
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Seanse</div>
     
                        <!-- Table -->
                        <table class="table ">
                            <thead>
                                <tr>
                       
                                    <th>Dzień</th>
                                    <th>Godzina</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="show" items="${shows}">
                                    <tr>

                                        <td>${show.projectiondate}</td>
                                        <td>${show.projectionhour}:${show.projectionminute}</td>
                                        
                                        <td><a href="../show/${show.id}/chooseSeat" class="btn btn-danger text-center" role="button">Rezerwuj</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                  </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        
        
  
    </body>
</html>
