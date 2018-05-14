<%-- 
    Document   : EmployeeDataToExcel
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Irfan
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Employee Detail Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>

    <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
        <c:choose>
            <c:when test="${empty employeeMasterList}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <tr>
                </tr>
                <tr>
                    <!--<th>user id</th>-->
                   
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Designation</th>
                    <th>Type of employee</th>
                    <th>Employee Type</th><!--17 -->
                    <th>Employee Sub-Type</th>
                    <th>Role</th>
                    <th>Shift Type</th> 
                    <th>Level</th>
                    <th>Company Name</th>
                    <th>Location</th>
                    <th>Work Location</th>
                    <th>E-mail-Id</th>
                    <th>Office Email ID</th>
                    <th>Gender</th> 
                    <th>DOB</th> 
                    <th>Blood Group</th>
                    <th>Highest Education Detail</th>
                    <th>Contact No.</th>
                    <th>Contact NO2</th>
                    <th>Present Address</th>
                    <th>Permanent Address</th>
                    <th>Marital Status</th>
                    <th>Father Name</th>
                    <th>Mother Name</th>
                    <th>Spouse Name</th>
                    <th>Child 1</th>
                    <th>Child 2</th>
                    <th>Emergency Contact Person</th>
                    <th>Emergency Contact No</th>
                    <th>Pancard</th>
                    <th>Passport No</th>
                    <th>AdharCard</th>
                    <th>Bank Name</th>
                    <th>Bank Account No</th>
                    <th>Bank Ifsc</th>
                    <th>City of Employee</th>
                    <th>Payment Type</th>
                    <th>Pf No</th>
                    <th>Ua No</th>
                    <th>Basic Salary</th>
                    <th>ESIC No</th>
                    <th>PF Amount</th>
                </tr>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="employeeMasterList" items="${employeeMasterList}">
                <tr>
                    
                    <td>${employeeMasterList[1]}</td>
                    <td>${employeeMasterList[2]}</td>
                    <td>${employeeMasterList[3]}</td>
                    <td>${employeeMasterList[4]}</td>
                    <td>${employeeMasterList[17]}</td>
                    <td>${employeeMasterList[29]}</td>
                    <td>${employeeMasterList[18]}</td>
                    <td>${employeeMasterList[19]}</td>
                    <td>${employeeMasterList[30]}</td>
                    <td>${employeeMasterList[5]}</td>
                    <td>${employeeMasterList[6]}</td>
                    <td>${employeeMasterList[7]}</td>
                    <td>${employeeMasterList[8]}</td>
                    <td>${employeeMasterList[10]}</td>
                    <td>${employeeMasterList[31]}</td>
                    <td>${employeeMasterList[12]}</td>
                    <td>${employeeMasterList[23]}</td>
                    <td>${employeeMasterList[36]}</td>
                    <td>${employeeMasterList[34]}</td>
                    <td>${employeeMasterList[11]}</td>
                    <td>${employeeMasterList[20]}</td>
                    <td>${employeeMasterList[14]}</td>
                    <td>${employeeMasterList[15]}</td>
                    <td>${employeeMasterList[13]}</td>
                    <td>${employeeMasterList[21]}</td>
                    <td>${employeeMasterList[22]}</td>
                    <td>${employeeMasterList[24]}</td>
                    <td>${employeeMasterList[32]}</td>
                    <td>${employeeMasterList[33]}</td>
                    <td>${employeeMasterList[25]}</td>
                    <td>${employeeMasterList[26]}</td>
                    <td>${employeeMasterList[27]}</td>
                    <td>${employeeMasterList[28]}</td>
                    <td>${employeeMasterList[35]}</td>
                    <td>${employeeMasterList[37]}</td>
                    <td>${employeeMasterList[38]}</td>
                    <td>${employeeMasterList[39]}</td>
                    <td>${employeeMasterList[40]}</td>
                    <td>${employeeMasterList[41]}</td>
                    <td>${employeeMasterList[42]}</td>
                    <td>${employeeMasterList[43]}</td>
                    <td>${employeeMasterList[44]}</td>
                    <td>${employeeMasterList[45]}</td>
                    <td>${employeeMasterList[46]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
