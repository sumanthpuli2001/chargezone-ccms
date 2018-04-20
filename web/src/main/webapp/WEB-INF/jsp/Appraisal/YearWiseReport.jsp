<%-- 
    Document   : YearWiseReport
    Created on : 13 Apr, 2018, 5:23:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Year Sheet</title>
        <!--        <style>
                    table,th,td {
                        border: 1px solid black;
        
                    }
                </style>-->
    </head>

    <table id="table_2" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr  ></tr>
                    <tr  >
                        <th></th>
                        <th  colspan="2" style="border: 1px solid black;">Employee ID : ${employeeMaster.employeeId}</th>
                        <th colspan="6" style="border: 1px solid black;">Employee Name : ${employeeMaster.employeeName}</th>

                    </tr>
                    <tr  >
                        <th></th>
                        <th colspan="8" style="border: 1px solid black; text-align: left">Employee PMP Rating</th>
                    </tr>
                    <tr>
                        <th></th>
                        <th  style="border: 1px solid black;">Cycle</th>
                        <th  style="border: 1px solid black;">Cycle Start Unlock</th>
                        <th style="border: 1px solid black;">Cycle Start Lock</th>
                        <th style="border: 1px solid black;">Cycle End Unlock</th>
                        <th  style="border: 1px solid black;">Cycle End Lock</th>
                        <th  style="border: 1px solid black;">KRA Rating Out Of</th>
                        <th  style="border: 1px solid black;">Self Rating</th>
                        <th style="border: 1px solid black;">Management Rating</th>


                    </tr>

                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td></td>
                    <td style="border: 1px solid black;">${list[7]}-${list[8]}</td>
                    <td style="border: 1px solid black;">${list[2]}</td>
                    <td style="border: 1px solid black;">${list[3]}</td>
                    <td style="border: 1px solid black;">${list[0]}</td>
                    <td style="border: 1px solid black;">${list[1]}</td>
                    <td style="border: 1px solid black;">${list[4]}</td>
                    <td style="border: 1px solid black;">${list[5]}</td>
                    <td style="border: 1px solid black;">${list[6]}</td>

                </tr>
            </c:forEach>
            <tr>
                <th></th>
                <th colspan="5" style="border: 1px solid black;">Average Score 
                </th>

                <th style="border: 1px solid black;  text-align: right">75</th>
                <th style="border: 1px solid black; text-align: right" >${selftotal}</th>
                <th style="border: 1px solid black;  text-align: right">${managmenttotal}</th>

            </tr>

        </tbody>
    </table>


    <table id="table_2" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >



        <thead>
            <tr  border: 1px solid black;></tr>
            <tr  >
                <th></th>
                <th colspan="7" style="border: 1px solid black; text-align: left;">360 Feedback Rating</th>
            </tr>
            <tr>
                <th></th>
                <th  style="border: 1px solid black;">Cycle</th>
                <th  style="border: 1px solid black;">360 Rating Out Of</th>
                <th  style="border: 1px solid black;">Connected Department</th>
                <th  style="border: 1px solid black;">Superior</th>
                <th  style="border: 1px solid black;">Subordinate</th>
                <th  style="border: 1px solid black;">Peer</th>
                <!--<th  style="border: 1px solid black;">360 Rating Out Of</th>-->
                <%--<c:forEach var="dataList" items="${dataList}">--%>
                <!--<th  style="border: 1px solid black;">${dataList[0]}</th>-->
                <%--</c:forEach>--%>
                <th  style="border: 1px solid black;">Average Score</th>


            </tr>

        </thead>


        <tbody>
            <c:forEach var="cyclewiseFeedBack" items="${cyclewiseFeedBackList}">
                <tr>
                    <td></td>
                    <td style="border: 1px solid black; text-align: center">${cyclewiseFeedBack[0]}</td>
                    <td style="border: 1px solid black; text-align: center">25</td>
                    <td style="border: 1px solid black; text-align: center">${cyclewiseFeedBack[3]}</td>
                    <td style="border: 1px solid black; text-align: center">${cyclewiseFeedBack[1]}</td>
                    <td style="border: 1px solid black; text-align: center">${cyclewiseFeedBack[2]}</td>
                    <td style="border: 1px solid black; text-align: center">${cyclewiseFeedBack[4]}</td>
                    <!--<td style="border: 1px solid black;">25</td>-->
                    <%--<c:forEach var="dataList" items="${dataList}">--%>
                        <!--<th  style="border: 1px solid black;">${dataList[5]}</th>-->
                    <%--</c:forEach>--%>
                    <td style="border: 1px solid black;  text-align: center">${cyclewiseFeedBack[5]}</td>

                </tr>
            </c:forEach>



        </tbody>
    </table>

    <table id="table_2" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >



        <thead>
            <tr  border: 1px solid black;></tr>
            <tr>
                <th></th>
                <th  style="border: 1px solid black;">Management Score</th>
                <th  style="border: 1px solid black;">360 Form Score</th>
                <th  style="border: 1px solid black;">Total Score</th>


            </tr>

        </thead>


        <tbody>

            <tr>
                <td></td>
                <td style="border: 1px solid black;">${managmenttotal}</td>
                <td style="border: 1px solid black;">${avgWbs}</td>
                <td style="border: 1px solid black; text-align: right">${managmenttotal+avgWbs}/100</td>


            </tr>



        </tbody>
    </table>
</html>
