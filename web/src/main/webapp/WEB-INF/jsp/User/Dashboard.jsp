<%@page import="com.bul.zydex.model.EmployeeMaster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>HR-Power |My Dashboard</title>
        <script>
            function viewEmployeeDetail(employeeId, userId) {
                window.location = "employeeMaster.htm?act=getUserDetail&id=" + employeeId + "&userid=" + userId;
            }
            function printdis(id) {
                window.location = 'employeeMaster.htm?act=printemployeedescription&id=' + id;
            }
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>My Dashboard</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">My Dashboard</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <!--                                <ul class="nav nav-tabs">
                                                            <li class="active"><a id="tab1" href="#tab_1" data-toggle="tab">Employee</a></li>
                                                            <li><a id="tab2" href="#tab_2" data-toggle="tab">HR</a></li>
                                                            <li><a href="#tab_3" data-toggle="tab">Contract</a></li>
                                                        </ul>-->
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="">
                                            <div class="box-header">
                                                <!--<h3 class="box-title">Employee Summary</h3>-->
                                                <div class="box-tools pull-right">
                                                    <!--                                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="row">

                                                    <div class="col-md-4">
                                                                                    <!-- Nature of Business Pane -->
                                                                                    <div class="box box-primary">
                                                                                        <div class="box-header">
                                                                                            <h3 class="box-title">My Detail</h3>
                                                                                            <div class="box-tools pull-right">
                                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                            </div>
                                                                                        </div><!-- /.box-header -->
                                                                                        <div class="box-body">
                                                                                            <ul class="products-list product-list-in-box">
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Employee No : </span>
                                                                                                    <span class="product-title">  ${employeeMaster.employeeId}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Employee Name : </span>
                                                                                                    <span class="product-title">  ${employeeMaster.employeeName}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Department : </span>
                                                                                                    <span class="product-title">  ${employeeMaster.departmentMaster.departmentName}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Designation : </span>
                                                                                                    <span class="product-title">  ${employeeMaster.designationMaster.designationName}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Level : </span>
                                                                                                    <span class="product-title">  ${employeeMaster.levelMaster.level}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Reporting Manager :</span>
                                                                                                    <span class="product-title">  ${employeeMaster.reportingManagerLevel1}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Work Location :</span>
                                                                                                    <span class="product-title">  ${employeeMaster.locationMaster.location}</span>
                                                                                                </li><!-- /.item -->
                                                                                                <li class="item">
                                                                                                    <span class="product-title">Print Job Description:</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                    <a href="#"><span class="product-title" onclick="printdis(${employeeMaster.id});" class="uppercase">Click Here</span></a> 
                                                                                                </li><!-- /.item -->
                                                                                            </ul>
                                                                                        </div><!-- /.box-body -->
                                                                                        <!--                                                    <div class="box-footer text-center">
                                                                                                                                                <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                            </div> /.box-footer -->
                                                                                    </div><!-- /.box -->
                                                                                </div>
																				<div class="col-md-4">
                                        <!-- USERS LIST -->
                                        <div class="box box-danger">
                                            <div class="box-header">
                                                <h3 class="box-title">My Hierarchy</h3>
                                                <div class="box-tools pull-right">
                                                    <button class="btn btn-box-tool" data-widget="collapse">
                                                        <i class="fa fa-minus"></i>
                                                    </button>
                                                    <!--                                                    <button class="btn btn-box-tool" data-widget="remove">
                                                                                                            <i class="fa fa-times"></i>
                                                                                                        </button>-->
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="jOrgChart" style="text-align: center">
                                                    <c:if test="${employeeMasterManager ne null}">

                                                        <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                                                            <tbody>
                                                                <!--                                                            <tr class="node-cells">
                                                                                                                                <td class="node-cell" colspan="4">
                                                                                                                                    <div class="node fruit ui-draggable ui-droppable" style="cursor: n-resize;">

                                                                                                                                    </div>
                                                                                                                                </td>
                                                                                                                            </tr>-->
                                                                <tr>

                                                                    <td class="node-container" colspan="2">
                                                                        <c:if test="${subordinateCount eq 0}">
                                                                            <table cellpadding="0" cellspacing="0" border="0">
                                                                            </c:if>
                                                                            <c:if test="${subordinateCount <= 1 && subordinateCount ne 0}">
                                                                                <table cellpadding="0" cellspacing="0" border="0" width="105px">
                                                                                </c:if>
                                                                                <c:if test="${subordinateCount == 2}">
                                                                                    <table cellpadding="0" cellspacing="0" border="0" width="50px">
                                                                                    </c:if>
                                                                                    <c:if test="${subordinateCount == 3}">
                                                                                        <table cellpadding="0" cellspacing="0" border="0" width="50px">
                                                                                        </c:if>
                                                                                        <c:if test="${subordinateCount == 4}">
                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="50px">
                                                                                            </c:if>
                                                                                            <tbody>
                                                                                                <tr class="node-cells">
                                                                                                    <td class="node-cell" colspan="8" >
                                                                                                        <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${employeeMasterManager1.employeeName} &#13; Department: ${employeeMasterManager1.departmentMaster.departmentName} &#13; Designation: ${employeeMasterManager1.designationMaster.designationName}">
                                                                                                            <img src="${imageManager}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                            <span class="box-title" style="font-size: 105%;color: black">${employeeMasterManager1.employeeName}</span>

                                                                                                        </div>
                                                                                                    </td>
                                                                                                </tr>
                                                                                            </tbody>
                                                                                        </table>
                                                                                        </td>
                                                                                        </tr>
                                                                                    </c:if>




                                                                                    <tr>
                                                                                        <!--                                                                                    <td class="line left">&nbsp;</td>
                                                                                                                                                                            <td class="line ">&nbsp;</td>
                                                                                                                                                                            <td class="line ">&nbsp;</td>
                                                                                                                                                                            <td class="line ">&nbsp;</td>
                                                                                                                                                                            <td class="line ">&nbsp;</td>-->
                                                                                        <td>&nbsp;</td>
                                                                                        <td>&nbsp;</td>
                                                                                        <td>&nbsp;</td>
                                                                                        <td>&nbsp;</td>
                                                                                        <td>&nbsp;</td>
                                                                                    </tr>
                                                                                    <tr>

                                                                                        <td class="node-container" colspan="2">
                                                                                            <table cellpadding="0" cellspacing="0" border="0">
                                                                                                <tbody>
                                                                                                    <tr class="node-cells">
                                                                                                        <td class="node-cell" colspan="8" >
                                                                                                            <div class="node ui-draggable ui-droppable" style="cursor: pointer;"  title=" Name: ${employeeMaster.employeeName} &#13; Department: ${employeeMaster.departmentMaster.departmentName} &#13; Designation: ${employeeMaster.designationMaster.designationName}">
                                                                                                                <img src="${imageUser}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                <span class="box-title" style="font-size: 105%;color: black">${employeeMaster.employeeName}</span>
                                                                                                            </div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <c:if test="${subordinateCount > 0}">

                                                                                                        <tr>
                                                                                                            <td colspan="8">
                                                                                                                <!--<div class="line down"></div>-->
                                                                                                                <c:if test="${subordinateCount == 1}">
                                                                                                                    <div>&nbsp;</div>
                                                                                                                </c:if>

                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <c:if test="${subordinateCount >= 1}">
                                                                                                                <c:if test="${subordinateCount >= 2}">
                                                                                                                    <!--<td class="line left">&nbsp;</td>-->
                                                                                                                    <!--<td class="line right top">&nbsp;</td>-->
                                                                                                                    <td>&nbsp;</td>
                                                                                                                    <td>&nbsp;</td>
                                                                                                                </c:if>
                                                                                                                <c:if test="${subordinateCount >= 3 }">
                                                                                                                    <!--<td class="line left top">&nbsp;</td>-->
                                                                                                                    <!--<td class="line right top">&nbsp;</td>-->
                                                                                                                    <td>&nbsp;</td>
                                                                                                                    <td>&nbsp;</td>
                                                                                                                </c:if>

                                                                                                                <c:if test="${subordinateCount >= 4}">
                                                                                                                    <!--<td class="line left top">&nbsp;</td>-->
                                                                                                                    <!--<td class="line right top">&nbsp;</td>-->
                                                                                                                    <td>&nbsp;</td>
                                                                                                                    <td>&nbsp;</td>
                                                                                                                </c:if>
                                                                                                                <c:if test="${subordinateCount >= 2}">
                                                                                                                    <!--                                                                                                                <td class="line left top">&nbsp;</td>
                                                                                                                                                                                                        <td class="line right">&nbsp;</td>-->
                                                                                                                    <td>&nbsp;</td>
                                                                                                                    <td>&nbsp;</td>
                                                                                                                </c:if>
                                                                                                            </c:if>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <%--<c:if test="${subordinateCount >= 1}">--%>
