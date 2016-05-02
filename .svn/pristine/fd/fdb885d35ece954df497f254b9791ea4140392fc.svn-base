<%-- 
    Document   : EmployeeDataToExcel
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Dhaval
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
        <title>Employee Detail Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>

    <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
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
                    <!--<th>user id</th>-->

                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Date Of Joining</th>
                    <th>Present Day</th>
                    <th>Weekly Offs</th>
                    <th>Holidays</th>
                    <th>Short Leave</th>
                    <th>C-Off</th>
                    <th>CL<table><tr><th>Last Month</th><th>Cur. Month</th></tr></table></th>
            <th>SL<table><tr><th>Last Month</th><th>Cur. Month</th></tr></table></th>
        <th>PL<table><tr><th>Last Month</th><th>Cur. Month</th></tr></table></th>
    <th>PTL</th>
    <th>ML</th>
    <th>AR<table><tr><th>Last Month</th><th>Cur. Month</th></tr></table></th>
<th>TR<table><tr><th>Last Month</th><th>Cur. Month</th></tr></table></th>
<th>Arrears</th>
<th>Paid Days</th>
<th>LWP</th>
<th>Total Days</th>
</tr>
</c:otherwise>
</c:choose>
<tbody>
    <c:set var="present" value="0"></c:set>
    <c:set var="ar" value="0"></c:set>
    <c:set var="wO" value="0"></c:set>
    <c:set var="hl" value="0"></c:set>
    <c:set var="cl" value="0"></c:set>
    <c:set var="sl" value="0"></c:set>
    <c:set var="pl" value="0"></c:set>
    <c:set var="totalDays" value="0"></c:set>
    <c:set var="lwp" value="0"></c:set>
    <c:forEach var="employeeMasterList" items="${empDetail}">
        <c:set var="ar" value="0"></c:set>
        <c:set var="hl" value="0"></c:set>
        <c:set var="present" value="0"></c:set>
        <c:set var="wO" value="0"></c:set>
        <c:set var="cl" value="0"></c:set>
        <c:set var="sl" value="0"></c:set>
        <c:set var="pl" value="0"></c:set>
        <c:set var="lwp" value="0"></c:set>

        <c:set var="totalDays" value="0"></c:set>
        <c:set var="firstStartTime" value="0"></c:set>
        <c:set var="firstHalfVal" value="0"></c:set>
        <c:set var="counter" value="0"></c:set>
        <c:set var="firstCounter" value="0"></c:set>
        <c:forEach var="list" items="${map[employeeMasterList[4]]}">
            <c:if test="${fn:contains(list[1], 'fullday')}">
                <c:set var="counter" value="${counter + 1}"></c:set>
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
                            <c:set var="present" value="${present + 0.5}"></c:set>
                        </c:when>
                        <c:when test="${leave1[0] ne null and !fn:contains(leave1[0], 'Short Leave')}">
                            <c:choose>
                                <c:when test="${userTimeIn le LateHours and userTimeOut ge endHours and firstCounter le 2}">
                                    <c:if test="${fn:contains(leave1[0], 'AB')}">
                                        <c:set var="present" value="${present + 0.5}"></c:set>
                                    </c:if>
                                    <c:set var="firstCounter" value="${firstCounter +1}"></c:set>
                                </c:when>
                                <c:when test="${fn:contains(leave1[0], 'AR')}">
                                    <c:set var="ar" value="${ar + 0.5}"></c:set>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </c:if>

                <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO')  && !fn:contains(list[1], '?') 
                              && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                              && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                              && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay')}">
                    <c:set var="ar" value="${ar + 0.5}"></c:set>
                </c:if>
            </c:if>

        </c:forEach>

        <c:forEach var="list" items="${map[employeeMasterList[4]]}">

            <c:if test="${fn:contains(list[1], ' # ')}">
                <c:set var="string1" value="${fn:split(list[1], '#')}"/>
                <c:set var="string1" value="${fn:split(string1[1], '$')}"/>
                <c:set var="shiftName" value="${fn:trim(string1[0])}"/>

            </c:if>

            <c:if test="${fn:contains(list[1], 'fullday')}">
                <c:set var="present" value="${present + 0.5}"></c:set>
            </c:if>
            <c:if test="${!fn:contains(list[1], 'fullday') }">
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
                <c:set var="totalDuration2" value="${getOutHours[0]}"></c:set>
                <fmt:parseDate value="${secondHalfTimeStr[0]}" var="secondHalfTimeStr" pattern="HH:mm" />
                <fmt:parseDate value="${endHoursStr[1]}" var="endHours" pattern="HH:mm" />
                <c:if test="${userTimeIn ne null}">
                    <c:choose>
                        <c:when test="${userTimeIn le secondHalfTimeStr and userTimeOut ge endHours}">
                            <c:set var="present" value="${present + 0.5}"></c:set>
                        </c:when>
                        <c:when test="${fn:contains(shiftName, 'Night') && userTimeOut ge endHours}">
                            <c:set var="present" value="${present + 0.5}"></c:set>
                        </c:when>
                        <c:when test="${fn:contains(shiftName, 'Second') && userTimeOut ge endHours}">
                            <c:set var="present" value="${present + 0.5}"></c:set>
                        </c:when>

                        <c:when test="${fn:contains(leave1[0], 'AR')}">
                            <c:set var="ar" value="${ar + 0.5}"></c:set>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO') && !fn:contains(list[1], '?') 
                              && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                              && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                              && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay') && !fn:contains(list[1], 'TR')}">
                    <c:set var="ar" value="${ar + 0.5}"></c:set>
                </c:if>

            </c:if>

        </c:forEach>



        <c:forEach var="list" items="${map[employeeMasterList[4]]}">
            <c:if test="${fn:contains(list[1], 'WO')}">
                <c:set var="wO" value="${wO + 1}"></c:set>
            </c:if>
        </c:forEach>
        <c:forEach var="list" items="${map[employeeMasterList[4]]}">
            <c:if test="${fn:contains(list[1], '?') && !fn:contains(list[1], '`') && !fn:contains(list[1], 'AB')}">
                <c:set var="hl" value="${hl + 1}"></c:set>
            </c:if>
        </c:forEach>
        <c:set var="shortCount" value="0"></c:set>
        <c:forEach var="shortLeave" items="${map1[employeeMasterList[4]][1]}">
            <c:if test="${fn:contains(shortLeave, 'Short Leave')}">
                <c:set var="shortCount" value="${shortCount + 1}"></c:set>
            </c:if>
        </c:forEach>
        <c:set var="coff" value="0"></c:set>
        <c:forEach var="coffLeave" items="${map1[employeeMasterList[4]][1]}">
            <c:if test="${fn:contains(coffLeave, 'C Off Leave')}">
                <c:set var="coff" value="${coff + 1}"></c:set>
            </c:if>
        </c:forEach>
        <c:set var="shortL" value="${shortCount/2}"/>
        <c:set var="presentLeave" value="${present-shortL}"/>
        <tr>
            <td>${employeeMasterList[0]}</td>
            <td>${employeeMasterList[1]}</td>
            <td>${employeeMasterList[2]}</td>
            <td style="text-align: center">${employeeMasterList[3]}</td>
            <td>${presentLeave}</td>
            <td>${wO}</td>
            <td>${hl}</td>
            <td>${shortCount}</td>
            <td>${coff}</td>
            <td><table><tr><td>
                            <c:set var="casualLastCount" value="0"></c:set>
                            <c:forEach var="casualLastCountList" items="${map1[employeeMasterList[4]][2]}">
                                <c:if test="${fn:contains(casualLastCountList, '1 Casual Leave')}">
                                    <c:set var="casualLastCount" value="${casualLastCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(casualLastCountList, '0.5 Casual Leave')}">
                                    <c:set var="casualLastCount" value="${casualLastCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${casualLastCount}
                        </td><td>
                            <c:set var="casualCurrentCount" value="0"></c:set>
                            <c:forEach var="casualCurrentCountList" items="${map1[employeeMasterList[4]][1]}">
                                <c:if test="${fn:contains(casualCurrentCountList, '1 Casual Leave')}">
                                    <c:set var="casualCurrentCount" value="${casualCurrentCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(casualCurrentCountList, '0.5 Casual Leave')}">
                                    <c:set var="casualCurrentCount" value="${casualCurrentCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${casualCurrentCount}
                        </td></tr></table></td>
            <td><table><tr><td>
                            <c:set var="sickLastCount" value="0"></c:set>
                            <c:forEach var="sickLastCountList" items="${map1[employeeMasterList[4]][2]}">
                                <c:if test="${fn:contains(sickLastCountList, '1 Sick Leave')}">
                                    <c:set var="sickLastCount" value="${sickLastCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(sickLastCountList, '0.5 Sick Leave')}">
                                    <c:set var="sickLastCount" value="${sickLastCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${sickLastCount}
                        </td><td>

                            <c:set var="sickCurrentCount" value="0"></c:set>
                            <c:forEach var="sickCurrentCountList" items="${map1[employeeMasterList[4]][1]}">
                                <c:if test="${fn:contains(sickCurrentCountList, '1 Sick Leave')}">
                                    <c:set var="sickCurrentCount" value="${sickCurrentCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(sickCurrentCountList, '0.5 Sick Leave')}">
                                    <c:set var="sickCurrentCount" value="${sickCurrentCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${sickCurrentCount}
                        </td></tr></table></td>
            <td><table><tr><td>
                            <c:set var="privilegeLastCount" value="0"></c:set>
                            <c:forEach var="privilegeLastCountList" items="${map1[employeeMasterList[4]][2]}">
                                <c:if test="${fn:contains(privilegeLastCountList, '1 Privilege Leave')}">
                                    <c:set var="privilegeLastCount" value="${privilegeLastCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(privilegeLastCountList, '0.5 Privilege Leave')}">
                                    <c:set var="privilegeLastCount" value="${privilegeLastCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${privilegeLastCount}

                        </td><td>
                            <c:set var="privilegeCurrentCount" value="0"></c:set>
                            <c:forEach var="privilegeCurrentCountList" items="${map1[employeeMasterList[4]][1]}">
                                <c:if test="${fn:contains(privilegeCurrentCountList, '1 Privilege Leave')}">
                                    <c:set var="privilegeCurrentCount" value="${privilegeCurrentCount + 1}"></c:set>
                                </c:if>
                                <c:if test="${fn:contains(privilegeCurrentCountList, '0.5 Privilege Leave')}">
                                    <c:set var="privilegeCurrentCount" value="${privilegeCurrentCount + 0.5}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${privilegeCurrentCount}
                        </td></tr></table></td>
            <td>
                <c:set var="paternityCount" value="0"></c:set>
                <c:forEach var="paternityCountList" items="${map1[employeeMasterList[4]][1]}">
                    <c:if test="${fn:contains(paternityCountList, '1 Paternity Leave')}">
                        <c:set var="paternityCount" value="${paternityCount + 1}"></c:set>
                    </c:if>
                    <c:if test="${fn:contains(paternityCountList, '0.5 Paternity Leave')}">
                        <c:set var="paternityCount" value="${paternityCount + 0.5}"></c:set>
                    </c:if>
                </c:forEach>
                ${paternityCount}
            </td>
            <td>
                <c:set var="maternityCount" value="0"></c:set>
                <c:forEach var="maternityCountList" items="${map1[employeeMasterList[4]][1]}">
                    <c:if test="${fn:contains(maternityCountList, '1 Maternity Leave')}">
                        <c:set var="maternityCount" value="${maternityCount + 1}"></c:set>
                    </c:if>
                    <c:if test="${fn:contains(maternityCountList, '0.5 Paternity Leave')}">
                        <c:set var="maternityCount" value="${maternityCount + 0.5}"></c:set>
                    </c:if>
                </c:forEach>
                ${maternityCount}
            </td>
            <td><table><tr><td>${map1[employeeMasterList[4]][4][0]}</td><td>${ar}</td></tr></table></td>
            <td><table><tr><td>
                            <c:set var="travelLastMonth" value="0"></c:set>
                            <c:forEach var="travelPreviousMonth" items="${map1[employeeMasterList[4]][5]}">
                                <c:if test="${fn:contains(travelPreviousMonth, '1')}">
                                    <c:set var="travelLastMonth" value="${travelLastMonth + 1}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${travelLastMonth}
                        </td>
                        <td> <c:set var="travelcurMonth" value="0"></c:set>
                            <c:forEach var="travelCurrentMonth" items="${map1[employeeMasterList[4]][6]}">
                                <c:if test="${fn:contains(travelCurrentMonth, '1')}">
                                    <c:set var="travelcurMonth" value="${travelcurMonth + 1}"></c:set>
                                </c:if>
                            </c:forEach>
                            ${travelcurMonth}
                        </td></tr></table></td>
            <td>${casualLastCount+sickLastCount+privilegeLastCount+travelLastMonth+map1[employeeMasterList[4]][4][0]}</td>
            <td>${presentLeave+wO+map1[employeeMasterList[4]][0][0]+shortCount+coff+casualCurrentCount+sickCurrentCount
                  +privilegeCurrentCount+paternityCount+maternityCount+ar+travelcurMonth}</td>
            <td>
                <c:set var="lwp" value="${(fn:length(map1[employeeMasterList[4]][6]))-(presentLeave+wO+map1[employeeMasterList[4]][0][0]+shortCount+coff+casualLastCount+casualCurrentCount+sickLastCount+sickCurrentCount
                                          +privilegeLastCount+privilegeCurrentCount+paternityCount+maternityCount+map1[employeeMasterList[4]][4][0]+ar+travelLastMonth+travelcurMonth)}"></c:set>

                ${lwp}</td>
            <td>${fn:length(map1[employeeMasterList[4]][6])}</td>
        </tr>

    </c:forEach>
</tbody>
</table>
<%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>
