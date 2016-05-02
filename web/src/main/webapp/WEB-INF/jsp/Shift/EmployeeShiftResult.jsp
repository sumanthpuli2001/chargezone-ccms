<%-- 
    Document   : EmployeeShiftResult
    Created on : Feb 20, 2016, 12:12:17 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Result</title>
    </head>
    <body>
        <div class="content-wrapper">
              <section class="content-header">
                <h1>Employee Daily Attendance Information</h1>
            </section>
         <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                         <c:set var="absent" value="0"></c:set>
                                                            <c:set var="present" value="0"></c:set>
                                                              <c:forEach var="employeeMasterList" items="${empDetail}">
                                                                   <%--<c:choose>--%>
                                                                         <%--<c:when test="${empty map[employeeMasterList[38]]}">--%>

                                                                         <%--</c:when>--%>
                                                         <%--<c:otherwise>--%>
                                                         <div class="table table-bordered table-responsive">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <!--<div><h3>Employee Daily Attendance Information</h3></div>-->
                                        <tr>
                                            <td></td>
                                        <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                            <th>${list[0]}</th>
                                            </c:forEach>
                                    </tr>
                                    <tr>
                                        <th>Shift Name</th>

                                        <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                            <c:if test="${fn:contains(list[1], '`')}">
                                                <c:set var="string1" value="${fn:split(list[1], '`')}"/>
                                                <c:set var="string1" value="${fn:split(string1[1], '!')}"/>
                                                <%--<c:set var="string1" value="${fn:split(string1, 'SH')}"/>--%>

                                                <th>${string1[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '`')}">
                                                <th>-</th>
                                                </c:if>
                                            </c:forEach>
                                    </tr>
                                    <tr>
                                        <th>First In</th>

                                        <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                            <c:if test="${fn:contains(list[1], '-TO-')}">
                                                <c:set var="string2" value="${fn:split(list[1], '-TO-')}"/>
                                                <th>${string2[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '-TO-')}">
                                                <th style="color: red;">${list[1]}</th>
                                                </c:if>



                                        </c:forEach>
                                    </tr>
                                    <tr>
                                        <th>Last Out</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">

                                            <%--<c:set var="string5" value="${fn:join(list[1], 'To ')}"/>--%>

                                            <c:if test="${fn:contains(list[1], '-TO-')}">
                                                <c:set var="string3" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:set var="string3" value="${fn:split(string3[1], '`')}"/>
                                                <th>${string3[0]}</th>
                                                </c:if>
                                                <c:if test="${!fn:contains(list[1], '-TO-')}">
                                                <th>-</th>
                                                </c:if>
                                            </c:forEach>

                                    </tr>
                                    <tr>
                                        <th>1st Half</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">
                                                <%--<c:set var="string5" value="${fn:join(list[1], 'To ')}"/>--%>

                                            <c:if test="${fn:contains(list[1], '!')}">
                                                <c:set var="firstIn" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:set var="string6" value="${fn:split(list[1], '!')}"/>
                                                <c:set var="string6" value="${fn:split(string6[1], '@')}"/>
                                                <c:set var="string7" value="${fn:split(list[1], '@')}"/>
                                                <c:set var="string7" value="${fn:split(string7[1], '#')}"/>
                                                <fmt:parseDate value="01/01/2016 ${firstIn[0]}" var="firstIn" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:parseDate value="01/01/2016 ${string6[0]}" var="string6" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:parseDate value="01/01/2016 ${string7[0]}" var="string7" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:formatDate var="finaldate1" value="${firstIn}" pattern="HH:mm" />
                                                <fmt:formatDate var="startdate2"  value="${string6}" pattern="HH:mm" />
                                                <fmt:formatDate  var="enddate3" value="${string7}" pattern="HH:mm" />
                                                <c:choose>
                                                    <c:when test="${finaldate1 ge startdate2 && finaldate1 le enddate3}">
                                                        <th style="color: green;">PR</th>
                                                            <c:set var="present" value="${present + 0.5}"></c:set>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <th style="color: red;">AB</th>
                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                            <c:if test="${!fn:contains(list[1], '!')}">
                                                <!--<th>-</th>-->
                                                <!--18 feb 2016-->
                                                <c:set var="string2" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:if test="${string2[0] eq 'AB'}">

                                                    <th style="color: red;">${string2[0]}
                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>

                                                        </th>
                                                </c:if>
                                                <c:if test="${string2[0] ne 'AB'}">

                                                    <th>-</th>
                                                    </c:if>
                                                </c:if>
                                            </c:forEach>

                                    </tr>
                                    <tr>
                                        <th>2nd Half</th>
                                            <c:forEach var="list" items="${map[employeeMasterList[38]]}">

                                            <%--<c:set var="string5" value="${fn:join(list[1], 'To ')}"/>--%>

                                            <c:if test="${fn:contains(list[1], '#')}">
                                                <c:set var="firstIn1" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:set var="string33" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:set var="string33" value="${fn:split(string33[1], '`')}"/>
                                                <c:set var="string8" value="${fn:split(list[1], '#')}"/>
                                                <c:set var="string8" value="${fn:split(string8[1], '$')}"/>
                                                <c:set var="string9" value="${fn:split(list[1], '$')}"/>
                                                <fmt:parseDate value="01/01/2016 ${string33[0]}" var="string33" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:parseDate value="01/01/2016 ${firstIn1[0]}" var="firstIn1" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:parseDate value="01/01/2016 ${string8[0]}" var="string8" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:parseDate value="01/01/2016 ${string9[1]}" var="string9" pattern="dd/MM/yyyy HH:mm" />
                                                <fmt:formatDate var="finaldate11" value="${firstIn1}" pattern="HH:mm" />
                                                <fmt:formatDate var="fenddate11" value="${string33}" pattern="HH:mm" />
                                                <fmt:formatDate var="startdate22"  value="${string8}" pattern="HH:mm" />
                                                <fmt:formatDate  var="enddate33" value="${string9}" pattern="HH:mm" />
                                                <c:choose>
                                                    <c:when test="${fenddate11 ge enddate33}">
                                                        <th style="color: green;">PR</th>
                                                            <c:set var="present" value="${present + 0.5}"></c:set>

                                                    </c:when>
                                                    <c:otherwise>

                                                        <th style="color: red;">AB</th>
                                                            <c:set var="absent" value="${absent + 0.5}"></c:set>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                            <c:if test="${!fn:contains(list[1], '#')}">
                                                <!--<th>-</th>-->
                                                <!--18 feb 2016-->
                                                <c:set var="string2" value="${fn:split(list[1], '-TO-')}"/>
                                                <c:if test="${string2[0] eq 'AB'}">

                                                    <th style="color: red;">${string2[0]}
                                                        <c:set var="absent" value="${absent + 0.5}"></c:set>
                                                        </th>
                                                </c:if>
                                                <c:if test="${string2[0] ne 'AB'}">

                                                    <th>-</th>
                                                    </c:if>


                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                                        </table>
                                                             <table id="table_1" class="table-bordered table-striped table-hover" style="margin-top: 20px;margin-bottom: 20px;width: 30%" >
                                    <tr >
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th colspan="2">Day Count</th>
                                    </tr>
                                    <tr>
                                        <th style="color: green;">PR</th>
                                        <th style="color: red;">AB</th>
                                    </tr>
                                    <tr>
                                        <td style="color: green;" >${present}</td>
                                        <td style="color: red;" >${absent}</td>
                                    </tr>
                                    <tr  >
                                        <!--<td  ></td>-->
                                    </tr>

                        </tr>


                </table>
                                    </div>
                                         <%--</c:otherwise>--%>
                                       <%--</c:choose>--%>
                                        </c:forEach>
                                      </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>
                                    </div>

    </body>
            <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
