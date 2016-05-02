<%--
    Document   : ShiftResult
    Created on : Oct 9, 2015, 3:36:40 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Result</title>
        <style>
            .dataTables_wrapper .dataTables_paginate .paginate_button:hover{
                background-color: white !important;
                background:linear-gradient(to bottom,#fffff 0,#111 100%) !important;
            }
        </style>

        <script>
            function viewClick(id) {
                window.location = 'shiftMaster.htm?act=viewClick&id=' + id;
            }

            //        function toggle(source) {
            //            alert('asd');
            //            var checkboxes = document.getElementsByName('shiftId');
            //            for (var i = 0, n = checkboxes.length; i < n; i++) {
            //                checkboxes[i].checked = source.checked;
            //            }
            //        }
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
    </head>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Shift Result: </h1>
            
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Shift Result</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftMaster.htm?act=deleteSubmit" method="post" commandName="shiftMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>
                                <button type="button" class="btn btn-primary" style="float: right" onclick="window.location = 'shiftMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
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
                                                                <tr >
                                                                    <th align="center" style="width: 1px !important;"><input type="checkbox" id="toggleId" /></th>
                                                                    <th>Shift Name</th>
                                                                    <th>Start Time</th>
                                                                    <th>End Time</th>
                                                                    <th>Late Hours</th>
                                                                    <!--<th>Early Hours</th>-->
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td align="center"><input type="checkbox" name="checkId" id="shiftId" value="${list.id}" onclick="toggle(this);"/></td>
                                                                <td>${list.shiftName}</td>
                                                                <td>${list.startTime}</td>
                                                                <td>${list.endTime}</td>
                                                                <td>${list.lateHours}</td>
                                                                <!--<td>$list.earlyHours}</td>-->
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick(${list.id});" class="btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            Edit
                                                                        </button>

                                                                    </div>
                                                                </td>
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
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
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
            forceParse: 0});
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

