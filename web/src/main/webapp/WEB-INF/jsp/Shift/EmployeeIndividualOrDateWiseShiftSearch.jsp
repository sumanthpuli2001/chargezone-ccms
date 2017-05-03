<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Data Search</title>
    </head>

    <script>
        function selectDropsDown11(val) {
            if (val == 'emp') {
                $('#employeeName').show();
                $('#zydexLocationIdDiv').hide();
                $('#levelIdDiv').hide();
                $('#departmentIdDiv').hide();

            } else {
                $('#employeeName').hide();
                $('#zydexLocationIdDiv').show();
                $('#levelIdDiv').show();
                $('#departmentIdDiv').show();

            }
        }
    </script>
    <script>
        function showPunchData(date) {
            var path = 'attendanceRegularizationMaster.htm?act=showDateWisePunchData&date=' + date;
            popupWindow = window.open(path, 'popUpWindow', 'height=300,width=500,left=500%,top=100%,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no')

//             window.location = 'attendanceRegularizationMaster.htm?act=showDateWisePunchData&date=' + date;
        }
    </script>

    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Advance Search: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="attendanceRegularizationMaster.htm?act=showOwnAttandance" method="post" commandName="employeeAdvanceSearch"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">



                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6" id="zydexLocationIdDiv" style="display: none;">
                                                    <label>Zydex Location:</label>
                                                    <input type="text" id="zydexLocationId" name="zydexLocationId" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6" id="levelIdDiv" style="display: none;">
                                                    <label>Level Name:</label>
                                                    <input type="text" id="levelId" name="levelId" class="form-control">
                                                </div>

                                                <div class="col-sm-6" id="departmentIdDiv" style="display: none;">
                                                    <label>Department Name:</label>
                                                    <input type="text" id="departmentId" name="departmentId" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">

                                                <div class="col-sm-6">
                                                    <label>Start Date<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="inDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_form:input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="outDateTime"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class=" col-sm-12" >
                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" >SEARCH</button>
                                                    </div>
                                                </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                            <c:choose>
                                                <c:when test="${empty empDetail}">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record."></c:out>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                </c:when>
                                                <c:otherwise>

                                                    <div class="table table-bordered">
                                                        <c:set var="absent" value="0"></c:set>
                                                        <c:set var="present" value="0"></c:set>
                                                        <c:set var="wo" value="0"></c:set>
                                                        <c:set var="holiday" value="0"></c:set>
                                                        <c:set var="shl" value="0"></c:set>
                                                        <c:set var="shlA" value="0"></c:set>
                                                        <c:set var="cl" value="0"></c:set>
                                                        <c:set var="sl" value="0"></c:set>
                                                        <c:set var="pl" value="0"></c:set>
                                                        <c:set var="ar" value="0"></c:set>
                                                        <c:set var="tr" value="0"></c:set>
                                                        <c:forEach var="employeeMasterList" items="${empDetail}">
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${empty map[employeeMasterList[38]]}">--%>

                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                            <div class="table table-bordered table-responsive">
                                                                <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
                                                                    <div><h3>Employee Daily Attendance Information</h3></div>
                                                                    <tr>
                                                                        <td></td>
                                                                        <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                            <th style="text-align: center;">${list[0]}</th>
                                                                            </c:forEach>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Shift Name</th>
                                                                            <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                                <c:if test="${fn:contains(list[1], ' # ')}">
                                                                                    <c:set var="string1" value="${fn:split(list[1], '#')}"/>
                                                                                    <c:set var="string1" value="${fn:split(string1[1], '$')}"/>
                                                                                <th style="text-align: center;">${string1[0]}</th>
                                                                                </c:if>
                                                                                <c:if test="${!fn:contains(list[1], '`')}">
                                                                                <th style="text-align: center;">-</th>
                                                                                </c:if>
                                                                            </c:forEach>

                                                                    </tr>
                                                                    <tr>
                                                                        <th>First In</th>

                                                                        <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                            <c:if test="${fn:contains(list[1], '`') && !fn:contains(list[1], '?')}">
                                                                                <c:set var="string2" value="${fn:split(list[1], '`')}"/>
                                                                                <c:set var="string2" value="${fn:split(string2[1], '!')}"/>
                                                                                <th style="text-align: center;">${string2[0]}</th>
                                                                                </c:if>
                                                                                <c:if test="${!fn:contains(list[1], '`') && !fn:contains(list[1], '?') && !fn:contains(list[1], 'AB') && !fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AR')}">
                                                                                    <c:if test="${fn:contains(list[1], 'Casual Leave')}">
                                                                                        <c:set var="cl" value="${cl + 1}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Privilege Leave')}">
                                                                                        <c:set var="pl" value="${pl + 1}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Sick Leave')}">
                                                                                        <c:set var="sl" value="${sl + 1}"></c:set>
                                                                                    </c:if>

                                                                                <th style="text-align: center;">${list[1]}</th>
                                                                                </c:if>
                                                                                <c:if test="${fn:contains(list[1], '?') && !fn:contains(list[1], '`') && !fn:contains(list[1], 'AB') && !fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AR')}">
                                                                                    <c:set var="hostring" value="${fn:split(list[1], '?')}"/>
                                                                                <th style="text-align: center;">${hostring[0]}</th>
                                                                                    <c:set var="holiday" value="${holiday + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AB') && !fn:contains(list[1], '?') && !fn:contains(list[1], '`') && !fn:contains(list[1], 'AR')}">
                                                                                <th style="text-align: center;color: blue;" >${list[1]}</th>
                                                                                    <c:set var="tr" value="${tr + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${fn:contains(list[1], 'AB') && !fn:contains(list[1], '?') && !fn:contains(list[1], '`') && !fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AR')}">
                                                                                <th style="text-align: center;">-</th>
                                                                                </c:if>
                                                                                <c:if test="${list[1] eq 'AR'}">
                                                                                <th style="text-align: center;">-</th>
                                                                                </c:if>

                                                                        </c:forEach>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Last Out</th>
                                                                            <c:forEach var="list" items="${map[employeeMasterList[48]]}">

                                                                            <%--<c:set var="string5" value="${fn:join(list[1], 'To ')}"/>--%>

                                                                            <c:if test="${fn:contains(list[1], '!')}">
                                                                                <c:set var="string2" value="${fn:split(list[1], '`')}"/>
                                                                                <c:set var="string2" value="${fn:split(string2[1], '!')}"/>
                                                                                <c:set var="string4" value="${fn:split(list[1], '!')}"/>
                                                                                <c:set var="string5" value="${fn:split(string4[1], '@')}"/>
                                                                                <fmt:parseDate value="${string5[0]}" var="lout" pattern="HH:mm" />
                                                                                <fmt:parseDate value="${string2[0]}" var="fin" pattern="HH:mm" />
                                                                                <c:choose>
                                                                                    <c:when test="${lout eq fin}">
                                                                                        <th style="text-align: center;">-</th>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                        <th style="text-align: center;">${string5[0]}</th>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </c:if>
                                                                                <c:if test="${!fn:contains(list[1], '@')}">
                                                                                <th style="text-align: center;">-</th>
                                                                                </c:if>

                                                                        </c:forEach>

                                                                    </tr>
                                                                    <tr>
                                                                        <th>1st Half</th>
                                                                            <c:set var="firstHalfVal" value="0"></c:set>
                                                                            <c:set var="counter" value="0"></c:set>
                                                                            <c:set var="firstCounter" value="0"></c:set>
                                                                            <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                                <c:if test="${fn:contains(list[1], 'fullday')}">

                                                                                <c:set var="counter" value="${counter + 1}"></c:set>
                                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                    <th style="color: green;text-align: center;">PR</th>
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
                                                                                                <th style="color: green;text-align: center;">PR</th>
                                                                                            </c:when>
                                                                                            <c:when test="${leave1[0] ne null and !fn:contains(leave1[0], 'Short Leave')}">
                                                                                                <c:choose>

                                                                                                <c:when test="${userTimeIn le LateHours and userTimeOut ge endHours and firstCounter le 31}">

                                                                                                    <c:set var="firstCounter" value="${firstCounter +1}"></c:set>
                                                                                                    <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                                        <th style="color: green;text-align: center;">PR</th>
                                                                                                    </c:when>
                                                                                                    <c:when test="${fn:contains(leave1[0], 'AR')}">
                                                                                                    <th style="color: blue;text-align: center;">AR/P</th>
                                                                                                        <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>

                                                                                                    <c:if test="${fn:contains(leave1[0], 'AB')}">
                                                                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                                        <th style="color: red;text-align: center;">${leave1[0]}</th>
                                                                                                        </c:if>
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
                                                                                                                <th style="color: green;text-align: center;">SHL/P</th>
                                                                                                                    <c:set var="shl" value="${shl + 1}"></c:set>
                                                                                                                </c:when>
                                                                                                                <c:when  test="${userTimeIn ge endHours}">

                                                                                                                <th style="color: red;text-align: center;">SHL/A</th>
                                                                                                                    <c:set var="shlA" value="${shlA + 1}"></c:set>
                                                                                                                </c:when>
                                                                                                                <c:otherwise>
                                                                                                                <th style="color: red;text-align: center;">AB</th>
                                                                                                                </c:otherwise>
                                                                                                            </c:choose>
                                                                                                        </c:when>
                                                                                                        <c:when test="${userTimeIn le LateHours and userTimeOut ge endHours and firstCounter le 31}">
                                                                                                            <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                                            <c:set var="firstCounter" value="${firstCounter +1}"></c:set>
                                                                                                            <th style="color: green;text-align: center;">PR</th>
                                                                                                        </c:when>
                                                                                                        <c:when  test="${fn:contains(leave1[0], '~ AR')}">
                                                                                                        <th style="color: blue;text-align: center;">AR/P</th>
                                                                                                            <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                                        </c:when>
                                                                                                        <c:otherwise>
                                                                                                        <th style="color: red;text-align: center;">AB</th>
                                                                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                                        </c:otherwise>
                                                                                                    </c:choose>
                                                                                                </c:if>
                                                                                            </c:when>
                                                                                            <c:when test="${null ne leave1[0] &&  !fn:contains(leave1[0], 'AB')}">
                                                                                                <c:if test="${fn:contains(leave1[0], 'Casual Leave')}">
                                                                                                    <c:set var="cl" value="${cl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                                <c:if test="${fn:contains(leave1[0], 'Privilege Leave')}">
                                                                                                    <c:set var="pl" value="${pl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                                <c:if test="${fn:contains(leave1[0], 'Sick Leave')}">
                                                                                                    <c:set var="sl" value="${sl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                            <th style="text-align: center;">${leave1[0]}</th>
                                                                                            </c:when>
                                                                                            <c:when test="${fn:contains(leave1[0], 'AB')}">
                                                                                            <th style="text-align: center;">-</th>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                            <th style="color: red;text-align: center;">AB</th>
                                                                                                <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </c:if>
                                                                                    <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO')  && !fn:contains(list[1], '?') 
                                                                                                  && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                                                                                                  && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                                                                                                  && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay')}">
                                                                                    <th style="color: red;text-align: center;">AB</th>
                                                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO')  && !fn:contains(list[1], '?') 
                                                                                                  && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                                                                                                  && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                                                                                                  && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay')}">
                                                                                    <th style="color: blue;text-align: center;">AR/P</th>
                                                                                        <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${list[1] == 'TR' || list[1] == 'WO' || fn:contains(list[1], '?') ||
                                                                                                  list[1] == 'Sick Leave' || list[1] == 'Casual Leave'
                                                                                                  || list[1] == 'Privilege Leave' || list[1] == 'Paternity Leave'
                                                                                                  || list[1] == 'Maternity Leave' || list[1] == 'Leave Without Pay' }">
                                                                                    <th style="text-align: center;">-</th>

                                                                                </c:if>
                                                                            </c:if>

                                                                        </c:forEach>

                                                                    </tr>

                                                                    <tr>
                                                                        <th>2nd Half</th>
                                                                            <c:forEach var="list" items="${map[employeeMasterList[48]]}">

                                                                            <c:if test="${fn:contains(list[1], ' # ')}">
                                                                                <c:set var="string1" value="${fn:split(list[1], '#')}"/>
                                                                                <c:set var="string1" value="${fn:split(string1[1], '$')}"/>
                                                                                <c:set var="shiftName" value="${fn:trim(string1[0])}"/>

                                                                            </c:if>

                                                                            <c:if test="${fn:contains(list[1], 'fullday')}">
                                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                    <th style="color: green;text-align: center;">PR</th>
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

                                                                                            <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                                <th style="color: green;text-align: center;">PR</th>
                                                                                            </c:when>
                                                                                            <c:when test="${fn:contains(shiftName, 'Night') && userTimeOut ge endHours}">
                                                                                                <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                                <th style="color: green;text-align: center;">PR</th>
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
                                                                                                                <th style="color: green;text-align: center;">SHL/P</th>
                                                                                                                    <c:set var="shl" value="${shl + 1}"></c:set>
                                                                                                                </c:when>
                                                                                                                <c:when  test="${userTimeOut le secondHalfTimeStr}">
                                                                                                                <th style="color: red;text-align: center;">SHL/A</th>
                                                                                                                    <c:set var="shlA" value="${shlA + 1}"></c:set>
                                                                                                                </c:when>


                                                                                                            <c:otherwise>
                                                                                                                <th style="color: red;text-align: center;">AB</th>
                                                                                                                    <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                                                </c:otherwise>
                                                                                                            </c:choose>
                                                                                                        </c:when>
                                                                                                        <c:when  test="${fn:contains(leave1[0], '~ AR')}">
                                                                                                        <th style="color: blue;text-align: center;">AR/P</th>
                                                                                                            <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                                        </c:when>
                                                                                                        <c:otherwise>
                                                                                                        <th style="color: red;text-align: center;">AB</th>
                                                                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                                        </c:otherwise>
                                                                                                    </c:choose>
                                                                                                </c:if>
                                                                                            </c:when>
                                                                                            <c:when test="${null ne leave1[0] &&  !fn:contains(leave1[0], 'AB') && !fn:contains(leave1[0], 'AR')}">
                                                                                                <c:if test="${fn:contains(leave1[0], 'Casual Leave')}">
                                                                                                    <c:set var="cl" value="${cl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                                <c:if test="${fn:contains(leave1[0], 'Privilege Leave')}">
                                                                                                    <c:set var="pl" value="${pl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                                <c:if test="${fn:contains(leave1[0], 'Sick Leave')}">
                                                                                                    <c:set var="sl" value="${sl + 0.5}"></c:set>
                                                                                                </c:if>
                                                                                            <th style="text-align: center;">${leave1[0]}</th>
                                                                                            </c:when>
                                                                                            <c:when test="${fn:contains(leave1[0], 'AR')}">
                                                                                            <th style="color: blue;text-align: center;">AR/P</th>
                                                                                                <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                            </c:when>
                                                                                            <c:when test="${fn:contains(leave1[0], 'AB')}">
                                                                                            <th style="color: red;text-align: center;">${leave1[0]}</th>
                                                                                                <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                            </c:when>

                                                                                        <c:otherwise>
                                                                                            <th style="color: red;text-align: center;">AB</th>
                                                                                                <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </c:if>
                                                                                    <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && !fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO') && !fn:contains(list[1], '?') 
                                                                                                  && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                                                                                                  && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                                                                                                  && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay')}">
                                                                                    <th style="color: red;text-align: center;">AB</th>
                                                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${userTimeIn eq null && !fn:contains(list[1], 'TR') && fn:contains(list[1], 'AR') && !fn:contains(list[1], 'WO') && !fn:contains(list[1], '?') 
                                                                                                  && !fn:contains(list[1], 'Sick Leave') && !fn:contains(list[1], 'Casual Leave')
                                                                                                  && !fn:contains(list[1], 'Privilege Leave') && !fn:contains(list[1], 'Paternity Leave')
                                                                                                  && !fn:contains(list[1], 'Maternity Leave') && !fn:contains(list[1], 'Leave Without Pay')}">
                                                                                    <th style="color: blue;text-align: center;">AR/P</th>
                                                                                        <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${list[1] == 'TR' || list[1] == 'WO' || fn:contains(list[1], '?') ||
                                                                                                  list[1] == 'Sick Leave' || list[1] == 'Casual Leave'
                                                                                                  || list[1] == 'Privilege Leave' || list[1] == 'Paternity Leave'
                                                                                                  || list[1] == 'Maternity Leave' || list[1] == 'Leave Without Pay' }">
                                                                                    <th style="text-align: center;">-</th>
                                                                                    </c:if>

                                                                            </c:if>

                                                                        </c:forEach>

                                                                    </tr>
                                                                    <tr>
                                                                        <th>Working Hour</th>
                                                                            <c:forEach var="workingHour" items="${workingHour}">
                                                                            <th style="text-align: center;">${workingHour}</th>
                                                                            </c:forEach>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>View All Punch</th>
                                                                            <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                            <th style="text-align: center;"><a onclick="showPunchData('${list[0]}');">View</a>
                                                                            </th>

                                                                        </c:forEach>
                                                                    </tr>
                                                                    <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                        <c:if test="${fn:contains(list[1], 'WO')}">
                                                                            <c:set var="wo" value="${wo + 1}"></c:set>
                                                                        </c:if>
                                                                    </c:forEach>

                                                                </table>
                                                                <table id="table_1" class="table-bordered table-striped table-hover"
                                                                       style="margin-top: 20px;margin-bottom: 20px;margin-left: 5px;width: 25%" >
                                                                    <tr >
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th colspan="2">Day Count</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:if test="${present ne 0}">
                                                                            <th style="color: green;text-align: center;">PR</th>
                                                                            </c:if>
                                                                            <c:if test="${absent ne 0}">
                                                                            <th style="color: red;text-align: center;">AB</th>
                                                                            </c:if>
                                                                            <c:if test="${wo ne 0}">
                                                                            <th style="text-align: center;">WO</th>
                                                                            </c:if>
                                                                            <c:if test="${holiday ne 0}">
                                                                            <th style="text-align: center;">Holiday</th>
                                                                            </c:if>
                                                                            <c:if test="${cl ne 0}">
                                                                            <th style="text-align: center;">CL</th>
                                                                            </c:if>
                                                                            <c:if test="${sl ne 0}">
                                                                            <th style="text-align: center;">SL</th>
                                                                            </c:if>
                                                                            <c:if test="${pl ne 0}">
                                                                            <th style="text-align: center;">PL</th>
                                                                            </c:if>
                                                                            <c:if test="${shl ne 0}">
                                                                            <th style="color: green;text-align: center;">SHL/P</th>
                                                                            </c:if>
                                                                            <c:if test="${shlA ne 0}">
                                                                            <th style="color: red;text-align: center;">SHL/A</th>
                                                                            </c:if>
                                                                            <c:if test="${ar ne 0}">
                                                                            <th style="color: blue;text-align: center;">AR/P</th>
                                                                            </c:if>
                                                                            <c:if test="${tr ne 0}">
                                                                            <th style="color: blue;text-align: center;">TR</th>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:set var="shortL" value="${shl/2}"/>
                                                                        <c:if test="${present ne 0}">
                                                                            <td style="color: green;text-align: center;" >${present-shortL}</td>
                                                                        </c:if>
                                                                        <c:if test="${absent ne 0}">
                                                                            <td style="color: red;text-align: center;" >${absent}</td>
                                                                        </c:if>
                                                                        <c:if test="${wo ne 0}">
                                                                            <td style="text-align: center;">${wo}</td>
                                                                        </c:if>
                                                                        <c:if test="${holiday ne 0}">
                                                                            <td style="text-align: center;">${holiday}</td>
                                                                        </c:if>
                                                                        <c:if test="${cl ne 0}">
                                                                            <td style="text-align: center;">${cl}</td>
                                                                        </c:if>
                                                                        <c:if test="${sl ne 0}">
                                                                            <td style="text-align: center;">${sl}</td>
                                                                        </c:if>
                                                                        <c:if test="${pl ne 0}">
                                                                            <td style="text-align: center;">${pl}</td>
                                                                        </c:if>
                                                                        <c:if test="${shl ne 0}">
                                                                            <td style="text-align: center;">${shl}</td>
                                                                        </c:if>
                                                                        <c:if test="${shlA ne 0}">
                                                                            <td style="text-align: center;">${shlA}</td>
                                                                        </c:if>
                                                                        <c:if test="${ar ne 0}">
                                                                            <td style="text-align: center;">${ar}</td>
                                                                        </c:if>
                                                                        <c:if test="${tr ne 0}">
                                                                            <td style="text-align: center;">${tr}</td>
                                                                        </c:if>

                                                                    </tr>
                                                                    <tr  >
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                            <%--</c:otherwise>--%>
                                                            <%--</c:choose>--%>
                                                        </c:forEach>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->


                                <!--<div id="myModal" class="modal fade" role="dialog">
                                                                                                            <div class="modal-dialog">

                                                                                                                 Modal content
                                                                                                                <div class="modal-content">
                                                                                                                    <div class="modal-header">
                                                                                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                                                                        <h4 class="modal-title">Modal Header</h4>
                                                                                                                    </div>
                                                                                                                    <div class="modal-body">
                                                                                                                    </div>
                                                                                                                    <div class="modal-footer">
                                                                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                                                                    </div>
                                                                                                                </div>

                                                                                                            </div>
                                                                                                        </div>-->


                                <!--Test-->

                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
        //language:  'fr',         weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
                forceParse: 0,
                endDate: new Date()
        });</script>

    <script>
                jQuery.noConflict();
                jQuery(document).ready(function () {
        jQuery("#employeeMasterId").tokenInput(${list}, {
            preventDuplicates: true,
            noResultsText: "No Result",
                tokenLimit: "1",
                    searchingText: "Searching ... .. .",
                    });
        });
    </script>
    <script>
                jQuery.noConflict();
                jQuery(document).ready(function () {
        jQuery("#zydexLocationId").tokenInput(${zydexLocationList}, {
            preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                    searchingText: "Searching ... .. .",
                    });
        });
    </script>
    <script>
        jQuery.noConflict();
                jQuery(document).ready(function () {
        jQuery("#levelId").tokenInput(${levelList}, {
                preventDuplicates: true,
            noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('#selecctall').on('ifChecked', function (event) {
            //        if ($('.checkAll').filter(':checked').length == $('.check').length) {
            $('.checkbox1').iCheck('check');
            //        }
        });
        $('#selecctall').on('ifUnchecked', function (event) {
            $('.checkbox1').iCheck('uncheck');
        });</script>
</html>
