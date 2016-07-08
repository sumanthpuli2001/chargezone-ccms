<%--
    Document   : TravelRequestNewResult
    Created on : Jan 27, 2016, 12:24:32 PM
    Author     : Vinita
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
        function viewClick(id, empId) {
            window.location = 'travelRequestMaster.htm?act=approveRequestManagerSide&id=' + id + "&empId=" + empId;
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

        <form:form class="form-horizontal" role="form" action="travelRequestMaster.htm?act=searchTravelRequestSubmitAdmin" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Travel Type<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="travelType" id="travelType" onchange="cashRequired()" class="form-control">
                                                            <option value="" label="--SELECT--">--SELECT--</option>
                                                            <option value="Domestic" label="Domestic">Domestic</option>
                                                            <option value="International" label="International">International</option>
                                                            <option value="Local" label="Local">Local</option>
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
        <form:form action="" method="post" commandName="travelRequestMaster"
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
                                                    <table id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty finalList}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="display: none;"></th>
                                                                    <th>Employee ID</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${finalList}">

                                                            <tr>
                                                                <td style="display: none;">${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td><b>${list[5]}</b></td>
                                                                <td>${list[6]}</td>
                                                                <td>${list[7]}</td>
                                                                <c:if test="${list[8] eq 0}">
                                                                    <td><span class="badge">Pending</span></td>
                                                                </c:if>

                                                                <c:if test="${list[8] eq 3}">
                                                                    <c:choose>
                                                                        <c:when test="${list[13] eq 0}">
                                                                            <%--<c:if test="${list[1].returnFlag eq 0}">--%>
                                                                            <td><span class="badge">Approved by ${list[11]}</span></td>
                                                                            <%--</c:if>--%>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <td><span class="badge">Pending</span></td>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 10}">
                                                                    <td><span class="badge">Return Request Pending</span></td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 2}">
                                                                    <td><span class="label label-danger">Rejected by ${list[11]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 1}">
                                                                    <td><span class="label label-warning">Rework by ${list[11]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 4}">
                                                                    <td><span class="badge">WithDraw</span></td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 5}">
                                                                    <td><span class="label label-success">Final Approved by ${list[11]}</span></td>
                                                                </c:if>
                                                                <c:if test="${list[8] eq 6}">
                                                                    <td><span class="badge">Approved by ${list[11]}</span></td>
                                                                </c:if>



                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${list[13] ne null}">
                                                                            <c:if test="${list[13] ne 0}">
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle" onclick="viewClick(${list[1]},${list[0]});" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                        &nbsp;&nbsp;View
                                                                                    </button>

                                                                                </div>
                                                                            </c:if>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <c:if test="${list[13] eq null}">
                                                                                <c:if test="${list[8] eq 3}">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" onclick="viewClick(${list[1]},${list[0]});" aria-haspopup="true" aria-expanded="false">
                                                                                        &nbsp;&nbsp;View
                                                                                    </button>
                                                                                </c:if>
                                                                            </c:if>
                                                                            <c:if test="${list[8] eq 0 || list[8] eq 10}">
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" onclick="viewClick(${list[1]},${list[0]});" aria-haspopup="true" aria-expanded="false">
                                                                                        &nbsp;&nbsp;View
                                                                                    </button>
                                                                                </div>
                                                                            </c:if>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <%--</c:forEach>--%>
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
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $(document).ready(function ()
        {
             $('#table_2').DataTable( {
        "order": [[ 0, "desc" ]]
    } );
        });
    </script>


</html>


