<%--
    Document   : ShiftCreate
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Organizational chart</title>
        <script>
            function viewEmployeeDetail(employeeId, userId) {
                window.location = "employeeMaster.htm?act=getUserDetail&id=" + employeeId + "&userid=" + userId;
            }
        </script>
    </head>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Chart: </h1>
        </section>

        <section class="content">
            <div class="row">

                <div class="form-group">
                    <div class="col-sm-6"  style="text-align: left">
                        <input type="button" style="text-align: center;" value="GO UP" class="btn btn-primary" onclick="window.history.back();">
                    </div>
                    <div class="col-sm-6"  style="text-align: right">
                        <input type="button" style="text-align: center;" value="GO TO TOP" class="btn btn-primary" onclick="window.location = 'employeeMaster.htm?act=viewAllSubordinate'">
                    </div>
                </div>
            </div>


            <div class="jOrgChart">
                <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                    <tbody>

                        <tr class="node-cells">
                            <c:forEach var="ceoList" items="${mdValList}">
                                <td class="node-container" colspan="2">
                                        <table cellpadding="0" cellspacing="0" border="0">
                                            <tbody>
                                                <tr class="node-cells">
                                                    <td class="node-cell" style="width: 100px" colspan="2" onclick="window.location.href = 'employeeMaster.htm?act=viewEmployeeSubordinate&id=' +${ceoList[0]}">
                                                        <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoList[2]} &#13; Department: ${ceoList[3]} &#13; Designation: ${ceoList[4]} &#13;">
                                                            <img src="${ceoList[5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                            <span class="box-title" style="font-size: 105%;color: black">${ceoList[2]}</span>
                                                        </div>
                                                    </td></tr>
                                            </tbody>
                                        </table>
                                    </td>
                            </c:forEach>
                        </tr>

                        <c:if test="${!empty subordinateValListofList}">
                            <tr>
                                <td colspan="20">
                                    <!--<div class="line down"></div>-->
                                    <div></div>
                                </td>
                            </tr>
                        </c:if>
                        <c:forEach var="val1" items="${subordinateValListofList}">

                            <tr>

                                <c:if test="${val1[3] == 0}">
                                    <!--                                <td class="line left">&nbsp;</td>
                                                                    <td class="line right top">&nbsp;</td>
                                                                    <td class="line left top">&nbsp;</td>
                                                                    <td class="line right">&nbsp;</td>-->
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>

                                </c:if>
                                <c:if test="${val1[3] == 1}">
                                    <!--<td class="line">&nbsp;</td>-->
                                    <!--<td class="line right">&nbsp;</td>-->
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>

                                </c:if>
                                <c:if test="${val1[3] >= 2}">
                                    <!--                                <td class="line left">&nbsp;</td>
                                                                    <td class="line right top">&nbsp;</td>-->
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>

                                    <c:forEach begin="${val1[0] + 2}" end="${val1[1] -1}">
                                        <!--<td class="line left top">&nbsp;</td>-->
                                        <!--<td class="line right top">&nbsp;</td>-->
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </c:forEach>

                                    <!--                                <td class="line left top">&nbsp;</td>
                                                                    <td class="line right">&nbsp;</td>-->
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </c:if>
                            </tr>

                            <tr>

                                <c:forEach var="val" items="${val1[2]}">
                                    <%--<c:forEach var="val1" items="${val}">--%>

                                    <td class="node-container" colspan="2">
                                        <table cellpadding="0" cellspacing="0" border="0">
                                            <tbody>
                                                <tr class="node-cells">
                                                    <td class="node-cell" style="width: 100px" colspan="2" onclick="window.location.href = 'employeeMaster.htm?act=viewEmployeeSubordinate&id=' +${val[0]}">
                                                        <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${val[2]} &#13; Department: ${val[3]} &#13; Designation: ${val[4]}">
                                                            <img src="${val[5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                            <span class="box-title" style="font-size: 105%;color: black">${val[2]}</span>
                                                        </div>
                                                    </td></tr>
                                            </tbody>
                                        </table>
                                    </td>

                                    <%--</c:forEach>--%>
                                </c:forEach>

                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            </tr>

                        </c:forEach>


                    </tbody>
                </table>

            </div>




        </section>



    </div>

    <%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script>
                                                        jQuery(document).ready(function () {
                                                            $("#org").jOrgChart({
                                                                chartElement: '#chart',
                                                                dragAndDrop: true
                                                            });
                                                        });


    </script>
</html>
