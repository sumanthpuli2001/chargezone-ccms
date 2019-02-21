<%-- 
    Document   : EmployeeSubTypeAjax
    Created on : Jul 26, 2016, 9:28:36 AM
    Author     : Nishant
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
             <label>Sub-Team:<span style="color: red;font-size: 12px;">*</span></label>
            <c:choose>
                <c:when test="${empty employeeSubTypeList || val eq 'None'}">
                    <select id="subTypeId" name="subTypeId" class="form-control">
                        <option value="">-- Select --</option>
                    </select>
                </c:when>
                <c:otherwise>
                    <select id="subTypeId" name="subTypeId" class="form-control">
                        
                        <c:forEach items="${employeeSubTypeList}" var="ele">
                            <c:choose>
                                <c:when test="${employeeSubTypeId == ele.id}">
                                <option value="${ele.id}" selected>${ele.subType}</option>
                                </c:when>
                               
                                <c:otherwise>
                                <option value="${ele.id}" >${ele.subType}</option>
                                    
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
