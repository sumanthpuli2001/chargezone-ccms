<%--
    Document   : LeaveEmployeeBalanceUpdate
    Created on : May 9, 2016, 5:26:37 PM
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
            <input type="hidden" name="empLeaveBalId" id="empLeaveBalId" value="${employeeLeaveBalance.id}">
            <div class="col-sm-12">
                <div class="col-sm-2">
                    <label>Employee Id:<span style="color: red;font-size: 12px;"></span></label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="employeeId" readonly="true" value="${employeeMaster.employeeId}">
                </div>
                <div class="col-sm-2">
                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="employeeName" readonly="true" value="${employeeMaster.employeeName}">
                </div>
            </div>
            <div class="col-sm-12">
                <div class="col-sm-2">

                    <label>Leave Type:<span style="color: red;font-size: 12px;"></span></label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="leaveType" readonly="true" value="${leaveTypeMaster.leaveType}">
                </div>
                <div class="col-sm-2">

                    <label>Balance:<span style="color: red;font-size: 12px;"></span></label>
                </div>
                <div class="col-sm-4">
                    <input type="text" name="leaveBalance" id="leaveBalance" value="${employeeLeaveBalance.noOfLeaveRemain}">
                </div>
            </div>


        </div>
    </body>
</html>

