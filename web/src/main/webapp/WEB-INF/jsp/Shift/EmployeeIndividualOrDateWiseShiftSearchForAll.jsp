<%-- 
    Document   : EmployeeIndividualOrDateWiseShiftSearchForAll
    Created on : 10 Jan, 2019, 11:46:16 AM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Punch Detail</title>
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
        function showPunchData(date, id) {
            var path = 'attendanceRegularizationMaster.htm?act=showDateWisePunchDataOfAllEmployee&date=' + date + '&id=' + id;
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
            <h1>ALL EMPLOYEE PUNCH DATA </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="attendanceRegularizationMaster.htm?act=showOwnAttandanceOfAllEmployee" method="post" commandName="employeeAdvanceSearch"
                   name='form1' class="form-horizontal" role="form">
            <input type="hidden" name="id" id="id" value="${id}">

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div><button type="button" class="btn-primary"  onclick="window.history.back();" title="View">Back</button></div>
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
                                                        <c:set var="ptl" value="0"></c:set>
                                                        <c:set var="mtl" value="0"></c:set>
                                                        <c:set var="coff" value="0"></c:set>
                                                        <c:set var="lwp" value="0"></c:set>
                                                        <c:forEach var="employeeMasterList" items="${empDetail}">
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${empty map[employeeMasterList[38]]}">--%>

                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                            <div class="table table-bordered table-responsive">
                                                                <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
                                                                    <div><h3>Employee Daily Attendance Information</h3></div>
                                                                    <c:forEach var="list" items="${map[employeeMasterList[48]]}">
                                                                        <c:if test="${fn:contains(list[1], 'WO')}">
                                                                            <c:set var="wo" value="${wo + 1}"></c:set>
                                                                        </c:if>
                                                                    </c:forEach>
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
                                                                                    <c:if test="${fn:contains(list[1], 'Casual Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="cl" value="${(satMap[list[0]] eq 'AB') ? (cl + 0.5) : (cl + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Privilege Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="pl" value="${(satMap[list[0]] eq 'AB') ? (pl + 0.5) : (pl + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Sick Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="sl" value="${(satMap[list[0]] eq 'AB') ? (sl + 0.5) : (sl + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Maternity Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="mtl" value="${(satMap[list[0]] eq 'AB') ? (mtl + 0.5) : (mtl + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'Paternity Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="ptl" value="${(satMap[list[0]] eq 'AB') ? (ptl + 0.5) :(ptl + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${fn:contains(list[1], 'C Off Leave') && halfDayMap[list[0]] ne list[1]}}">
                                                                                        <c:set var="coff" value="${(satMap[list[0]] eq 'AB') ? (coff + 0.5) : (coff + 1)}"></c:set>
                                                                                    </c:if>
                                                                                    <c:if test="${(fn:contains(list[1], 'Leave Without Pay')|| fn:contains(woMap[list[0]], 'LWP')) && halfDayMap[list[0]] ne list[1]}">
                                                                                        <c:set var="lwp" value="${(satMap[list[0]] eq 'AB') ? (lwp + 0.5) : (lwp + 1)}"></c:set>
                                                                                    </c:if>

                                                                                <th style="text-align: center;">
                                                                                      <c:choose>
                                                                                        <c:when test="${list[1] eq 'WO'}">




                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Casual Leave')}">
                                                                                                <c:set var="cl" value="${cl + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Privilege Leave')}">
                                                                                                <c:set var="pl" value="${pl + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Sick Leave')}">
                                                                                                <c:set var="sl" value="${sl + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Maternity Leave')}">
                                                                                                <c:set var="mtl" value="${mtl + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Paternity Leave')}">
                                                                                                <c:set var="ptl" value="${ptl + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'C Off Leave')}">
                                                                                                <c:set var="coff" value="${coff + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>
                                                                                            <c:if test="${fn:contains(woMap[list[0]], 'Leave Without Pay') || fn:contains(woMap[list[0]], 'LWP')}">
                                                                                                <c:set var="lwp" value="${lwp + 1}"></c:set>
                                                                                                <c:set var="wo" value="${wo ne 0 ? (wo - 1) : 0}"></c:set>
                                                                                            </c:if>



                                                                                            ${woMap[list[0]]}
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:choose>
                                                                                                <c:when test="${halfDayMap[list[0]] eq list[1]}">-</c:when> 
                                                                                                <c:otherwise>${list[1]}</c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </th>
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
<!--<input type="text" value="${list[1]}">-->
                                                                            <c:if test="${fn:contains(list[1], '!')}">
                                                                                <c:set var="string2" value="${fn:split(list[1], '`')}"/>
                                                                                <c:set var="string2" value="${fn:split(string2[1], '!')}"/>
                                                                                <c:set var="string4" value="${fn:split(list[1], '!')}"/>
                                                                                <c:set var="string5" value="${fn:split(string4[1], '@')}"/>
                                                                                <fmt:parseDate value="${string5[0]}" var="lout" pattern="HH:mm" />
                                                                                <fmt:parseDate value="${string2[0]}" var="fin" pattern="HH:mm" />
<!--                                                                    <input type="text" value="${string5[0]}">
                                                                    <input type="text" value="${string2[0]}">-->
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
                                                                            <c:forEach var="firstHalfList" items="${firstHalfList}">
                                                                                <c:if test="${firstHalfList eq 'PR'}">
                                                                                <th style="color: green;text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq '-'}">
                                                                                <th style="color: green;text-align: center;">${firstHalfList}</th>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'SHL/P'}">
                                                                                <th style="color: green;text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="shl" value="${shl + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'SHL/A'}">
                                                                                <th style="color: red;text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="shlA" value="${shlA + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'AB'}">
                                                                                <th style="color: red;text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Casual Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="cl" value="${cl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Privilege Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="pl" value="${pl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Sick Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="sl" value="${sl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Maternity Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="mtl" value="${mtl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Paternity Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="ptl" value="${ptl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'C Off Leave'}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="coff" value="${coff + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'Leave Without Pay'  || fn:contains(woMap[list[0]], 'LWP')}">
                                                                                <th style="text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="lwp" value="${lwp + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${firstHalfList eq 'AR/P'}">
                                                                                <th style="color: blue;text-align: center;">${firstHalfList}</th>
                                                                                    <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                </c:if>

                                                                        </c:forEach>


                                                                    </tr>

                                                                    <tr>
                                                                        <th>2nd Half</th>
                                                                            <c:forEach var="secondHalfList" items="${secondHalfList}">
                                                                                <c:if test="${secondHalfList eq 'PR'}">
                                                                                <th style="color: green;text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="present" value="${present + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq '-'}">
                                                                                <th style="color: green;text-align: center;">${secondHalfList}</th>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'SHL/P'}">
                                                                                <th style="color: green;text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="shl" value="${shl + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'SHL/A'}">
                                                                                <th style="color: red;text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="shlA" value="${shlA + 1}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'AB'}">
                                                                                <th style="color: red;text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList.contains('Casual Leave')}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="cl" value="${cl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList.contains('Privilege Leave')}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="pl" value="${pl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList.contains('Sick Leave')}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="sl" value="${sl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'Maternity Leave'}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="mtl" value="${mtl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'Paternity Leave'}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="ptl" value="${ptl + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'C Off Leave'}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="coff" value="${coff + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'Leave Without Pay'  || fn:contains(woMap[list[0]], 'LWP')}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="lwp" value="${lwp + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'AR/P'}">
                                                                                <th style="color: blue;text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="ar" value="${ar + 0.5}"></c:set>
                                                                                </c:if>
                                                                                <c:if test="${secondHalfList eq 'WO'}">
                                                                                <th style="text-align: center;">${secondHalfList}</th>
                                                                                    <c:set var="wo" value="${wo + 0.5}"></c:set>
                                                                                </c:if>

                                                                        </c:forEach>

                                                                    </tr>
                                                                   
                                                                    <tr>
                                                                        <th>Break Hours</th>
                                                                            <c:forEach var="breakHour" items="${breakHour}">
                                                                            <th style="text-align: center;">${breakHour}</th>
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
                                                                            <th style="text-align: center;"><a onclick="showPunchData('${list[0]}', '${employeeMasterList[48]}');">View</a>
                                                                            </th>

                                                                        </c:forEach>
                                                                    </tr>
																	                                                                    
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
                                                                            <th style="color: green;text-align: center;padding:0px 20px 0px 20px;">PR</th>
                                                                            </c:if>
                                                                            <c:if test="${absent ne 0}">
                                                                            <th style="color: red;text-align: center;padding:0px 20px 0px 20px;">AB</th>
                                                                            </c:if>
                                                                            <c:if test="${wo ne 0}">
                                                                            <th style="text-align: center;padding:0px 20px 0px 20px;">WO</th>
                                                                            </c:if>
                                                                            <c:if test="${holiday ne 0}">
                                                                            <th style="text-align: center;padding:0px 20px 0px 20px;">Holiday</th>
                                                                            </c:if>
                                                                            <c:if test="${cl ne 0}">
                                                                            <th style="text-align: center;padding:0px 20px 0px 20px;">CL</th>
                                                                            </c:if>
                                                                            <c:if test="${sl ne 0}">
                                                                            <th style="text-align: center;padding:0px 20px 0px 20px;">SL</th>
                                                                            </c:if>
                                                                            <c:if test="${pl ne 0}">
                                                                            <th style="text-align: center;padding:0px 20px 0px 20px;">PL</th>
                                                                            </c:if>
                                                                            <c:if test="${shl ne 0}">
                                                                            <th style="color: green;text-align: center;padding:0px 20px 0px 20px;">SHL/P</th>
                                                                            </c:if>
                                                                            <c:if test="${shlA ne 0}">
                                                                            <th style="color: red;text-align: center;padding:0px 20px 0px 20px;">SHL/A</th>
                                                                            </c:if>
                                                                            <c:if test="${ar ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">AR/P</th>
                                                                            </c:if>
                                                                            <c:if test="${tr ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">TR</th>
                                                                            </c:if>
                                                                            <c:if test="${coff ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">C-OFF</th>
                                                                            </c:if>
                                                                            <c:if test="${ptl ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">PTL</th>
                                                                            </c:if>
                                                                            <c:if test="${mtl ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">MTL</th>
                                                                            </c:if>
                                                                            <c:if test="${lwp ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">LWP</th>
                                                                            </c:if>
                                                                            <c:if test="${countLateEntry gt 2}">
                                                                            <th style="color: red;text-align: center;padding:0px 20px 0px 20px;">Penalty</th>
                                                                            </c:if>
                                                                            <c:if test="${!empty totalPaidOverTime}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">OT Hours</th>
                                                                            </c:if>
                                                                            <c:if test="${!empty totalUnpaidOverTime}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">Unpaid OT Hours</th>
                                                                            </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <c:set var="shortL" value="${shl/2}"/>
                                                                        <c:if test="${present ne 0}">
                                                                            <td style="color: green;text-align: center;padding:0px 20px 0px 20px;">${present-shortL}</td>
                                                                        </c:if>
                                                                        <c:if test="${absent ne 0}">
                                                                            <td style="color: red;text-align: center;padding:0px 20px 0px 20px;" >${absent}</td>
                                                                        </c:if>
                                                                        <c:if test="${wo ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${wo}</td>
                                                                        </c:if>
                                                                        <c:if test="${holiday ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${holiday}</td>
                                                                        </c:if>
                                                                        <c:if test="${cl ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${cl}</td>
                                                                        </c:if>
                                                                        <c:if test="${sl ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${sl}</td>
                                                                        </c:if>
                                                                        <c:if test="${pl ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${pl}</td>
                                                                        </c:if>
                                                                        <c:if test="${shl ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${shl}</td>
                                                                        </c:if>
                                                                        <c:if test="${shlA ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${shlA}</td>
                                                                        </c:if>
                                                                        <c:if test="${ar ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${ar}</td>
                                                                        </c:if>
                                                                        <c:if test="${tr ne 0}">
                                                                            <td style="text-align: center;padding:0px 20px 0px 20px;">${tr}</td>
                                                                        </c:if>
                                                                        <c:if test="${coff ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${coff}</th>
                                                                            </c:if>
                                                                            <c:if test="${ptl ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${ptl}</th>
                                                                            </c:if>
                                                                            <c:if test="${mtl ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${mtl}</th>
                                                                            </c:if>
                                                                            <c:if test="${lwp ne 0}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${lwp}</th>
                                                                            </c:if>
                                                                            <c:if test="${!empty totalPenaltyHours && countLateEntry gt 2}">
                                                                            <th style="color: red;text-align: center;padding:0px 20px 0px 20px;">Rs. ${totalPenaltyHours}</th>
                                                                            </c:if>
                                                                            <c:if test="${!empty totalPaidOverTime}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${totalPaidOverTime}</th>
                                                                            </c:if>  
                                                                            <c:if test="${!empty totalUnpaidOverTime}">
                                                                            <th style="color: blue;text-align: center;padding:0px 20px 0px 20px;">${totalUnpaidOverTime}</th>
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
