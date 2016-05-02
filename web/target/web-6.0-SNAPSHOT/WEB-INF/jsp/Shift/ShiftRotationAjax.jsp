<%--
    Document   : ShiftRotationAjax
    Created on : Nov 8, 2015, 12:35:57 PM
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
             <label>Shift Name</label>
            <c:choose>
                <c:when test="${empty shiftAjaxMap}">
                    <select id="shiftName" name="shiftName" class="form-control">
                        <option value="">-- Select --</option>
                    </select>
                </c:when>
                <c:otherwise>
                    <select id="shiftMasterId" name="shiftMasterId" class="form-control">
                        <option value="">-- Select --</option>
                        <c:forEach items="${shiftAjaxMap}" var="ele">
                            <c:if test="${firstShiftId eq ele.key}">
                                <option value="${ele.key}"  selected>${ele.value}</option>
                            </c:if>
                            <c:if test="${firstShiftId ne ele.key}">
                                <option value="${ele.key}" >${ele.value}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>