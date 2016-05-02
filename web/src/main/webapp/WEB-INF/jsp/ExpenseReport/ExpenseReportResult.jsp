


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

        function createClick() {
//            alert("aaa");
            window.location = 'expenseMaster.htm?act=createClick';
        }
        function viewClick(id) {

//            window.location = 'expenseMaster.htm?act=viewExpense&id=' + id;
            window.location = 'expenseMaster.htm?act=viewClick&id=' + id;
        }
        function editClick(id) {

            window.location = 'expenseMaster.htm?act=viewExpense&id=' + id;
//            window.location = 'expenseMaster.htm?act=viewClick&id=' + id;
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
            <h1>Expense Report: </h1>
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
        <!-- Main content -->
        <%--<form:form action="" method="post" commandName=""--%>
        <!--name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">-->
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
                                    <button type="button" class="btn btn-primary" style="float: right;width: 100px" onclick="window.location = 'expenseMaster.htm?act=createClick'" ><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
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
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">SEARCH</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
            </form:form>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs
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
                                                        <th>Expense Type</th>
                                                        <th>Date Of Submit</th>
                                                            <%--<c:if test="${list[0].employeeMasterByApprover1Id.employeeName ne ''}">--%>
                                                        <!--<th>Reporting manager</th>-->
                                                        <%--</c:if>--%>
                                                        <%--<c:if test="${list[0].employeeMasterByApprover2Id.employeeName ne ''}">--%>
                                                        <!--<th>Expense Admin</th>-->
                                                        <%--</c:if>--%>
                                                        <th>Status</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                            </c:otherwise>
                                        </c:choose>
                                        <tbody>
                                            <c:forEach var="list" items="${list}">
                                                <tr>

                                                    <!--<td align="center"><input type="checkbox" name="checkId" id="hoursId" value="$/{list.id}"/></td>-->
                                                    <td>${list.expenseType}</td>
                                                    <td>${list.dateOfSubmit}</td>
                                                    <%--<c:if test="${list[0].employeeMasterByApprover1Id.employeeName ne ''}">--%>
                                                    <!--<td>$/{list[0].employeeMasterByApprover1Id.employeeName}</td>-->
                                                    <%--</c:if>
                                                    <%--<c:if test="${list[0].employeeMasterByApprover2Id ne null}">--%>
                                                    <!--<td>$/{list[0].employeeMasterByApprover2Id.employeeName}</td>-->
                                                    <%--</c:if>--%>
                                                    <%--<c:if test="${list[0].employeeMasterByApprover2Id eq null}">--%>
                                                    <!--<td>Pending </td>-->
                                                    <%--</c:if>--%>
                                                    <!--                                                       -->
                                                    <c:if test="${list.status == 0}"><td><span class="badge">Pending</span></td></c:if>
                                                    <c:if test="${list.status == 10}"><td><span class="label label-danger">Rejected By <c:if test="${list.employeeMasterByApprover1Id.employeeName ne ''}">
                                                                    ${list.employeeMasterByApprover1Id.employeeName}</c:if></span></td></c:if>
                                                    <c:if test="${list.status == 1}"><td><span class="label label-warning">Reworked By<c:if test="${list.employeeMasterByApprover1Id.employeeName ne ''}">
                                                                    ${list.employeeMasterByApprover1Id.employeeName}</c:if>
                                                            </span></td></c:if>

                                                    <c:choose>
                                                        <c:when test="${list.employeeMasterByEmployeeId.child1 eq 'false'}">

                                                            <c:if test="${list.status == 2}"><td><span class="label label-info">Partially Approved By<c:if test="${list.employeeMasterByApprover1Id.employeeName ne ''}">
                                                                            ${list.employeeMasterByApprover1Id.employeeName}</c:if> </span></td></c:if>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:if test="${list.status == 2}"><td><span class="label label-success">Approved By<c:if test="${list.employeeMasterByApprover1Id.employeeName ne ''}">
                                                                            ${list.employeeMasterByApprover1Id.employeeName}</c:if> </span></td></c:if>

                                                        </c:otherwise>
                                                    </c:choose>

                                                    <c:if test="${list.status == 3}"><td><span class="label label-default">Saved As Draft</span></td></c:if>
                                                    <c:if test="${list.status == 4}"><td><span class="label label-success">Final Approved By <c:if test="${list.employeeMasterByApprover2Id ne null}">
                                                                    ${list.employeeMasterByApprover2Id.employeeName}
                                                                </c:if></span></td></c:if>
                                                        <td>
                                                            <div class="btn-group">
                                                                <!--<a href="#" onclick="editClick('$//{list[0].id}');"> &nbsp;&nbsp;Edit</a>-->
                                                            <c:if test="${list.status==3}">
                                                                <button type="button" class="btn btn-default" aria-haspopup="true" aria-expanded="false" onclick="editClick('${list.id}');" >
                                                                    &nbsp;&nbsp;Edit </button>
                                                                </c:if>
                                                                <c:if test="${list.status == 1 or list.status==2 or list.status == 0 or list.status == 4 or list.status == 10}">
                                                                <button type="button" class="btn btn-default" aria-haspopup="true" aria-expanded="false" onclick="viewClick('${list.id}');" >
                                                                    &nbsp;&nbsp;View</button>
                                                                </c:if>
                                                            <!--<a href="#" onclick="viewClick('$/{list[0].id}');"> &nbsp;&nbsp;View</a>-->
                                                            <!--<span class="caret"></span>-->
                                                            <!--                                                                <ul class="dropdown-menu">
                                                                                                                                <li>
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
                        </div><!-- /.row -->
                    </div><!-- /.box-body -->
                </div><!-- /.tab-content -->
            </div><!-- nav-tabs-custom -->
    </div><!-- /.col -->
</div>
</section>

<%--</form:form>--%>

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
    });

</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<!--    <script>
        $(document).ready(function () {
            $('#table_2').DataTable();
        })
    </script>-->
</html>