<!--                                                                                                                <td class="node-container" colspan="2">
                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                        <tbody>
                                                                                                                            <tr class="node-cells">
                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2" >
                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[0][2]} &#13; Department: ${subordinateList[0][3]} &#13; Designation: ${subordinateList[0][4]}">
                                                                                                                                        <img src="${subordinateList[0][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[0][2]}</span>
                                                                                                                                    </div>
                                                                                                                                </td></tr>
                                                                                                                        </tbody>
                                                                                                                    </table>
                                                                                                                </td>-->
                                                                                                            <%--</c:if>--%>
                                                                                                            <%--<c:if test="${subordinateCount >= 2}">--%>
<!--                                                                                                                <td class="node-container" colspan="2">
                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                        <tbody>
                                                                                                                            <tr class="node-cells">
                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2" >
                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[1][2]} &#13; Department: ${subordinateList[1][3]} &#13; Designation: ${subordinateList[1][4]}">
                                                                                                                                        <img src="${subordinateList[1][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[1][2]}</span>
                                                                                                                                    </div>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                        </tbody>
                                                                                                                    </table>
                                                                                                                </td>-->
                                                                                                            <%--</c:if>--%>
                                                                                                            <%--<c:if test="${subordinateCount >= 3}">--%>
<!--                                                                                                                <td class="node-container" colspan="2">
                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                        <tbody>
                                                                                                                            <tr class="node-cells">
                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2" >
                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[2][2]} &#13; Department: ${subordinateList[2][3]} &#13; Designation: ${subordinateList[2][4]}">
                                                                                                                                        <img src="${subordinateList[2][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[2][2]}</span>
                                                                                                                                    </div>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                        </tbody>
                                                                                                                    </table>
                                                                                                                </td>-->
                                                                                                            <%--</c:if>--%>
                                                                                                            <%--<c:if test="${subordinateCount >= 4}">--%>
