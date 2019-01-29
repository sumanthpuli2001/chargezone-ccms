<%-- 
    Document   : EmployeeDataToExcel
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Irfan
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    
                    <th>Sr No.</th>
                   <th>Employee ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Date of Joining</th>
                    <th>Gender</th>
                    <th>DOB</th>
                    <th>Team</th> <!--Type of employee-->
                    <th>Sub-Team</th><!--Employee Sub-Type-->
                    <th>Designation</th>
                    <th>Employee Type</th><!--conform-->
                    <th>Line Manager</th><!--Reporting Manager-->
                  <th>Level</th>
                    <th>Work Location</th><!--Zydax location-->
                   <th>Role</th>
                   
                   <th>Name As Per</th>
                   
                    <th>First Name</th><!--passport First Name-->
                    <th>Middle Name</th><!--passport Middle Name-->
                    <th>Last Name</th><!--passport Last Name-->
                   <th>Passport No</th>
                    <th>Nationality</th>
                    <th>Country of Issue</th>
                    <th>Passport Issue Date</th>
                    <th>Passport Expiry Date</th>
                    <th>Visa issue country</th>
                    <th>Visa issue Date</th>
                    <th>Visa valid till date</th>
                    <th>Local Address1</th><!--Present Address-->
                    <th>Local Address2</th><!--Present Address2-->
                    <th>City/Town</th><!--Present city-->
                    <th>State</th><!--Present state-->
                    <th>Post Code</th><!--Present postal code-->
                    <th>Country</th><!--Present Country-->
                    
                    <th>Permanent Address1</th><!--Permanent Address-->
                    <th>Permanent Address2</th><!--Permanent Address2-->
                    <th>City/Town</th><!--Permanent city-->
                    <th>State</th><!--Permanent state-->
                    <th>Post Code</th><!--Permanent postal code-->
                    <th>Country</th><!--Permanent Country-->
                    <th>Resident Contact</th><!--Contact1-->
                    <th>Mobile No</th><!--Contact2-->
                    <th>FLYdocs Email Address</th><!--official email id-->
                    <th>Personal Email Address</th><!--personal email id-->
                    <th>Bank A/c No.</th>
                    <th>Bank Name</th>
                    <th>IFSC Code</th>
                    <th>PF withdrawal Date</th>
                    <th>PF No (Previous)</th><!--pf_no-->
                    <th>PF No.(FLYdocs)</th><!--pfNoFlydocs-->
                    <th>Election Card</th>
                    <th>PAN Card</th>
                    <th>Aadhar Card</th>
                    <th>ESI No</th>
                    <th>UAN</th>
                    <th>Marital Status</th>
                    <th>Religion</th>
                    <th>Blood Group</th>
                    <th>Disclosed Health Concerns</th>
                    <th>Driving Licence No.</th>
                    <th>2 wheeler / 4 wheeler / Both</th>
                    
                    
                    <th>Dependent 1 Name</th><!--father-->
                    <th>Dependent 1 DOB</th>
                    
                    <th>Dependent 2 Name</th><!--mother-->
                    <th>Dependent 2 DOB</th>
                    
                    <th>Dependent 3 Name</th><!--spouce-->
                    <th>Dependent 3 Gender</th>
                    <th>Dependent 3 DOB</th>
                    
                    <th>Dependent 4 Name</th><!--child1-->
                    <th>Dependent 4 Gender</th>
                    <th>Dependent 4 DOB</th>
                    
                    <th>Dependent 5 Name</th><!--child2-->
                    <th>Dependent 5 Gender</th>
                    <th>Dependent 5 DOB</th>
                    
                    <th>Emergency Contact Name</th>
                    <th>Relationship</th>
                    <th>Contact Number</th>
                    <th>Emergency Contact Address</th>
                    <th>Other important information relating to your emergency contact</th>
                    
                    
                    
                    <th>Name of Previous company</th>
                    <th>Company Location</th><!--previousCompanyLocation-->
                    
                    <th>Employees Exp. on date of Joining   FIPL (Year)</th><!--experience_year_on_doj-->
                    <th>Employees Exp. on date of Joining FIPL (Month)</th><!--experience_month_on_doj-->
                    <th>Highest Education Details</th>
                    <th>Language known </th>
                    <th>Hobbies</th>
                    <th>Work Type</th><!--shift type-->
