<%--
    Document   : EmployeePerformanceAppraisalResult
    Created on : Oct 29, 2015, 11:59:35 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Performance Result</title>
    </head>
    <script>
        function editClick(id, userid, appraisalId, year) {
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
//            window.location = 'appraisalPerformance.htm?act=editClick&id=' + id;
//id=Empid and userid=UserMasterid and= appraisal Id
            window.location = 'appraisalPerformance.htm?act=editClick&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }

        function editClickCompetencyForManager(id, userid, appraisalId, year) {
            window.location = 'appraisalPerformance.htm?act=editClickCompetencyForManager&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }
        function editClickForIdpManager(id, userid, appraisalId, year) {
            window.location = 'appraisalPerformance.htm?act=editClickForIdpManager&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }

        function createClick(id) {
            window.location = 'userRightMaster.htm?act=createClick&id=' + id;
        }
        function changeRequestPMP(id, userid, appraisalId, year) {
            window.location = 'appraisalPerformance.htm?act=changeRequestPMP&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
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



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>APPRAISAL PERFORMANCE RESULT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Result</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="appraisalPerformance.htm?act=deleteSubmit" method="post" commandName="AppraisalPerformanceMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
                                <div class="box-header">
                                    <!--<button type="button" class="btn btn-primary" style="float: right" onclick=""><i class="fa fa-plus"></i>&nbsp&nbsp;New</button>-->
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
                                                                    <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    <!--<th>user id</th>-->
                                                                    <th>Employee ID</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Department</th>
                                                                    <th>Designation</th>
                                                                    <th>Year</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>-->
                                                                <!--<td>/</td>-->
                                                                <td>${list[0][2]}</td>
                                                                <!--<td>$//{list[2]}</td>-->
                                                                <td>${list[0][3]}</td>
                                                                <td>${list[0][4]}</td>
                                                                <td>${list[0][5]}</td>
                                                                <td>${list[0][8]}</td>
                                                                <td>
                                                                    <ul class="products-list product-list-in-box">
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Setting By Employee</span></div>
                                                                            <c:if test="${list[1][0] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][0] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][0] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>

                                                                        </li><!-- /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Approval By Manager</span></div>
                                                                            <c:if test="${list[1][1] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][1] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][1] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                            <c:if test="${list[1][1] eq 'Rework'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                            </c:if>
                                                                        </li><!-- /.item -->
<!--                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Employee’s Mid Year Self Assessment</span></div>
                                                                            <%--<c:if test="${list[1][2] eq 'Approved'}">--%>
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${list[1][2] eq 'Expired'}">--%>
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${list[1][2] eq 'Pendding'}">--%>
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            <%--</c:if>--%>
                                                                        </li> /.item 
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Manager’s Mid Year Review </span></div>
                                                                            <%--<c:if test="${list[1][3] eq 'Approved'}">--%>
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${list[1][3] eq 'Expired'}">--%>
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                <%--</c:if>--%>
                                                                                <%--<c:if test="${list[1][3] eq 'Pendding'}">--%>
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${list[1][3] eq 'Rework'}">--%>
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                            <%--</c:if>--%>
                                                                        </li> /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Employee’s  Self Assessment</span></div>
                                                                            <c:if test="${list[1][4] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][4] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][4] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                        </li><!-- /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Manager’s  Review</span></div>
                                                                            <c:if test="${list[1][5] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][5] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[1][5] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                            <c:if test="${list[1][5] eq 'Rework'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                            </c:if>
                                                                        </li>
                                                                    </ul>
                                                                </td>
                                                                <!--<td></td>-->

                                                                <td>
                                                                    <div class="btn-group">
<!--                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" onclick="editClick(${list[0][1]},${list[0][7]},${list[0][0]});" aria-expanded="false">

                                                                            <span class="fa fa-pencil"></span>

                                                                            Action &nbsp;&nbsp;
                                                                        </button>-->
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"  aria-expanded="false">
                                                                            <span class="fa fa-pencil"></span>
                                                                            Action &nbsp;&nbsp;
                                                                        </button>
                                                                        <ul class="dropdown-menu">
                                                                            <li style="width: 100px;">
                                                                                <a href="#"
                                                                                   onclick="editClick(${list[0][1]},${list[0][7]},${list[0][0]},${list[0][8]});">

                                                                                    View PMP
                                                                                </a>
                                                                            </li>

<!--                                                                            <li style="width: 100px;">
                                                                                <a href="#"
                                                                                   onclick="editClickCompetencyForManager(${list[0][1]},${list[0][7]},${list[0][0]},${list[0][8]});">
                                                                                    View Competency
                                                                                </a>
                                                                            </li>-->
<!--                                                                            <li style="width: 100px;">
                                                                                <a href="#"
                                                                                   onclick="editClickForIdpManager(${list[0][1]},${list[0][7]},${list[0][0]},${list[0][8]});">
                                                                                    View IDP
                                                                                </a>
                                                                            </li>-->
                                                                            <%--<c:if test="${sessionScope.userRight.hr == true}" >--%>
<!--                                                                                <li style="width: 100px;">
                                                                                    <a href="#"
                                                                                       onclick="changeRequestPMP(${list[0][1]},${list[0][7]},${list[0][0]},${list[0][8]});">
                                                                                        Change Request
                                                                                    </a>
                                                                                </li>-->
                                                                            <%--</c:if>--%>
                                                                        </ul>

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