<!--                                                                                                                <td class="node-container" colspan="2">
                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                        <tbody>
                                                                                                                            <tr class="node-cells">
                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[3][2]} &#13; Department: ${subordinateList[3][3]} &#13; Designation: ${subordinateList[3][4]}">
                                                                                                                                        <img src="${subordinateList[3][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[3][2]}</span>
                                                                                                                                    </div>
                                                                                                                                </td>
                                                                                                                            </tr>
                                                                                                                        </tbody>
                                                                                                                    </table>
                                                                                                                </td>-->
                                                                                                            <%--</c:if>--%>
                                                                                                        </tr>
                                                                                                    </c:if>

                                                                                                </tbody>
                                                                                            </table>
                                                                                        </td>
                                                                                    </tr>
                                                                                    <c:if test="${employeeMasterManager ne null}">


                                                                                        </tbody>
                                                                                    </table>
                                                                                </c:if>
                                                                                </div>
                                                                                <!--                                                                            <div class="jOrgChart">
                                                                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                                                    <tbody>

                                                                                <%--<c:if test="${subordinateAddiCount > 0}">--%>

                                                                                    <tr>
                                                                                        <td colspan="8">
                                                                                            <div class="line down"></div>
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                <%--<c:if test="${subordinateAddiCount >= 1}">--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                    <td class="line left">&nbsp;</td>
                                                                                    <td class="line right top">&nbsp;</td>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 3 }">--%>
                                                                                    <td class="line left top">&nbsp;</td>
                                                                                    <td class="line right top">&nbsp;</td>
                                                                                <%--</c:if>--%>

                                                                                <%--<c:if test="${subordinateAddiCount >= 4}">--%>
                                                                                    <td class="line left top">&nbsp;</td>
                                                                                    <td class="line right top">&nbsp;</td>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                    <td class="line left top">&nbsp;</td>
                                                                                    <td class="line right">&nbsp;</td>
                                                                                <%--</c:if>--%>
                                                                                <%--</c:if>--%>
                                                                            </tr>
                                                                            <tr>
                                                                                <%--<c:if test="${subordinateAddiCount >= 1}">--%>
                                                                                    <td class="node-container" colspan="2">
                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                            <tbody>
                                                                                                <tr class="node-cells">
                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[4][0]},${subordinateList[4][6]});">
                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[4][2]} &#13; Department: ${subordinateList[4][3]} &#13; Designation: ${subordinateList[4][4]}">
                                                                                                            <img src="${subordinateList[4][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">

                                                                                                        </div>
                                                                                                    </td></tr>
                                                                                            </tbody>
                                                                                        </table>
                                                                                    </td>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                    <td class="node-container" colspan="2">
                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                            <tbody>
                                                                                                <tr class="node-cells">
                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[5][0]},${subordinateList[5][6]});">
                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[5][2]} &#13; Department: ${subordinateList[5][3]} &#13; Designation: ${subordinateList[5][4]}">
                                                                                                            <img src="${subordinateList[5][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                        </div>
                                                                                                    </td>
                                                                                                </tr>
                                                                                            </tbody>
                                                                                        </table>
                                                                                    </td>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 3}">--%>
                                                                                    <td class="node-container" colspan="2">
                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                            <tbody>
                                                                                                <tr class="node-cells">
                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[6][0]},${subordinateList[6][6]});">
                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[6][2]} &#13; Department: ${subordinateList[6][3]} &#13; Designation: ${subordinateList[6][4]}">
                                                                                                            <img src="${subordinateList[6][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                        </div>
                                                                                                    </td>
                                                                                                </tr>
                                                                                            </tbody>
                                                                                        </table>
                                                                                    </td>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${subordinateAddiCount >= 4}">--%>
                                                                                    <td class="node-container" colspan="2">
                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                            <tbody>
                                                                                                <tr class="node-cells">
                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[7][0]},${subordinateList[7][6]});">
                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[7][2]} &#13; Department: ${subordinateList[7][3]} &#13; Designation: ${subordinateList[7][4]}">
                                                                                                            <img src="${subordinateList[7][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                        </div>
                                                                                                    </td>
                                                                                                </tr>
                                                                                            </tbody>
                                                                                        </table>
                                                                                    </td>
                                                                                <%--</c:if>--%>
                                                                            </tr>
                                                                                <%--</c:if>--%>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>-->




                                                                                <%--<c:if test="${totalSubordinates > 4}">--%>
                                                                                    <!--<div style="text-align: center;margin-left: 250px;"><a href="employeeMaster.htm?act=viewEmployeeSubordinate&id=${logedInEmpId}" class="uppercase">${subordinateAddiCount} more Subordinates...</a></div>-->
                                                                                <%--</c:if>--%>
                                                                                </div><!-- /.box-body -->
                                                                                <div class="box-footer text-center">
                                                                                    <a href="employeeMaster.htm?act=viewEmployeeSubordinate&id=${logedInEmpId}" class="uppercase">View All Employees</a>
                                                                                    <!--<a href="employeeMaster.htm?act=viewAllSubordinate" class="uppercase">View All Employees</a>-->
                                                                                </div><!-- /.box-footer -->
                                                                                </div><!--/.box -->
                                                                                </div><!-- /.col -->
                                                    <!-- /.box -->
                                                     <div class="col-md-4">
                                                        <!-- Nature of Business Pane -->
                                                        <div class="box box-warning">
                                                            <div class="box-header">
                                                                <h3 class="box-title">My Leave Details</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                    <!--<button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body">
                                                                <ul class="products-list product-list-in-box">
                                                                    <c:forEach var="finalLeaveList" items="${finalLeaveList}">
                                                                        <c:if test="${sessionScope.employeeInfo.gender && finalLeaveList[0] ne 'Paternity Leave'}">
                                                                            <li class="">
                                                                                <div class="progress-group">
                                                                                    <span class="progress-text">${finalLeaveList[0]}</span>
                                                                                    <span class="progress-number"><b>${finalLeaveList[1]}</b>/<fmt:formatNumber maxFractionDigits="1">${finalLeaveList[2]}</fmt:formatNumber></span>
                                                                                        <div class="progress sm">
                                                                                            <div class="progress-bar progress-bar-${finalLeaveList[4]}" style="width: ${finalLeaveList[3]}%"></div>
                                                                                    </div>
                                                                                </div>
                                                                            </li><!-- /.item -->
                                                                        </c:if>
                                                                        <c:if test="${!sessionScope.employeeInfo.gender && finalLeaveList[0] ne 'Maternity Leave'}">
                                                                            <li class="">
                                                                                <div class="progress-group">
                                                                                    <span class="progress-text">${finalLeaveList[0]}</span>
                                                                                    <span class="progress-number"><b>${finalLeaveList[1]}</b>/<fmt:formatNumber maxFractionDigits="1">${finalLeaveList[2]}</fmt:formatNumber></span>
                                                                                        <div class="progress sm">
                                                                                            <div class="progress-bar progress-bar-${finalLeaveList[4]}" style="width: ${finalLeaveList[3]}%"></div>
                                                                                    </div>
                                                                                </div>
                                                                            </li><!-- /.item -->
                                                                        </c:if>
                                                                    </c:forEach>

                                                                </ul>
                                                            </div><!-- /.box-body -->
                                                            <!--                                                                    <div class="box-footer text-center">
                                                                                                                                    <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                </div> /.box-footer -->
                                                        </div><!-- /.box -->
                                                    </div><!-- /.col -->
                                                    <!--                                                            <div class="col-md-8">
                                                                                                                    <div class="chart">
                                                                                                                        <canvas id="barchart"></canvas>
                                                                                                                    </div> /.chart-responsive
                                                                                                                </div> /.col -->

                                                </div><!-- /.row -->
                                            </div><!-- ./box-body -->
                                            <!--                                                    <div class="box-footer">
                                                                                                    <div class="row">
                                                                                                        <div class="col-sm-3 col-xs-6">
                                                                                                            <div class="description-block border-right">
                                                                                                                <h5 class="description-header">54 Employee</h5>
                                                                                                                <span class="description-text">in UAE</span>
                                                                                                            </div> /.description-block
                                                                                                        </div> /.col
                                                                                                        <div class="col-sm-3 col-xs-6">
                                                                                                            <div class="description-block border-right">
                                                                                                                <h5 class="description-header">13 Employee</h5>
                                                                                                                <span class="description-text">in USA</span>
                                                                                                            </div> /.description-block
                                                                                                        </div> /.col
                                                                                                        <div class="col-sm-3 col-xs-6">
                                                                                                            <div class="description-block border-right">
                                                                                                                <h5 class="description-header">12 Employee</h5>
                                                                                                                <span class="description-text">in India</span>
                                                                                                            </div> /.description-block
                                                                                                        </div> /.col
                                                                                                        <div class="col-sm-3 col-xs-6">
                                                                                                            <div class="description-block">
                                                                                                                <h5 class="description-header">06 Employee</h5>
                                                                                                                <span class="description-text">Germany</span>
                                                                                                            </div> /.description-block
                                                                                                        </div>
                                                                                                    </div> /.row
                                                                                                </div> /.box-footer -->
                                        </div><!-- /.box -->
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                                <div class="row">

                                                                                <div class="col-md-4">
                                                        <!-- Nature of Business Pane -->
                                                        <div class="box box-success">
                                                            <div class="box-header">
                                                                <h3 class="box-title">Performance Management Program</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>

                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body">
                                                                <ul class="products-list product-list-in-box">
                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Setting By Employee</span><span ><br>${employeeStartDate} To ${employeeEndDate}</span></div>
                                                                                <c:if test="${goalSetting eq 'Approved'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${goalSetting eq 'Expired'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${goalSetting eq 'Pendding'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        </c:if>

                                                                    </li><!-- /.item -->
                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Approval By Manager</span><span ><br></span></div>
                                                                                <c:if test="${goalApproval eq 'Approved'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${goalApproval eq 'Expired'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${goalApproval eq 'Pendding'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        </c:if>
                                                                        <c:if test="${goalApproval eq 'Rework'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                        </c:if>
                                                                    </li><!-- /.item -->
