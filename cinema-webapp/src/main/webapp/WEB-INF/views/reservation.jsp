
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href=""
    </head>
    <body>
        <%@include file="/resources/html/menu.html" %>

        <div class="container">
            <div class ="row">
                <div class="col-md-2"> </div>
                <div class="col-md-8">
                    <%@include  file="/resources/html/jumbotron.html" %>
                     <div class="row">
                        <c:forEach items="${movies}" var="movie">
                            <c:set var="movie" value="${movie}" scope="request"></c:set>
                            <jsp:include page="/resources/jspf/movie/movie.jsp"></jsp:include>
                        </c:forEach>
                     </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </body>
</html>
