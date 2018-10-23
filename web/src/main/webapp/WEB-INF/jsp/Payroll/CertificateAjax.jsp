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
   <div class="box-header" style="text-align: right;">
    <input type="button" class="btn btn-facebook col-sm-offset-4"  style="width: 100px;" value="Print" onclick="printDiv('printableArea')">
    <!--<input type="button" class="btn btn-facebook col-sm-offset-4"  style="width: 100px;" value="Downlaod" onclick="download123()">-->
    <!--<button class="btn btn-box-tool" data-widget="collapse" onclick="download123()">Value</button>-->
    <a href="<%= request.getContextPath()%>/StorageYard/Certificate/${employeeName}/${certificateTemplateType}.pdf">Download</a>
    
    <!--<input type="text"  name="path" id="path" value="<%= request.getContextPath()%>"/>-->
     </div>
     <div id="printableArea">
    <body class="navbar-fixed">
        <div id="shiftName">
            <label>${msg}</label>
        </div>
        
    </body>
     </div>
    
</html>      