<!--                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Employee's Mid Year Self Assessment</span><span ><br>${employeeMidStartDate} To ${employeeMidEndDate}</span></div>
                                                                                <%--<c:if test="${midSelfApproval eq 'Approved'}">--%>
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${midSelfApproval eq 'Expired'}">--%>
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${midSelfApproval eq 'Pendding'}">--%>
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        <%--</c:if>--%>
                                                                    </li> /.item -->
<!--                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Manager's Mid Year Review </span><span ><br>${ManagerMidStartDate} To ${ManagerMidEndDate}</span></div>
                                                                                <%--<c:if test="${managerMidSelfApproval eq 'Approved'}">--%>
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${managerMidSelfApproval eq 'Expired'}">--%>
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${managerMidSelfApproval eq 'Pendding'}">--%>
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${managerMidSelfApproval eq 'Rework'}">--%>
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                        <%--</c:if>--%>
                                                                    </li> /.item -->
                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Employee's  Self Assessment </span><span ><br>${employeeEndStartDate} To ${employeeEndEndDate}</span></div>
                                                                                <c:if test="${endSelfApproval eq 'Approved'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${endSelfApproval eq 'Expired'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${endSelfApproval eq 'Pendding'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        </c:if>
                                                                    </li><!-- /.item -->
                                                                    <li class="item">
                                                                        <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Manager's Review </span><span ><br></span></div>
                                                                                <c:if test="${managerEndSelfApproval eq 'Approved'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${managerEndSelfApproval eq 'Expired'}">
                                                                            <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                            </c:if>
                                                                            <c:if test="${managerEndSelfApproval eq 'Pendding'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                        </c:if>
                                                                        <c:if test="${managerEndSelfApproval eq 'Rework'}">
                                                                            <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                        </c:if>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div><!-- /.box-body -->
                                                        <!--                                                    <div class="box-footer text-center">
                                                                                                                <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                            </div> /.box-footer -->
                                                    </div>

                                                                                <div class="col-md-4">
                                                        <div class="box box-success">
                                                            <div class="box-header">
                                                                <h3 class="box-title">Approval Pending (With Manager)</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                    <!--<button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body">
                                                                <ul class="products-list product-list-in-box">
                                                                    <c:forEach var="resignationlist" items="${resignationlist}">
                                                                        <c:if test="${not empty resignationlist}">
                                                                            <li class="item">
                                                                                <a href="resignationMaster.htm?act=viewClick&id=${resignationlist[0].id}&EmpId=${resignationlist[0].employeeMaster.id}">
                                                                                    <!--<span class="product-title" href="javascript::;">{resignationlist[0].employeeMaster.employeeId}</span><b>/</b>-->
                                                                                    <!--<span class="product-title" href="javascript::;">${resignationlist[0].employeeMaster.employeeName}</span><b>/</b>-->
                                                                                    <span class="product-title">Resignation Request </span>
                                                                                    <c:if test="${resignationlist[0].status==0}"><span class="badge" style="float: right">Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==3}"><span class="badge" style="float: right">Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==1}"><span class="label label-warning" style="float: right">RETURN</span></c:if>
                                                                                    <%--<c:if test="${resignationlist[0].status==2}"><span class="label label-success" style="float: right">APPROVED</span></c:if>--%>
                                                                                    <c:if test="${resignationlist[0].status==2}"><span class="badge" style="float: right">HR Approval Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==4}"><span class="label label-success" style="float: right">Resignation Accepted</span></c:if>

                                                                                    <c:if test="${resignationlist[0].status==5}"><span class="badge" style="float: right">Withdraw Pending</span></c:if>
                                                                                    <%--<c:if test="${resignationlist[0].status==6}"><span class="badge" style="float: right"> Pending</span></c:if>--%>
                                                                                    <c:if test="${resignationlist[0].status==6}"><span class="label label-warning" style="float: right"> Returned BY HR</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==7}"><span class="badge" style="float: right">Withdraw HR Approval Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==8}"><span class="badge" style="float: right"> Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==9}"><span class="label label-warning" style="float: right">Withdraw Approved</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status==10}"><span class="badge" style="float: right">Withdraw Pending</span></c:if>
                                                                                    <c:if test="${resignationlist[0].status == 11}"><span class="label label-success" style="float: right">Withdraw Rejected(Resignation Accepted)</span></c:if>
                                                                                    </a>
                                                                                </li><!-- /.item -->
                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <c:forEach var="returnExitList" items="${returnExitList}">
                                                                        <c:if test="${not empty returnExitList}">
                                                                            <li class="item">
                                                                                <a href="exitInterviewMaster.htm?act=createExitReturn&id=${returnExitList[0]}&empID=${returnExitList[1]}">
                                                                                    <!--<span class="product-title" href="javascript::;">{returnExitList[1]}</span><b>/</b>-->
                                                                                    <!--<span class="product-title" href="javascript::;">${returnExitList[2]}</span><b>/</b>-->
                                                                                    <span class="product-title">Exit Interview Request</span>
                                                                                    <c:if test="${returnExitList[3]==0}"><span class="badge" style="float: right">PENDING</span></c:if>
                                                                                    <c:if test="${returnExitList[3]==1}"><span class="badge" style="float: right">HR APPROVAL PENDING</span></c:if>
                                                                                    <%--<c:if test="${returnExitList[3]==1}"><span class="label label-danger" style="float: right">RETURNED</span></c:if>--%>
                                                                                    <c:if test="${returnExitList[3]==2}"><span class="label label-success" style="float: right">HR APPROVED</span></c:if>
                                                                                    <%--<c:if test="${returnExitList[3]==3}"><span class="badge" style="float: right">PENDING</span></c:if>--%>
                                                                                    <%--<c:if test="${returnExitList[3]==4}"><span class="label label-success" style="float: right">HR APPROVED</span></c:if>--%>
                                                                                    <%--<c:if test="${returnExitList[3]==5}"><span class="badge" style="float: right">WITHDRAW PENDING</span></c:if>--%>
                                                                                    <%--<c:if test="${returnExitList[3]==6}"><span class="label label-success" style="float: right">WITHDRAW APPROVED</span></c:if>--%>
                                                                                    <%--<c:if test="${returnExitList[3]==7}"><span class="label label-success" style="float: right">WITHDRAW HR APPROVED</span></c:if>--%>
                                                                                </a>
                                                                            </li><!-- /.item -->
                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <c:forEach var="returnNoDueList" items="${returnNoDueList}">
                                                                        <c:if test="${not empty returnNoDueList}">
                                                                            <li class="item">
