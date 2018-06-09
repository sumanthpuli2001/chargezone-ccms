


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Report</title>
    </head>
    <script>

        function viewClick(id, empId) {

            window.location = 'expenseMaster.htm?act=viewClickApprove&id=' + id + '&empId=' + empId;
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
            <h1>EXPENSE REPORT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Expense Report</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <form:form class="form-horizontal" role="form" action="expenseMaster.htm?act=subordinatesExpenseReportResult" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
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
                                                    <!--<div class="col-sm-6">-->
                                                    <!--<label>Department:<span style="color: red;font-size: 12px;"></span></label>-->
                                                <%--<form:select path="departmentMaster" id="departmentMaster" class="form-control">--%>
                                                <%--<form:option value="" label="-- Select --" />--%>
                                                <%--<form:options items="${deptMap}"></form:options>--%>
                                                <%--</form:select>--%>
                                                <%--<form:errors path="departmentMaster" cssClass="errorDiv"></form:errors>--%>
                                                <!--                                                    </div>-->

                                            </div>

                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                            <%--<form:select path="designationMaster" id="designationMaster" class="form-control">--%>
                                            <%--<form:option value="" label="-- Select --" />--%>
                                            <%--<form:options items="${desigList}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <%--<form:errors path="designationMaster" cssClass="errorDiv"></form:errors>--%>
                                        </div>


                                    </div>-->

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
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="expenseStatus" id="expenseStatus" class="form-control">
                                                        <option value="999" label="--SELECT--">--SELECT--</option>
                                                        <option value="0" label="Pending">Pending</option>
                                                        <option value="1" label="Rejected">Rejected</option>
                                                        <option value="2" label="Approved By Manager">Approved By Manager</option>
                                                        <option value="3" label="Saved As Draft">Saved As Draft</option>
                                                        <option value="4" label="Approved By Admin">Approved By Admin</option>
                                                    </select>
                                                </div>


                                            </div>

                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px;">SEARCH</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
        <!-- Main content -->
        <form:form action="" method="post" commandName=""
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty reportingLevel}">
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
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Expense Type</th>
                                                                    <th>Date Of Submit</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>

                                                    <c:forEach var="list" items="${reportingLevel}">
                                                        <c:if test="${list[8] ne 'true'}">

                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="hoursId" value=""/></td>-->
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[1]}</td>
                                                                <%--<c:if test="${list[5]== 0}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[5]== 1}"><td><span class="label label-danger">Returned</span></td></c:if>--%>
                                                                <%--<c:if test="${list[5] == 2}"><td><span class="label label-success">Approved</span></td></c:if>--%>

                                                                <c:if test="${list[5] == 0}"><td><span class="badge">Pending</span></td></c:if>
                                                                <c:if test="${list[5] == 1}"><td><span class="label label-warning">Reworked By ${list[7]}</span></td></c:if>
                                                                <c:if test="${list[5] == 10}"><td><span class="label label-danger">Rejected By ${list[7]}</span></td></c:if>
                                                                <c:choose>
                                                                    <c:when test="${list[8] eq 'false'}">
                                                                        <c:if test="${list[5] == 2}"><td><span class="label label-info">Partially Approved By ${list[7]}</span></td></c:if>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <c:if test="${list[5] == 2}"><td><span class="label label-success">Approved By ${list[7]}</span></td></c:if>
                                                                    </c:otherwise>
                                                                </c:choose>

                                                                <%--<c:if test="${list[5] == 2}"><td><span class="label label-success">Approved By ${list[7]}</span></td></c:if>--%>
                                                                <c:if test="${list[5] == 3}"><td><span class="label label-default">Saved As Draft</span></td></c:if>
                                                                <c:if test="${list[5] == 4}"><td><span class="label label-success">Final Approved By ${list[7]}</span></td></c:if>
                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick('${list[0]}', '${list[6]}');">
                                                                            View</button>
                                                                        <!--<ul class="dropdown-menu">-->
                                                                        <!--<li>-->
                                                                        <!--<a href="#"-->
                                                                        <!--onclick="viewClick('$/{list[0]}', '$/{list[6]}');">-->
                                                                        <!--&nbsp;&nbsp;View-->
                                                                        <!--</a>-->
                                                                        <!--</li>-->


                                                                        <!--</ul>-->
                                                                    </div>
                                                                </td>


                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>

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
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0

        });</script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->

</html>


