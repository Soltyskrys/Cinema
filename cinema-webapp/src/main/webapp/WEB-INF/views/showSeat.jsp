
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<spring:url value="/css/seatTable.css" var="tableCss" />
<spring:url value="/js/seats.js" var="seatsJS" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
        <link href="${tableCss}" rel="stylesheet"/>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="${seatsJS}"></script>
    </head>
    <body>

        <%@include file="/resources/html/menu.html" %>

        <div class="container">
            <div class ="row">
                <div class="col-md-2"> </div>
                <div class="col-md-8">
                    <%@include  file="/resources/html/jumbotron.html" %>                 
                    <div class ="row ">
                        <div class="col-md-6 col-md-offset-3">
                             <%--Todo validacja--%>
                            <div class="text-center"><h3> Dane o rezerwacji</h3></div>
                            <div class="form-group">
                                <label for="name">Imię:</label>
                                <input type="text" class="form-control" id="name"></input>
                            </div>
                            <div class="form-group">
                                <label for="surname">Nazwisko:</label>
                                <input type="text" class="form-control" id="surname"></input>
                            </div>
                            <div class="form-group">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="e-mail"></input>
                            </div>
                            <div class="form-group">
                                <label for="phone">Telefon</label>
                                <input type="email" class="form-control" id="phone"></input>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><div class="text-center"><h3>Ekran</h3></div></h3>
                        </div>
                        <div class="panel-body">
                            <div id="seats"></div>
                        </div>
                    </div>
                    <div class="text-center"><button type="button" class="btn btn-danger" id="reserveButton" onclick="reserve()">Rezerwuj</button></div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>

    <script type ="text/javascript">
        <%-- Seat initialization --%>

        var seats = [
        <c:forEach var="seat" items="${seats}" varStatus="status">
        {row:${seat.rowNumber}, col:${seat.columnNumber}, alreadyReserved:${seat.reserved}}<c:if test="${!loop.last}">,</c:if>
        </c:forEach>
        ];

        $seat = $('<button  type="button"  class="btn btn-xs"></button>');
        $span = $('<span class="glyphicon glyphicon-minus" aria-hidden="true"/>')
        $seat.append($span);
        
        $table = generateTable(${rowNumber}, ${colNumber});
        var fOnChooseSeat = onChooseSeat;
        fillTable($table, seats, $seat, fOnChooseSeat);
        $("#seats").append($table);

    </script>
</body>
</html>
