<%--
    Document   : EmployeeRegistrationResult
    Created on : Oct 17, 2015, 12:00:06 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Registration Result</title>
        <script>
            function viewClick(id, userid) {
                //            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
                window.location = 'employeeMaster.htm?act=viewClick&id=' + id + '&userid=' + userid;
            }
            function createClick(id) {
                window.location = 'userRightMaster.htm?act=createClick&id=' + id;
            }
            function changePassword(id) {
                window.location = 'employeeMaster.htm?act=adminChangePassWordClick&id=' + id;
            }
            function changeShiftClick(id) {
                window.location = 'employeeMaster.htm?act=changeEmployeeShift&id=' + id;
            }
            function editRotation(id) {
                window.location = 'shiftRotationInfo.htm?act=viewRotationClick&id=' + id;
            }
            function inActiveFun(id) {
                window.location = 'employeeMaster.htm?act=inActiveEmployeeClick&id=' + id;
            }
            function printdis(id) {
                window.location = 'employeeMaster.htm?act=printemployeedescription&id=' + id;
            }

            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }
        </script>
        <script>
            function teamchanged(type,id){
               
               if(id.value === 'None'){
                    window.location = 'employeeMaster.htm?act=searchSubmit';
               }
               else{
                   var idd =  id.value;
                   window.location = 'employeeMaster.htm?act=readEmployeeDetailsTeamAndSubTeamWise&id=' + idd + '&type=' + type;
               }
                
            }
            </script>
    </head>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EMPLOYEE REGISTRATION RESULT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employees List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=deleteSubmit" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>

                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'employeeMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                </c:if>
                                    
                                   
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <input type="hidden" id="keyval">
                                            <div class="col-md-2" style="width: 200px; padding-bottom: 20px;">
                                             
                                                                <label>Department:<span style="color: red;font-size: 12px;">*</span></label>
                                                                
                                                                <select name="employeeTypeMaster.id" id="employeeTypeMaster.id" class="form-control" onchange="teamchanged('Team',this);" style="font-size: 12px;">
                                                                    <option value="None">-- Select --</option>
                                                                    <c:forEach var="EmployeeTypeList" items="${EmployeeTypeList}">
                                                                        <c:choose>
                                                                            <c:when test="${typeid == EmployeeTypeList.key}">
                                                                                    <option value="${typeid}" selected="selected">${EmployeeTypeList.value}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${EmployeeTypeList.key}">${EmployeeTypeList.value}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                               
                                                            <div class="col-md-2" style="width: 200px; padding-bottom: 20px;">
                                               
                                                                <label>Division:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <select name="employeeSubType.id" id="employeeSubType.id" class="form-control" onchange="teamchanged('SubTeam',this);" style="font-size: 12px;">
                                                                    <option value="None">-- Select --</option>
                                                                    <c:forEach var="EmployeeSubTypeList" items="${EmployeeSubTypeList}">
                                                                        <c:choose>
                                                                            <c:when test="${subtypeid == EmployeeSubTypeList.key}">
                                                                                <option value="${subtypeid}" selected="selected">${EmployeeSubTypeList.value}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${EmployeeSubTypeList.key}">${EmployeeSubTypeList.value}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            
                                            <div class="table table-bordered" style="padding-top: 20px;"> 
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            
                                                            <thead>
                                                                <tr>
                                                                    <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                        <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                                        </c:if>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Employee ID</th>
                                                                    <th style="width: 50px;">Employee Name</th>
                                                                    <th style="width: 50px;">Department</th>
                                                                    <th style="width: 50px;">Division</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;">Action</th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        
                                                        
<!--                                                        <span id="employeeDetailBody"></span>-->
                                                     
                                                        
                                                        
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td style="padding-left: 20px;">${list[1]}</td>
                                                                <td style="padding-left: 20px;">${list[2]}</td>
                                                                <td style="padding-left: 20px;">${list[3]}</td>
                                                                <td style="padding-left: 20px;">${list[4]}</td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            Action <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu" style="width: 100px;" >
                                                                            <c:if test="${sessionScope.userRight.employeeManagement}">

                                                                                <li style="width: 100px;">
                                                                                    <a href="#"
                                                                                       onclick="viewClick(${list[0]},${list[6]});">
                                                                                        <!--onclick="viewClick($//{list[0]},$//{list[1]});">-->
                                                                                         Employee Edit
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.hr}">
                                                                                <li>

                                                                                    <a href="#"
                                                                                       onclick="createClick(${list[6]});">
                                                                                        Right Management
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.hr}">
                                                                                <li>

                                                                                    <a href="#"
                                                                                       onclick="changePassword(${list[0]});">
                                                                                        Change Password
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.employeeManagement}">

                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="changeShiftClick(${list[0]});">
                                                                                        Change Shift
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.employeeManagement}">

                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="inActiveFun(${list[0]});">
                                                                                        InActive Employee
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <c:if test="${sessionScope.userRight.employeeManagement}">

                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="printdis(${list[0]});">
                                                                                        Print Description
                                                                                    </a>
                                                                                </li>
                                                                            </c:if>
                                                                            <li>
                                                                                <a href="#"
                                                                                   onclick="editRotation(${list[6]});">
                                                                                    Edit Shift Rotation
                                                                                </a>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </td>
                                                                <%--</c:if>--%>
                                                            </tr>
                                                        </c:forEach>
                                                           
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>