<!--                    83<th>Hours</th>shifthourid
                    <th>Shift Name</th>shiftRotationInfo.setFirstShiftId
                    <th>Shift Rotation</th>shifthourid
                    86<th>Shift Rotation Date</th>-->
                    <th>Payment Type</th>
                    <th>Basic Salary</th>
                    <th>Company</th><!--CompanyLocation-->
                    <th>Department</th>
                </tr>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="employeeMasterList" items="${employeeMasterList}" varStatus="countemployee">
                <tr>
                    <td>${countemployee.count}</td>
                    <td>${employeeMasterList[0]}</td>
                    <c:set var="fullnameParts" value="${fn:split(employeeMasterList[1], ' ')}" />
                    <td>${fullnameParts[0]}</td>
                    <td>${fullnameParts[1]}</td>
                    <td>${employeeMasterList[2]}</td> 
                    
                    <c:choose>
                        <c:when test="${employeeMasterList[3] eq '1'}">
                            <td>Female</td> 
                        </c:when>
                        <c:otherwise>
                            <td>Male</td> 
                        </c:otherwise>
                    </c:choose>
                    <td>${employeeMasterList[4]}</td>
                    <td>${employeeMasterList[5]}</td>
                    <td>${employeeMasterList[6]}</td>
                    <td>${employeeMasterList[7]}</td>
                    <td>${employeeMasterList[8]}</td>
                    <td>${employeeMasterList[9]}</td>
                    <td>${employeeMasterList[10]}</td>
                    <td>${employeeMasterList[11]}</td>
                    <td>${employeeMasterList[12]}</td>
                    
                    <c:choose>
                        <c:when test="${employeeMasterList[83] eq '1'}">
                            <td>Aadhar Card</td> 
                        </c:when>
                        <c:otherwise>
                            <td>Passport</td> 
                        </c:otherwise>
                    </c:choose>
                    
                    <td>${employeeMasterList[53]}</td>
                    <td>${employeeMasterList[54]}</td>
                    <td>${employeeMasterList[55]}</td>
                    
                    <td>${employeeMasterList[13]}</td>
                    
                    <td>${employeeMasterList[56]}</td>
                    <td>${employeeMasterList[57]}</td>
                    
                    <td>${employeeMasterList[14]}</td>
                    <td>${employeeMasterList[15]}</td>
                    
                    <td>${employeeMasterList[85]}</td>
                    <td>${employeeMasterList[86]}</td>
                    <td>${employeeMasterList[87]}</td>
                    
                    
                    <td>${employeeMasterList[16]}</td>
                    
                    <td>${employeeMasterList[58]}</td>
                    <td>${employeeMasterList[59]}</td>
                    <td>${employeeMasterList[60]}</td>
                    <td>${employeeMasterList[61]}</td>
                    <td>${employeeMasterList[62]}</td>
                    
                    <td>${employeeMasterList[17]}</td>
                    
                    <td>${employeeMasterList[63]}</td>
                    <td>${employeeMasterList[64]}</td>
                    <td>${employeeMasterList[65]}</td>
                    <td>${employeeMasterList[66]}</td>
                    <td>${employeeMasterList[67]}</td>
                    
                    <td>${employeeMasterList[18]}</td>
                    <td>${employeeMasterList[19]}</td>
                    <td>${employeeMasterList[20]}</td>
                    <td>${employeeMasterList[21]}</td>
                    <td>${employeeMasterList[22]}</td>
                    <td>${employeeMasterList[23]}</td>
                    <td>${employeeMasterList[24]}</td>
                    
                    <td>${employeeMasterList[68]}</td>
                    
                    <td>${employeeMasterList[25]}</td>
                    
                    <td>${employeeMasterList[69]}</td>
                    <td>${employeeMasterList[70]}</td>
                    
                    <td>${employeeMasterList[26]}</td>
                    <td>${employeeMasterList[27]}</td>
                    <td>${employeeMasterList[28]}</td>
                    <td>${employeeMasterList[29]}</td>
                    <td>${employeeMasterList[30]}</td>
                    
                    <td>${employeeMasterList[71]}</td>
                
                    <td>${employeeMasterList[31]}</td>
                    
                    <td>${employeeMasterList[72]}</td> 
                   
                    <td>${employeeMasterList[32]}</td>
                    
                    <td>${employeeMasterList[73]}</td> 
                     
                    <td>${employeeMasterList[33]}</td>
                    <td>${employeeMasterList[34]}</td>
                    <td>${employeeMasterList[35]}</td>
                    <td>${employeeMasterList[36]}</td>
                    <td>${employeeMasterList[37]}</td>
                    
                    <c:choose>
                        <c:when test="${employeeMasterList[84] eq '1'}">
                            <td>Female</td> 
                        </c:when>
                        <c:otherwise>
                            <td>Male</td> 
                        </c:otherwise>
                    </c:choose>
                    
                    <td>${employeeMasterList[38]}</td>
                    <td>${employeeMasterList[39]}</td>
                    
                     
                     <c:choose>
                        <c:when test="${employeeMasterList[74] eq '1'}">
                            <td>Female</td> 
                        </c:when>
                        <c:otherwise>
                            <td>Male</td> 
                        </c:otherwise>
                    </c:choose>
                    
                    <td>${employeeMasterList[40]}</td>
                    <td>${employeeMasterList[41]}</td>
                    
                     
                     <c:choose>
                        <c:when test="${employeeMasterList[75] eq '1'}">
                            <td>Female</td> 
                        </c:when>
                        <c:otherwise>
                            <td>Male</td> 
                        </c:otherwise>
                    </c:choose>
                    
                    <td>${employeeMasterList[42]}</td>
                    <td>${employeeMasterList[43]}</td>
                    
                     <td>${employeeMasterList[76]}</td>
                    
                    <td>${employeeMasterList[44]}</td>
                    
                     <td>${employeeMasterList[77]}</td>
                     <td>${employeeMasterList[78]}</td>
                     <td>${employeeMasterList[79]}</td>
                     <td>${employeeMasterList[80]}</td>
                    
                    <td>${employeeMasterList[45]}</td>
                    <td>${employeeMasterList[46]}</td>
                    <td>${employeeMasterList[47]}</td>
                    
                     <td>${employeeMasterList[81]}</td>
                      <td>${employeeMasterList[82]}</td>
                    
                    <td>${employeeMasterList[48]}</td>
                    <td>${employeeMasterList[49]}</td>
                    <td>${employeeMasterList[50]}</td>
                    <td>${employeeMasterList[51]}</td>
                    <td>${employeeMasterList[52]}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
