<%--
    Document   : ExpenseRequestSearchByEmployee
    Created on : Jan 20, 2016, 12:40:19 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Travel Detail Search</title>
    </head>

    <script>
        function viewClick(id, empId) {

            window.location = 'expenseMaster.htm?act=viewExpenseRequestByAdmin&id=' + id + '&empId=' + empId;
        }

        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>search :</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">search Travel Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <section class="content">
            <form:form class="form-horizontal" role="form" action="expenseMaster.htm?act=searchOwnExpenseRequestResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        <form:hidden path="id" ></form:hidden>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Expense Type<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="expenseType" id="expenseType" class="form-control">
                                                            <option value="" label="--SELECT--">--SELECT--</option>
                                                            <option value="Travel" label="Travel">Travel</option>
                                                            <option value="Relocation" label="Relocation">Relocation</option>
                                                            <option value="PolicyReimbursements" label="PolicyReimbursements">Policy Reimbursements</option>
                                                            <option value="Others" label="Others">Others</option>
                                                        </select>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                        <!--<div class="input-group date form_datetime" data-date-format="dd/mm/yyyy-hh:ii" data-link-field="dtp_input1">-->
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                            <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                    <div class="form-group">
                                        <div class=" col-sm-2">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
            </form:form>
            <!--        </section>
                    <section class="content">-->
            <form:form action="" method="post" commandName=""
                       name='form1' class="form-horizontal" role="form">
                <div class="row">
                    <div class="col-md-12">
                        <h3>Result :</h3>
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
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Department</th>
                                                                    <th>Designation</th>
                                                                    <th>Expense Type</th>
                                                                    <th>Date Of Submit</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
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
                                                                <td>${list[6]}</td>
                                                                <c:if test="${list[5] == 0}"><td><span class="badge">Pending</span></td></c:if>
                                                                <c:if test="${list[5] == 1}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                                <c:if test="${list[5] == 2}"><td><span class="label label-success">Approved By Manager</span></td></c:if>
                                                                <c:if test="${list[5] == 3}"><td><span class="label label-default">Saved As Draft</span></td></c:if>
                                                                <c:if test="${list[5] == 4}"><td><span class="label label-info">Approved By Admin</span></td></c:if>
                                                                    <td><div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                Action <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu">
                                                                                <li>
                                                                                    <a href="#"
                                                                                       onclick="viewClick('${list[7]}', '${list[8]}');">
                                                                                    &nbsp;&nbsp;View
                                                                                </a>
                                                                            </li>


                                                                        </ul>
                                                                    </div></td>
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

            </form:form>
        </section>
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>



