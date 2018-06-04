


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No Due Result</title>
    </head>
    <script>
        function viewClick(id, empId) {

            window.location = 'noDueMaster.htm?act=createNoDueApproval&id=' + id + '&empID=' + empId;
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
            <h1>NO DUE RESULT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due</li>
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
                                                                    <!--<th/>Sr No.</th>-->
                                                                    <th>No Due Form Of Employee</th>
                                                                    <th>Date of Joining</th>
                                                                    <th>Date of Leaving</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>

                                                        <c:set var="count" value="0" scope="page"/>
                                                        <c:forEach var="list" items="${list}">
                                                            <c:set var="count" value="${count =count + 1}" scope="page"/>
                                                            <tr>
                                                                <!--<td><c:out value="${count}"/></td>-->
                                                                <td>${list.employeeMasterByEmpId.employeeName}</td>
                                                                <td>${list.employeeMasterByEmpId.dateOfJoining}</td>
                                                                <td>${list.employeeMasterByEmpId.dateOfLeaving}</td>
                                                                <td>
                                                                <c:if test="${list.status == 0}"><span class="badge">Pending</span></c:if>
                                                                <c:if test="${list.status == 1}"><span class="label label-danger">Returned</span></c:if>
                                                                <c:if test="${list.status == 2}"><span class="label label-success">Approved</span></c:if>
                                                                <c:if test="${list.status == 3}"><span class="badge">Pending</span></c:if>
                                                                
                                                                <c:if test="${list.status == 4}"><span class="badge">Withdraw Pending</span></c:if>
                                                                <c:if test="${list.status == 5}"><span class="label label-danger">Withdraw Returned</span></c:if>
                                                                <c:if test="${list.status == 6}"><span class="label label-success">Withdraw Approved</span></c:if>
                                                                <c:if test="${list.status == 7}"><span class="badge">Withdraw Pending</span></c:if>   
                                                                </td>
                                                                <td>
                                                                <c:if test="${list.status == 0 || list.status == 3 || list.status == 4 || list.status == 7}">
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"   onclick="viewClick('${list.id}', '${list.employeeMasterByEmpId.id}');" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                               &nbsp;&nbsp;View
                                                                            </button>
<!--                                                                            <ul class="dropdown-menu">
                                                                                <li>
                                                                                    <a href="#"
                                                                          >
                                                                                       
                                                                                </a>
                                                                            </li>
                                                                        </ul>-->
                                                                    </div>
                                                                                       </c:if>
                                                                </td>


                                                                </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                        <br/>
                                        <br/>
                                        <div class="col-sm-6">
                                            <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                        </div><!-- /.row -->
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


