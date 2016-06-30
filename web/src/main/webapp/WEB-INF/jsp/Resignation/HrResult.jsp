<%--
    Document   : HrResult
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resignation Result</title>
    </head>
    <script>

        function viewClick(id, empId) {

            window.location = 'resignationMaster.htm?act=Hrview&id=' + id + '&EmpId=' + empId;
        }

        function toggle(source) {
            var checkboxes = document.getElementsByName('hoursId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                checkboxes[i].checked = source.checked;
            }
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
            <h1>Resignation Result: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active"> Resignation</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="" method="post" commandName=""
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header" style="text-align: right;">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'resignationMaster.htm?act=exportToExcelResignation'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
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
                                                                    <th>Employee id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Effective Date</th>
                                                                    <th>Good/Bad Attrition</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="hoursId" value="${list[0]}"/></td>-->
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[6]}</td>
                                                                <c:if test="${list[2] == 2}"><td><span class="badge">Pending</span></td></c:if>
                                                                <c:if test="${list[2] == 8}"><td><span class="badge">Returned Pending</span></td></c:if>
                                                                <c:if test="${list[2] == 7}"><td><span class="badge">Withdraw Pending</span></td></c:if>
                                                                <c:if test="${list[2] == 10}"><td><span class="badge">Withdraw Pending(Rejected by Manager)</span></td></c:if>
                                                                <c:if test="${list[2] == 4}"><td><span class="label label-success">Approved by HR</span></td></c:if>
                                                                <%--<c:if test="${list[2] == 11}"><td><span class="badge">Withdraw Pending(Rejected by Manager)</span></td></c:if>--%>
                                                                <%--<c:if test="${list[2] == 6}"><td><span class="badge">Returned Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[2] == 8}"><td><span class="badge">Withdraw Pending</span></td></c:if>--%>


                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle"   onclick="viewClick('${list[0]}', '${list[3]}');" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                        <!--                                                                            <ul class="dropdown-menu">
                                                                                                                                                        <li>
                                                                                                                                                            <a href="#"
                                                                                                                                                        </a>
                                                                                                                                                    </li>
                                                                                                                                                </ul>-->
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                        <br/>
                                        <br/>
                                        <div class="col-lg-offset-1 col-sm-3">
                                            <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                        </div>
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


