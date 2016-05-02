<%--
    Document   : TravelSearchByEmployeeResult
    Created on : Oct 31, 2015, 5:11:41 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request Result</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'travelRequestMaster.htm?act=viewRequest&id=' + id;
        }

        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
//            alert(checkboxes.length);
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Travel Request </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Travel Request</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="travelRequestMaster.htm?act=deleteSubmit" method="post" commandName="travelRequestMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                            <div class="table table-bordered">
                                                <c:set var="Status" value="0"></c:set>
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
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Department</th>
                                                                    <th>Designation</th>
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">

                                                            <tr>
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>
                                                                <td>${list[7]}</td>
                                                                <c:if test="${list[8] eq 0}">
                                                                    <td>Pending</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 3}">
                                                                    <td>Approved</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 2}">
                                                                    <td>Rejected</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 1}">
                                                                    <td>Rework</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 4}">
                                                                    <td>WithDraw</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 5}">
                                                                    <td>Final Approved</td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 7}">
                                                                    <td>Withdrawn</td>
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
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>


