<%--
    Document   : EmployeeDataToExcel
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Dhaval
--%>


<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <script type="text/javascript" src="StorageYard/JS/TableSorter/jquery-latest.js"></script>
    <script type="text/javascript" src="StorageYard/JS/TableSorter/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="StorageYard/JS/TableSorter/jquery.metadata.js"></script>
    <script>
        $(document).ready(function() 
    { 
        $("#table_1").tablesorter( {sortList: [[0,0], [1,0]]} ); 
    } 
); 
    
    </script>



    <head>

        <title>Employee Detail Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
            /*            html, body {
                            margin: 0;
                            padding: 0;
                        }*/
            table#table_2 {
                /*border-collapse: separate;*/
                empty-cells: hide;
            }
        </style>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="StorageYard/JS/jquery.table2excel.js"></script>
        <script>
            $('#table_2 th').each(function (i) {
                var remove = 0;

                var tds = $(this).parents('table').find('tr td:nth-child(' + (i + 1) + ')')
                tds.each(function (j) {
                    if (this.innerHTML == '')
                        remove++;
                });

                if (remove == ($('#table_2 tr').length - 1)) {
                    $(this).hide();
                    tds.hide();
                }
            });
        </script>

    </head>

    <table id="table_1" class="table2excel" cellpadding="0" cellspacing="0" align="Center" >
        <c:choose>
            <c:when test="${empty empDetail}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <tr>
                </tr>
                <div><h3>Employee Information</h3></div>
                <tr>
                    <!--<th style="margin:0px;padding:0px;height:100%;">user id</th>-->

                    <c:if test="${employeeAdvanceSearch.employeeId}">
                        <th style="margin:0px;padding:0px;height:100%;">Employee ID</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.employeeName}">
                        <th style="margin:0px;padding:0px;height:100%;">Employee Name</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.fatherName}">
                        <th style="margin:0px;padding:0px;height:100%;">Father Name</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.motherName}">
                        <th style="margin:0px;padding:0px;height:100%;">Mother Name</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.gender}">
                        <th style="margin:0px;padding:0px;height:100%;">Gender</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.maritalStatus}">
                        <th style="margin:0px;padding:0px;height:100%;">Marital Status</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.dateOfBirth}">
                        <th style="margin:0px;padding:0px;height:100%;">Date Of Birth</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.presentAddress}">
                        <th style="margin:0px;padding:0px;height:100%;">Present Address</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.permanentAddress}">
                        <th style="margin:0px;padding:0px;height:100%;">Permanent Address</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.bloodGroups}">
                        <th style="margin:0px;padding:0px;height:100%;">Blood Group</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.emailAddress}">
                        <th style="margin:0px;padding:0px;height:100%;">Email Id</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.contactNo1}">
                        <th style="margin:0px;padding:0px;height:100%;">Contact No 1.</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.contactNo2}">
                        <th style="margin:0px;padding:0px;height:100%;">Contact No 2.</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.emergencyContactPerson}">
                        <th style="margin:0px;padding:0px;height:100%;">Emergency Contact Person</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.emergencyContactNo}">
                        <th style="margin:0px;padding:0px;height:100%;">Emergency Contact No</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.panCard}">
                        <th style="margin:0px;padding:0px;height:100%;">PAN Card No</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.passportNo}">
                        <th style="margin:0px;padding:0px;height:100%;">Passport No</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.passportIssueDate}">
                        <th style="margin:0px;padding:0px;height:100%;">Passport Issue Date</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.passportExpiryDate}">
                        <th style="margin:0px;padding:0px;height:100%;">Passport Expiry Date</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.adharCard}">
                        <th style="margin:0px;padding:0px;height:100%;">Aadhar Card</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.officeEmailId}">
                        <th style="margin:0px;padding:0px;height:100%;">Official E-Mail ID</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.highestEducationDetails}">
                        <th style="margin:0px;padding:0px;height:100%;">Highest Education Details</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.experienceYearOnDoj}">
                        <th style="margin:0px;padding:0px;height:100%;">Exp. On Date Of Joining Year</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.experienceMonthOnDoj}">
                        <th style="margin:0px;padding:0px;height:100%;">Exp. On Date Of Joining Month</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.company}">
                        <th style="margin:0px;padding:0px;height:100%;">Company</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.zydexLocation}">
                        <th style="margin:0px;padding:0px;height:100%;">Zydex Location</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.workLocation}">
                        <th style="margin:0px;padding:0px;height:100%;">Work Location</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.level}">
                        <th style="margin:0px;padding:0px;height:100%;">Level</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.department}">
                        <th style="margin:0px;padding:0px;height:100%;">Department</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.designation}">
                        <th style="margin:0px;padding:0px;height:100%;">Designation</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.role}">
                        <th style="margin:0px;padding:0px;height:100%;">Role</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.dateOfJoining}">
                        <th style="margin:0px;padding:0px;height:100%;">Date Of Joining</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.employeeType}">
                        <th style="margin:0px;padding:0px;height:100%;">Employee Type</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.bankName}">
                        <th style="margin:0px;padding:0px;height:100%;">Bank Name</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.bankAccountNo}">
                        <th style="margin:0px;padding:0px;height:100%;">Bank Account No</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.bankAccountNo}">
                        <th style="margin:0px;padding:0px;height:100%;">IFSC Code</th>
                        </c:if>
                        <c:if test="${employeeAdvanceSearch.reportingManager}">
                        <th style="margin:0px;padding:0px;height:100%;">Reporting Manager</th>
                        </c:if>
                </tr>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:set var="absent" value="0"></c:set>
            <c:set var="present" value="0"></c:set>
            <c:forEach var="employeeMasterList" items="${empDetail}">
                <tr>

                    <c:if test="${employeeAdvanceSearch.employeeId}">
                        <td style="font-weight: bold">${employeeMasterList[0]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.employeeName}">
                        <td style="font-weight: bold">${employeeMasterList[1]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.fatherName}">
                        <td style="font-weight: bold">${employeeMasterList[2]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.motherName}">
                        <td style="font-weight: bold">${employeeMasterList[3]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.gender}">
                        <td style="font-weight: bold">${employeeMasterList[4]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.maritalStatus}">
                        <td style="font-weight: bold">${employeeMasterList[5]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.dateOfBirth}">
                        <td style="font-weight: bold">${employeeMasterList[6]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.presentAddress}">
                        <td style="font-weight: bold">${employeeMasterList[7]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.permanentAddress}">
                        <td style="font-weight: bold">${employeeMasterList[8]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.bloodGroups}">
                        <td style="font-weight: bold">${employeeMasterList[9]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.emailAddress}">
                        <td style="font-weight: bold">${employeeMasterList[10]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.contactNo1}">
                        <td style="font-weight: bold">${employeeMasterList[11]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.contactNo2}">
                        <td style="font-weight: bold">${employeeMasterList[12]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.emergencyContactPerson}">
                        <td style="font-weight: bold">${employeeMasterList[13]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.emergencyContactNo}">
                        <td style="font-weight: bold">${employeeMasterList[14]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.panCard}">
                        <td style="font-weight: bold">${employeeMasterList[15]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.passportNo}">
                        <td style="font-weight: bold">${employeeMasterList[16]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.passportIssueDate}">
                        <td style="font-weight: bold">${employeeMasterList[17]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.passportExpiryDate}">
                        <td style="font-weight: bold">${employeeMasterList[18]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.adharCard}">
                        <td style="font-weight: bold">${employeeMasterList[19]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.officeEmailId}">
                        <td style="font-weight: bold">${employeeMasterList[20]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.highestEducationDetails}">
                        <td style="font-weight: bold">${employeeMasterList[21]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.experienceYearOnDoj}">
                        <td style="font-weight: bold">${employeeMasterList[22]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.experienceMonthOnDoj}">
                        <td style="font-weight: bold">${employeeMasterList[23]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.company}">
                        <td style="font-weight: bold">${employeeMasterList[24]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.zydexLocation}">
                        <td style="font-weight: bold">${employeeMasterList[25]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.workLocation}">
                        <td style="font-weight: bold">${employeeMasterList[26]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.level}">
                        <td style="font-weight: bold">${employeeMasterList[27]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.department}">
                        <td style="font-weight: bold">${employeeMasterList[28]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.designation}">
                        <td style="font-weight: bold">${employeeMasterList[29]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.role}">
                        <td style="font-weight: bold">${employeeMasterList[30]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.dateOfJoining}">
                        <td style="font-weight: bold">${employeeMasterList[31]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.employeeType}">
                        <td style="font-weight: bold">${employeeMasterList[32]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.bankName}">
                        <td style="font-weight: bold">${employeeMasterList[33]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.bankAccountNo}">
                        <td style="font-weight: bold">${employeeMasterList[34]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.bankAccountNo}">
                        <td style="font-weight: bold">${employeeMasterList[35]}</td>
                    </c:if>
                    <c:if test="${employeeAdvanceSearch.reportingManager}">
                        <td style="font-weight: bold">${employeeMasterList[36]}</td>
                    </c:if>
                </tr>
                <c:choose>
                    <c:when test="${empty map[employeeMasterList[38]]}">

                    </c:when>
                    <c:otherwise>
                        <tr>
                            <c:set var="absent" value="0"></c:set>
                            <c:set var="present" value="0"></c:set>
                                <td colspan="31">

                                    <table id="table_2" class="table2excel" style="" cellpadding="3" align="Center"  >
                                        <div><h3>Employee Daily Attendance Information</h3></div>
                                        <tr>
                                            <td></td>
                                        <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                            <th style="margin:0px;padding:0px;height:100%;">${list[0]}</th>
                                            </c:forEach>
                                    </tr>
                                    <tr>
                                        <th style="margin:0px;padding:0px;height:100%;">Shift Name</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                                <c:if test="${fn:contains(list[1], ' # ')}">
                                                    <c:set var="string1" value="${fn:split(list[1], '#')}"/>
                                                    <c:set var="string1" value="${fn:split(string1[1], '$')}"/>
                                                <th style="margin:0px;padding:0px;height:100%;">${string1[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '`')}">
                                                <th style="margin:0px;padding:0px;height:100%;">-</th>
                                                </c:if>
                                            </c:forEach>

                                    </tr>
                                    <tr>
                                        <th style="margin:0px;padding:0px;height:100%;">First In</th>

                                        <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                            <c:if test="${fn:contains(list[1], '`')}">
                                                <c:set var="string2" value="${fn:split(list[1], '`')}"/>
                                                <c:set var="string2" value="${fn:split(string2[1], '!')}"/>
                                                <th style="margin:0px;padding:0px;height:100%;">${string2[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '`')}">
                                                <th style="margin:0px;padding:0px;height:100%;">${list[1]}</th>
                                                </c:if>




                                        </c:forEach>
                                    </tr>
                                    <tr>
                                        <th style="margin:0px;padding:0px;height:100%;">Last Out</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">

                                            <%--<c:set var="string5" value="${fn:join(list[1], 'To ')}"/>--%>

                                            <c:if test="${fn:contains(list[1], '!')}">
                                                <c:set var="string4" value="${fn:split(list[1], '!')}"/>
                                                <c:set var="string5" value="${fn:split(string4[1], '@')}"/>
                                                <th style="margin:0px;padding:0px;height:100%;">${string5[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '@')}">
                                                <th style="margin:0px;padding:0px;height:100%;">-</th>
                                                </c:if>
                                            </c:forEach>

                                    </tr>
                                    <tr>
                                        <th style="margin:0px;padding:0px;height:100%;">1st Half</th>
                                            <c:set var="firstHalfVal" value="0"></c:set>
                                            <c:set var="counter" value="0"></c:set>
                                            <c:set var="firstCounter" value="0"></c:set>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                                <c:if test="${fn:contains(list[1], 'fullday')}">

                                                <c:set var="counter" value="${counter + 1}"></c:set>
                                                    <th style="color: green;">PR</th>
                                                    <c:set var="present" value="${present + 0.5}"></c:set>

                                            </c:if>
                                            <c:if test="${!fn:contains(list[1], 'fullday')}">

                                                <c:set var="firstHalfVal" value="0"></c:set>
                                                <c:set var="leave" value="${fn:split(list[1], '@')}"/>
                                                <c:set var="leave1" value="${fn:split(leave[1], '#')}"/>

                                                <c:set var="userTimeInStr" value="${fn:split(list[1], '`')}"/>
                                                <c:set var="userTimeInStr1" value="${fn:split(userTimeInStr[1], '!')}"/>
                                                <c:set var="userTimeOutStr" value="${fn:split(list[1], '!')}"/>
                                                <c:set var="userTimeOutStr" value="${fn:split(userTimeOutStr[1], '@')}"/>
                                                <c:set var="LateHoursStr" value="${fn:split(list[1], '$')}"/>
                                                <c:set var="LateHoursStr" value="${fn:split(LateHoursStr[1], '%')}"/>
                                                <c:set var="endHoursStr" value="${fn:split(list[1], '%')}"/>
                                                <c:set var="endHoursStr" value="${fn:split(endHoursStr[1], '^')}"/>

                                                <c:set var="firstStartHoursStr" value="${fn:split(list[1], '+')}"/>


                                                <fmt:parseDate value="${userTimeInStr1[0]}" var="userTimeIn" pattern="HH:mm" />
                                                <fmt:parseDate value="${userTimeOutStr[0]}" var="userTimeOut" pattern="HH:mm" />
                                                <fmt:parseDate value="${LateHoursStr[0]}" var="LateHours" pattern="HH:mm" />
                                                <fmt:parseDate value="${endHoursStr[0]}" var="endHours" pattern="HH:mm" />
                                                <fmt:parseDate value="${firstStartHoursStr[1]}" var="firstStartHours" pattern="HH:mm" />
                                                <c:if test="${userTimeIn ne null}">
                                                    <c:choose>
                                                        <c:when test="${userTimeIn le firstStartHours and userTimeOut ge endHours}">
                                                            <th style="color: green;">PR</th>
                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                            </c:when>
                                                            <c:when test="${leave1[0] ne null and !fn:contains(leave1[0], 'Short Leave')}">
                                                                <c:choose>

                                                                <c:when test="${userTimeIn le LateHours and userTimeOut ge endHours and firstCounter le 2}">

                                                                    <c:if test="${fn:contains(leave1[0], 'AB')}">
                                                                        <c:set var="present" value="${present + 0.5}"></c:set>
                                                                    </c:if>
                                                                    <c:set var="firstCounter" value="${firstCounter +1}"></c:set>

                                                                        <th style="color: green;">PR</th>
                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    <c:if test="${fn:contains(leave1[0], 'AB')}">
                                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                    </c:if>
                                                                    <th style="color: red;">${leave1[0]}</th>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:when>
                                                            <c:when test="${null ne leave1[0] and fn:contains(leave1[0], 'Short Leave')}">
                                                                <c:if test="${fn:contains(list[1], ' * ')}">
                                                                    <c:set var="shortArray" value="${fn:split(list[1], '*')}"></c:set>
                                                                    <c:set var="endArray" value="${fn:split(shortArray[1], '-')}"></c:set>
                                                                    <c:set var="startTime" value="${fn:split(endArray[1], '+')}"></c:set>
                                                                    <fmt:parseDate value="${shortArray[1]}" var="shortIn" pattern="HH:mm" />
                                                                    <fmt:parseDate value="${endArray[1]}" var="shortend" pattern="HH:mm" />
                                                                    <fmt:parseDate value="${startTime[1]}" var="startTime" pattern="HH:mm" />
                                                                    <c:choose>
                                                                        <c:when test="${startTime le shortIn and shortIn le endHours}">
                                                                            <c:choose>
                                                                                <c:when  test="${userTimeIn < endHours}">
                                                                                <th style="color: green;">SHL/P</th>
                                                                                </c:when>
                                                                                <c:when  test="${userTimeIn ge endHours}">

                                                                                <th style="color: red;">SHL/A</th>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                <th style="color: red;">AB</th>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                        <th style="color: red;">AB</th>
                                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <th style="color: red;">AB</th>
                                                                <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                    <c:if test="${userTimeIn eq null}">
                                                    <th style="margin:0px;padding:0px;height:100%;">-</th>
                                                    </c:if>

                                            </c:if>

                                        </c:forEach>

                                    </tr>

                                    <tr>
                                        <th style="margin:0px;padding:0px;height:100%;">2nd Half</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">

                                            <c:if test="${fn:contains(list[1], ' # ')}">
                                                <c:set var="string1" value="${fn:split(list[1], '#')}"/>
                                                <c:set var="string1" value="${fn:split(string1[1], '$')}"/>
                                                <c:set var="shiftName" value="${fn:trim(string1[0])}"/>

                                            </c:if>

                                            <c:if test="${fn:contains(list[1], 'fullday')}">
                                                <th style="color: green;">PR</th>
                                                    <c:set var="present" value="${present + 0.5}"></c:set>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], 'fullday')}">
                                                    <c:set var="leave" value="${fn:split(list[1], '@')}"/>
                                                    <c:set var="leave1" value="${fn:split(leave[1], '#')}"/>

                                                <c:set var="userTimeInStr" value="${fn:split(list[1], '`')}"/>
                                                <c:set var="userTimeInStr1" value="${fn:split(userTimeInStr[1], '!')}"/>
                                                <c:set var="userTimeOutStr" value="${fn:split(list[1], '!')}"/>
                                                <c:set var="userTimeOutStr" value="${fn:split(userTimeOutStr[1], '@')}"/>
                                                <c:set var="secondHalfTimeStr" value="${fn:split(list[1], '^')}"/>
                                                <c:set var="secondHalfTimeStr" value="${fn:split(secondHalfTimeStr[1], '&')}"/>
                                                <c:set var="endHoursStr" value="${fn:split(list[1], '&')}"/>

                                                <fmt:parseDate value="${userTimeInStr1[0]}" var="userTimeIn" pattern="HH:mm" />
                                                <fmt:parseDate value="${userTimeOutStr[0]}" var="userTimeOut" pattern="HH:mm" />
                                                <c:set var="getInHours" value="${fn:split(userTimeInStr1[0], ':')}"/>
                                                <c:set var="getOutHours" value="${fn:split(userTimeOutStr[0], ':')}"/>
                                                <c:set var="abc" value="${fn:trim(getInHours[0])}"/>
                                                <c:set var="xyz" value="${fn:trim(getOutHours[0])}"/>
                                                <fmt:parseNumber var="i11" integerOnly="true" type="number" value="${abc-xyz}" />
                                                <fmt:parseNumber var="totalDuration" value="${24-i11}" type="number"/>
                                                <%--<c:set var="totalDuration1" value="${getInHours[0] - getOutHours[0]}"></c:set>--%>
                                                <c:set var="totalDuration2" value="${getOutHours[0]}"></c:set>
                                                <%--<c:set var="totalDuration3" value="${totalDuration2+1}"></c:set>--%>
                                                <%--<fmt:parseNumber var="parsedNumber" integerOnly="true" type="number" value="${getInHours[0]}" />--%>
                                                <%--<fmt:parseNumber var="parsedNumber" type="number" value="${getInHours[0]}" />--%>
                                                <%--<fmt:parseNumber var="parsedNumber1" type="number" value="${getOutHours[0]}" />--%>

                                                <fmt:parseDate value="${secondHalfTimeStr[0]}" var="secondHalfTimeStr" pattern="HH:mm" />
                                                <fmt:parseDate value="${endHoursStr[1]}" var="endHours" pattern="HH:mm" />
                                                <c:if test="${userTimeIn ne null}">
                                                    <c:choose>
                                                        <c:when test="${userTimeIn le secondHalfTimeStr and userTimeOut ge endHours}">

                                                            <th style="color: green;">PR</th>
                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                            </c:when>
                                                            <c:when test="${fn:contains(shiftName, 'Night') && userTimeOut ge endHours}">
                                                            <th style="color: green;">PR </th>
                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                            </c:when>


                                                        <c:when test="${null ne leave1[0] and fn:contains(leave1[0], 'Short Leave')}">
                                                            <c:if test="${fn:contains(list[1], ' * ')}">
                                                                <c:set var="shortArray" value="${fn:split(list[1], '*')}"></c:set>
                                                                <c:set var="endArray" value="${fn:split(list[1], '^')}"></c:set>
                                                                <c:set var="secondhalfstartTime" value="${fn:split(endArray[1], '&')}"></c:set>
                                                                <fmt:parseDate value="${shortArray[1]}" var="shortIn" pattern="HH:mm" />
                                                                <fmt:parseDate value="${secondhalfstartTime[0]}" var="secondhalfstartTime" pattern="HH:mm" />

                                                                <c:choose>
                                                                    <c:when test="${secondhalfstartTime le shortIn and shortIn le endHours}">
                                                                        <c:choose>
                                                                            <c:when  test="${userTimeOut > secondHalfTimeStr}">
                                                                                <th style="color: green;">SHL/P</th>
                                                                                </c:when>
                                                                                <c:when  test="${userTimeOut le secondHalfTimeStr}">
                                                                                <th style="color: red;">SHL/A</th>
                                                                                </c:when>


                                                                            <c:otherwise>
                                                                                <th style="color: red;">AB</th>

                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <th style="color: red;">AB</th>
                                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:when>

                                                        <c:otherwise>
                                                            <th style="color: red;">AB  </th>
                                                                <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                    <c:if test="${userTimeIn eq null}">
                                                    <th style="margin:0px;padding:0px;height:100%;">-</th>
                                                    </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                    <tr style="border: 0px;">
                                        <td style="border: 0px;"></td>
                                    </tr>
                                    <tr>
                                        <th colspan="2">Day Count</th>
                                    </tr>
                                    <tr>
                                        <th style="color: green;">PR</th>
                                        <th style="color: red;">AB</th>
                                    </tr>
                                    <tr>
                                        <td style="color: green;" align="center">${present}</td>
                                        <td style="color: red;" align="center">${absent}</td>
                                    </tr>
                                    <tr style="border: 0px;">
                                        <td style="border: 0px;"></td>
                                    </tr>
                        </tr>


                </table>
            </td>
        </tr>
    </c:otherwise>
</c:choose>
</c:forEach>
</tbody>
</table>
<script>
    $(function () {
        $(".table2excel").table2excel({
            exclude: ".noExl",
            name: "Excel Document Name",
            filename: "myFileName",
            fileext: ".xls",
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true
        });
    });
</script>
<%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>
