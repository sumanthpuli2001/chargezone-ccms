<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title> Employee Saving </title>
    </head>
    <script>
        function viewClick(id, financialYearId) {
            window.location = "payrollEmployeeFormSixteen.htm?act=viewClick&id=" + id + "&financialYearId=" + financialYearId;

        }
    </script>
    <script>

        function saveSubmit11() {
            var flag3 = true;
//            alert(document.getElementById("fnyear").value);
            if (document.getElementById("fnyear").value == '') {
                document.getElementById("fnError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("fnError").innerHTML = '';
            }
            if (document.getElementById("zydexLocationMasterId").value == '') {
                document.getElementById("fError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("fError").innerHTML = '';
            }
//            alert(flag3);
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
            <h1>Employee Saving Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Saving Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="payrollEmployeeFormSixteen.htm?act=searchFormEmployeeSavingDetailSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
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

                                            <div class="col-sm-4">
                                                <label>Financial year:<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="fnyear" id="fnyear" class="form-control ">
                                                    <option value="">--Select--</option>
                                                    <c:forEach var="finyear" items="${financialYearList}">
                                                        <option value="${finyear.key}" label="${finyear.value}" ></option>
                                                    </c:forEach>
                                                </select>
                                                <span id="fnError" style="color: red;"></span>
                                            </div>
                                            <br>

                                        </div>
                                        <!--</div> /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="form-group">
                                    <div class=" col-sm-12">
                                        <center>
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                        </center>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>

            </section>
        </form:form>

        <form:form action="" method="post" commandName="payrollEmployeeFormSixteen"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <!--                                <div class="box-header" style="text-align: right;">
                                                                        <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'leaveEmployeeDetail.htm?act=exportToExcelForLeaveRequest'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                    </div>-->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table  class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>

                                                            <c:when test="${empty employeelist}">
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
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                        <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>

                                                        <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                            <tr>
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>

                                                                <td>  <button type="button" onclick="viewClick('${list[2]}', '${list[3]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                        &nbsp;&nbsp;View
                                                                    </button>
                                                                </td>

                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <c:if test="${!empty employeelist}">

                                                </c:if>

                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->

                        </div>
                    </div><!-- /.col -->
                </section>

            </c:if>
        </form:form>

    </div>
    <script>
        function selectsubtype(typeId) {

            var empSubTypeId = document.getElementById("employeeSubTypeId").value;
            //            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeTypeWiseSalary.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMasterId").value;
            selectsubtype(empTypeId);

        });

    </script>
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
    <script type="text/javascript">
        window.onload = init;
        function init() {
            document.form1.month.options[new Date().getMonth()].selected = true;
        }
        var start = 1990;
        var end = new Date().getFullYear();
        var options11 = "";

        for (var year1 = end; year1 >= start; year1--) {
            options11 += "<option>" + year1 + "</option>";
        }
        document.getElementById('year11').innerHTML = options11;
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

