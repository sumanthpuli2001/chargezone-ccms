<%-- 
    Document   : PastEmployeeRecords
    Created on : Mar 2, 2016, 2:41:58 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Former Employee</title>
    </head>
    <script>
        function viewClick(id, userid) {
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
            window.location = 'employeeMaster.htm?act=getUserDetail&id=' + id + '&userid=' + userid;
        }
       
    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>FORMER EMPLOYEE RESULT </h1>
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
        <form:form action="" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.hr}">
                                    <button type="button" class="btn btn-facebook col-sm-offset-5" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=formalEmployeeExportToExcel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>

                                </c:if>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                                    <!--<th>user id</th>-->
                                                                    <th>Employee ID</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Team</th>
                                                                    <th>Sub Team</th>
                                                                    <th>Date of Leaving</th>
                                                                        <c:if test="${sessionScope.userRight.hr}">
                                                                        <th>Action</th>
                                                                        </c:if>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[7]}</td>
                                                                <c:if test="${sessionScope.userRight.hr}">
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" onclick="viewClick(${list[0]},${list[6]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                 &nbsp;&nbsp;View
                                                                            </button>
                                                                        </div>
                                                                    </td>
                                                                </c:if>
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
</html>