<!--                                                                                <a href="noDueMaster.htm?act=createNoDueReturn&id=${returnNoDueList[0]}&empID=${returnNoDueList[1]}">
                                                                                    <span class="product-title" href="javascript::;">{returnNoDueList[1]}</span><b>/</b>
                                                                                    <span class="product-title" href="javascript::;">${returnNoDueList[2]}</span><b>/</b>
                                                                                    <span class="product-title">No Due Request</span>
                                                                                <%--<c:if test="${returnNoDueList[3]==2}"><span class="label label-success" style="float: right">APPROVED</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==1}"><span class="label label-danger" style="float: right">RETURNED</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==6}"><span class="label label-success" style="float: right">APPROVED</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==5}"><span class="label label-danger" style="float: right">RETURNED</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==0}"><span class="badge" style="float: right">PENDING</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==3}"><span class="badge" style="float: right">PENDING</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==4}"><span class="badge" style="float: right">WITHDRAW PENDING</span></c:if>--%>
                                                                                <%--<c:if test="${returnNoDueList[3]==7}"><span class="badge" style="float: right">WITHDRAW PENDING</span></c:if>--%>
                                                                                </a>-->
                                                                            </li><!-- /.item -->
                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <c:if test="${appraisalcount gt 0}">
                                                                        <li class="item">
                                                                            <a href="appraisal360.htm?act=dashboardResult">
                                                                                <span class="product-title" >Appraisal 360<span class="badge" style="float: right">${appraisalcount}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${pendingLeave gt 0}">
                                                                        <li class="item">
                                                                            <a href="leaveEmployeeDetail.htm?act=searchOwnLeaveDetail">
                                                                                <span class="product-title" href="javascript::;"> Leave Request <span class="badge" style="float: right">${pendingLeave}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>

                                                                    <c:if test="${pendingTravel gt 0}">
                                                                        <li class="item">
                                                                            <a href="travelRequestMaster.htm?act=requestResult">
                                                                                <span class="product-title" href="javascript::;">Travel Request  <span class="badge" style="float: right">${pendingTravel}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${poolCarPending gt 0}">
                                                                        <li class="item">
                                                                            <a href="poolCarRequest.htm?act=searchPendingCarRequest">
                                                                                <span class="product-title" >Pool Car Request <span class="badge" style="float: right">${poolCarPending}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${visitorPendingRequest gt 0}">
                                                                        <li class="item">
                                                                            <a href="visitorManagement.htm?act=searchVisitorPendingSubmit">
                                                                                <span class="product-title" href="javascript::;">Visitor Request <span class="badge" style="float: right">${visitorPendingRequest}</span> </span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${gatePassPending gt 0}">
                                                                        <li class="item">
                                                                            <a href="gatePass.htm?act=searchPendingGatePassRequest">
                                                                                <span class="product-title" href="javascript::;"> Gate Pass Request<span class="badge" style="float: right">${gatePassPending}</span> </span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${cafeTeriaPending gt 0}">
                                                                        <li class="item">
                                                                            <a href="cafeteriaRequest.htm?act=searchCafeteriaPendingRequestSubmit">
                                                                                <span class="product-title" href="javascript::;">CafeTeria Request<span class="badge" style="float: right">${cafeTeriaPending}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${ownPipPendingList gt 0}">
                                                                        <li class="item">
                                                                            <a href="performanceImprovementPlanMaster.htm?act=createClick">
                                                                                <span class="product-title" href="javascript::;">PIP<span class="badge" style="float: right">Pending</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${pendingAtEmployeeList gt 0}">
                                                                        <li class="item">
                                                                            <a href="appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit">
                                                                                <span class="product-title" href="javascript::;">PMP<span class="badge" style="float: right">Pending</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <%--<c:if test="${itServicePending gt 0}">--%>
                                                                    <!--                                                                        <li class="item">
                                                                                                                                                <a href="itServiceRequest.htm?act=searchItServicePendingRequestSubmit">
                                                                                                                                                    <span class="product-title" href="javascript::;">IT Service Request<span class="badge" style="float: right">${itServicePending}</span></span>
                                                                                                                                                </a>
                                                                                                                                            </li> /.item -->
                                                                    <%--</c:if>--%>
                                                                    <%--<c:if test="${hrServicePending gt 0}">--%>
                                                                    <!--<li class="item">-->
                                                                    <!--<a href="hrServiceRequest.htm?act=searchHrServicePendingSubmit">-->
                                                                        <!--<span class="product-title" href="javascript::;">HR Service Request<span class="badge" style="float: right">${hrServicePending}</span></span>-->
                                                                    <!--</a>-->
                                                                    <!--</li> /.item -->
                                                                    <%--</c:if>--%>
                                                                    <c:if test="${attendaceRegularizationPending gt 0}">
                                                                        <li class="item">
                                                                            <a href="attendanceRegularizationMaster.htm?act=searchAttendanceRegularizationPendingSubmit">
                                                                                <span class="product-title" href="javascript::;">Attendance Regularization Request <span class="badge" style="float: right">${attendaceRegularizationPending}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <c:if test="${expensePending gt 0}">
                                                                        <li class="item">
                                                                            <a href="expenseMaster.htm?act=searchExpensePendingSubmit">
                                                                                <span class="product-title" href="javascript::;">Expense Request <span class="badge" style="float: right">${expensePending}</span></span>
                                                                            </a>
                                                                        </li><!-- /.item -->
                                                                    </c:if>
                                                                    <%--<c:if test="${coffPending gt 0}">--%>
                                                                    <!--<li class="item">-->
                                                                    <!--<a href="cOffLeaveRequest.htm?act=searchPendingSubmit">-->
                                                                        <!--<span class="product-title" >C-Off Request<span class="badge" style="float: right">${coffPending}</span></span>-->
                                                                    <!--</a>-->
                                                                    <!--</li> /.item -->
                                                                    <%--</c:if>--%>
                                                                </ul>
                                                            </div><!-- /.box-body -->
                                                            <!--                                                                    <div class="box-footer text-center">
                                                                                                                                    <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                </div> /.box-footer -->
                                                        </div>
                                                    </div><!-- /.col -->

                                                                                <div class="col-md-4">
                                                                                    <div class="box box-info">
                                                                                        <div class="box-header">
                                                                                            <h3 class="box-title">Approval Pending (As Manager)</h3>
                                                                                            <div class="box-tools pull-right">
                                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                <!--<button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                                                                            </div>
                                                                                        </div><!-- /.box-header -->
                                                                                        <div class="box-body">
                                                                                            <ul class="products-list product-list-in-box">

                                                                                                <c:if test="${pendingNoDuerequests ne 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="noDueMaster.htm?act=getNoDueRequests">
                                                                                                            <span class="product-title" href="javascript::;">NoDue Requests<span class="badge" style="float: right">${pendingNoDuerequests}</span></span>
                                                                                                        </a>
                                                                                                    </li><!-- /.item -->
                                                                                                </c:if>


                                                                                                <c:if test="${resigncount ne 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="resignationMaster.htm?act=createResignationResult">
                                                                                                            <span class="product-title" href="javascript::;">Resignation Request<span class="badge" style="float: right">${resigncount}</span></span>
                                                                                                        </a>
                                                                                                    </li><!-- /.item -->
                                                                                                </c:if>

                                                                                                <c:if test="${sessionScope.userRight.employeeExit}">
                                                                                                    <c:if test="${exitcount ne 0}">
                                                                                                        <li class="item">
                                                                                                            <a href="exitInterviewMaster.htm?act=HRResult">
                                                                                                                <span class="product-title" href="javascript::;">Exit Interview Request<span class="badge" style="float: right">${exitcount}</span></span>
                                                                                                            </a>
                                                                                                        </li><!-- /.item -->
                                                                                                    </c:if>
                                                                                                </c:if>

                                                                                                <%--<c:forEach var="noDueList" items="${noDueList}">--%>
                                                                                                <%--<c:if test="${not empty noDueList}">--%>
                                                                                                <!--<li class="item">-->
                                                                                                    <!--<a href="noDueMaster.htm?act=createNoDueApproval&id=${noDueList[0].id}&empID=${noDueList[0].employeeMasterByEmpId.id}">-->
                                                                                                        <!--<span class="product-title" href="javascript::;">${noDueList[0].employeeMasterByEmpId.id}</span><b>/</b>-->
                                                                                                        <!--<span class="product-title" href="javascript::;">${noDueList[0].employeeMasterByEmpId.employeeName}</span><b>/</b>-->
                                                                                                <!--<span class="product-title">No Due Request</span>-->
                                                                                                <%--<c:if test="${noDueList[0].status==0}"><span class="badge">PENDING</span></c:if>--%>
                                                                                                <!--</a>-->
                                                                                                <!---->                                                                                                        </li><!-- /.item -->
                                                                                                <%--</c:if>--%>
                                                                                                <%--</c:forEach>--%>
                                                                                                <c:if test="${poolCarApproverPending gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="poolCarRequest.htm?act=searchApproverSubmit">
                                                                                                            <span class="product-title" href="javascript::;">Pool Car Request<span class="badge" style="float: right">${poolCarApproverPending}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${sessionScope.userRight.cafeteriaAdmin}">
                                                                                                    <c:if test="${cafeTeriaApproverPending gt 0}">
                                                                                                        <li class="item">
                                                                                                            <a href="cafeteriaRequest.htm?act=adminApproveSubmit">
                                                                                                                <span class="product-title" href="javascript::;"> CafeTeria Request <span class="badge" style="float: right">${cafeTeriaApproverPending}</span></span>
                                                                                                            </a>
                                                                                                        </li><!-- /.item -->
                                                                                                    </c:if>
                                                                                                </c:if>
                                                                                                <c:if test="${gatePassApproverPending gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="gatePass.htm?act=searchApproverSubmit">
                                                                                                            <span class="product-title" href="javascript::;"> Gate Pass Request<span class="badge" style="float: right">${gatePassApproverPending}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${pendingApproverTravel gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="travelRequestMaster.htm?act=requestResult1">
                                                                                                            <span class="product-title" href="javascript::;"> Travel Request <span class="badge" style="float: right">${pendingApproverTravel}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${pendingApprover1Travel gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="travelRequestMaster.htm?act=requestResult1">
                                                                                                            <span class="product-title" href="javascript::;">Travel Request <span class="badge" style="float: right">${pendingApprover1Travel}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${attendaceRegularizationApproverPending gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="attendanceRegularizationMaster.htm?act=approvalSubmit">
                                                                                                            <span class="product-title" href="javascript::;"> Attendance Regularization Request <span class="badge" style="float: right">${attendaceRegularizationApproverPending}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${attendaceRegularizationApprover1Pending gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="attendanceRegularizationMaster.htm?act=approvalSubmit">
                                                                                                            <span class="product-title" href="javascript::;">Attendance Regularization Request <span class="badge" style="float: right">${attendaceRegularizationApprover1Pending}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${pendingApproverLeave gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="leaveEmployeeDetail.htm?act=viewRequestAdminClick">
                                                                                                            <span class="product-title" href="javascript::;">Leave Request <span class="badge" style="float: right">${pendingApproverLeave}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${withdrawPendingList gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="leaveEmployeeDetail.htm?act=viewRequestAdminClick">
                                                                                                            <span class="product-title" href="javascript::;"> Withdraw Leave Request <span class="badge" style="float: right">${withdrawPendingList}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <%--<c:if test="${pendingApprover2Leave gt 0}">--%>
                                                                                                <!--<li class="item">-->
                                                                                                <!--<a href="leaveEmployeeDetail.htm?act=viewRequestAdminClick">-->
                                                                                                    <!--<span class="product-title" href="javascript::;"> Leave Request <span class="badge" style="float: right">${pendingApprover2Leave}</span></span>-->
                                                                                                <!--</a>-->
                                                                                                <!--</li>-->
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${coffApproverPending gt 0}">--%>
                                                                                                <!--<li class="item">-->
                                                                                                <!--<a href="cOffLeaveRequest.htm?act=coffApproveWisePendingRequest">-->
                                                                                                    <!--<span class="product-title" href="javascript::;"> C-Off Request <span class="badge" style="float: right">${coffApproverPending}</span></span>-->
                                                                                                <!--</a>-->
                                                                                                <!--</li>-->
                                                                                                <%--</c:if>--%>
                                                                                                <c:if test="${sessionScope.userRight.itAdmin}">
                                                                                                    <c:if test="${itServiceApproverPending gt 0}">
                                                                                                        <li class="item">
                                                                                                            <a href="itServiceRequest.htm?act=approverClick">
                                                                                                                <span class="product-title" href="javascript::;"> IT Service Request<span class="badge" style="float: right">${itServiceApproverPending}</span></span>
                                                                                                            </a>
                                                                                                        </li>
                                                                                                    </c:if>
                                                                                                </c:if>

                                                                                                <%--<c:if test="${heServiceApproverPending gt 0}">--%>
                                                                                                <!--                                                                                                <li class="item">
                                                                                                                                                                                                    <a href="hrServiceRequest.htm?act=approverClick">
                                                                                                                                                                                                        <span class="product-title" href="javascript::;">Hr Service Request <span class="badge" style="float: right">${heServiceApproverPending}</span></span>
                                                                                                                                                                                                    </a>
                                                                                                                                                                                                </li> /.item -->
                                                                                                <%--</c:if>--%>

                                                                                                <%--<c:if test="${visitorApproverPendingRequest gt 0}">--%>
                                                                                                <!--                                                                                                    <li class="item">
                                                                                                                                                                                                        <a href="visitorManagement.htm?act=securityApproveSubmit ">
                                                                                                                                                                                                        <span class="product-title" href="javascript::;">Visitor Request <span class="badge" style="float: right">${visitorApproverPendingRequest}</span></span>
                                                                                                                                                                                                        </a>
                                                                                                                                                                                                    </li>-->
                                                                                                <%--</c:if>--%>
                                                                                                <c:if test="${reportingLevel gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="expenseMaster.htm?act=createExpenseApproveList">
                                                                                                            <span class="product-title" href="javascript::;">Expense Request <span class="badge" style="float: right">${reportingLevel}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${empPendingPip gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="performanceImprovementPlanMaster.htm?act=viewPipListByManager">
                                                                                                            <span class="product-title" href="javascript::;">PIP<span class="badge" style="float: right">${empPendingPip}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${pendingAtEmployeeListForManager gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="appraisalPerformance.htm?act=searchClick">
                                                                                                            <span class="product-title" href="javascript::;">PMP<span class="badge" style="float: right">${pendingAtEmployeeListForManager}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                    <c:forEach var="empIdList" items="${empIdList}">
                                                                                                        <label style="font-size: 11px;">${empIdList}</label>
                                                                                                    </c:forEach>
                                                                                                </c:if>

                                                                                                <c:if test="${finalprobationDashboardList gt 0}">
                                                                                                    <li class="item">
                                                                                                        <a href="probationToConfirmation.htm?act=searchSubmit">
                                                                                                            <span class="product-title" href="javascript::;">Probation To Confirmation<span class="badge" style="float: right">${finalprobationDashboardList}</span></span>
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                                <c:if test="${sessionScope.isFunctionalheadDataExist}">
                                                                                                    <c:if test="${fHeadCuonter gt 0}">
                                                                                                        <li class="item">
                                                                                                            <a href="probationToConfirmation.htm?act=functionalheadResultClick">
                                                                                                                <span class="product-title" href="javascript::;">Probation To Confirmation For Head<span class="badge" style="float: right">${fHeadCuonter}</span></span>
                                                                                                            </a>
                                                                                                        </li>
                                                                                                    </c:if>
                                                                                                </c:if>

                                                                                                <c:if test="${sessionScope.userRight.probationToConfirmation}">
                                                                                                    <c:if test="${hrCuonter gt 0}">
                                                                                                        <li class="item">
                                                                                                            <a href="probationToConfirmation.htm?act=hrResultClick">
                                                                                                                <span class="product-title" href="javascript::;">Probation To Confirmation For HR<span class="badge" style="float: right">${hrCuonter}</span></span>
                                                                                                            </a>
                                                                                                        </li>
                                                                                                    </c:if> 
                                                                                                </c:if>


                                                                                        </div>
                                                                                    </div>
                                                                                </div><!-- /.col -->
                                                                                </div><!-- /.row -->
                                                                                </div><!-- /.tab-pane -->
                                                                                <div class="tab-pane" id="tab_2">

                                                                                </div><!-- /.tab-pane -->
                                                                                <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                                                                                </div><!-- /.tab-content -->
                                                                                </div><!-- nav-tabs-custom -->
                                                                                </div><!-- /.col -->
                                                                                </div>
                                                                                </section><!-- /.content -->
                                                                                </div><!-- /.content-wrapper -->
                                                                                <%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
                                                                                <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                                                                                <!--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
                                                                                <!--<script type="text/javascript" src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->

                                                                                <script>
                                                                                    jQuery(document).ready(function () {
                                                                                        $("#org").jOrgChart({
                                                                                            chartElement: '#chart',
                                                                                            dragAndDrop: true
                                                                                        });
                                                                                    });


                                                                                </script>

                                                                                </html>
