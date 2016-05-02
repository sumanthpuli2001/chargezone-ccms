<%--
    Document   : ImprovementGoalHistory
    Created on : Mar 28, 2016, 12:46:43 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="navbar-fixed">
        <div id="shiftName">
            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                <tr>
                    <th>Goal</th>
                    <th>Changed By</th>
                    <th>Date & Time</th>

                </tr>
                <c:forEach var="historyList" items="${historyList}">

                    <tr>
                        <td>${historyList[0]}</td>
                        <td>${historyList[1]}</td>
                        <td>${historyList[2]}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
