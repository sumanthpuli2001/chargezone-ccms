<%-- 
    Document   : SecurityResult
    Created on : Nov 16, 2015, 2:46:32 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Approve Visitor Request</title>
        <style>
            .wrapper1, .wrapper2 { width: 100%; overflow-x: scroll; overflow-y: hidden; }
            .wrapper1 { height: 20px; }
            .wrapper2 {}
            .div1 { height: 20px; }
            .div2 { overflow: none; }
            .modal-dialog {
                width: 360px;
            }
            .modal-header {
                background-color: #337AB7;
                padding:16px 16px;
                color:#FFF;
                border-bottom:2px dashed #337AB7;
            }
            .modal-footer {
                padding:16px 16px;
                color:#FFF;
            }
        </style>

        <script>
            $(function () {
                $('.wrapper1').on('scroll', function (e) {
                    $('.wrapper2').scrollLeft($('.wrapper1').scrollLeft());
                });
                $('.wrapper2').on('scroll', function (e) {
                    $('.wrapper1').scrollLeft($('.wrapper2').scrollLeft());
                });
            });
            $(window).on('load', function (e) {
                $('.div1').width($('#table_1').width());
                $('.div2').width($('#table_1').width());
            });
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>APPROVE VISITOR REQUEST </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Approve Visitor Request</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form class="form-horizontal" role="form" action="visitorManagement.htm?act=securityApproveSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                                    <section class="content">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div style="text-align:right;">
                                                    <button type="button" onclick="createNew();" class="btn btn-primary" style="width: 100px;margin-right:10px;" data-original-title="" title="" >NEW</button>
                                                </div>
                                                <%--<c:if test="${statusForCriteria eq '1'}">--%>
                                                <div class="nav-tabs-custom">
                                                    <div class="tab-content">
                                                        <div class="box-body no-padding">
                                                            <div class="row">
                                                                <div class="col-md-12 col-sm-12">
                                                                    <div class="form-group">
                                                                        <div class="col-sm-6">
                                                                            <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                                            <select name="departmentMaster" id="departmentMaster" class="form-control">
                                                                                <option value="">-- Select --</option>
                                                                                <c:forEach var="deptList" items="${deptMap}">
                                                                                    <option value="${deptList.key}"<c:if test="${deptList.key == dept}">selected="true"</c:if>>${deptList.value}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                                            <select name="designationMaster" id="designationMaster" class="form-control">
                                                                                <option value="">-- Select --</option>
                                                                                <c:forEach var="desigList" items="${desigList}">
                                                                                    <option value="${desigList.key}"<c:if test="${desigList.key == dept}">selected="true"</c:if>>${desigList.value}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-sm-6">
                                                                            <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                <input type="text" id="startDate" value="${sd}" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                <input id="endDate" name="endDate" value="${ed}" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                                            <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                                            <input type="text" id="employeeId" name="employeeId" class="form-control" />
                                                                        </div>
                                                                        <div class="col-sm-6">
                                                                            <label>Status:<span style="color: red;font-size: 12px;"></span></label>
                                                                            <select name="status" id="status" class="form-control">
                                                                                <option value="" <c:if test="${'' eq status}">selected="selected"</c:if>>--Select--</option>
                                                                                <option value="1" <c:if test="${1 == status}">selected="selected"</c:if>>Pending</option>
                                                                                <option value="2" <c:if test="${2 == status}">selected="selected"</c:if>>Confirmed</option>
                                                                                <option value="8" <c:if test="${8 == status}">selected="selected"</c:if>>Withdrawn</option>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div><!-- /.col -->
                                                                </div><!-- /.row -->
                                                            </div><!-- /.box-body -->

                                                            <div class="form-group">
                                                                <div class=" col-sm-12" style="text-align: center;">
                                                                    <button type="submit" class="btn btn-primary" style="width: 100px" data-original-title="" title="" >SEARCH</button>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                <%--</c:if>--%>
                                            </div>
                                        </div>
                                    </section>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--</div>-->
            <section class="content">
                <%--<form:form action="visitorManagement.htm?act=searchSubmit" method="post" commandName="visitorManagement"--%>
                <!--name='form1' class="form-horizontal" role="form">-->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${!empty Approverlist}">
                                    <div class="box-header" style="text-align: right;">
                                        <button type="button" class="btn btn-facebook col-sm-offset-10" style="width: 100px;text-align: right;" onclick="window.location = 'visitorManagement.htm?act=exportToExcel'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                    </div>
                                </c:if>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="wrapper1">
                                                <div class="div1"></div>
                                            </div>
                                            <div class="wrapper2">
                                                </br>
                                                <div class="div2">
                                                    <div class="table table-striped" style="font-size: 12px;text-align: center;" id="table_1_div">   
                                                        <table id="table_1" class="table table-bordered table-hover" style="text-align: center;" >
                                                            <c:choose>
                                                                <c:when test="${empty Approverlist}">
                                                                    <tr>
                                                                        <td align="center">
                                                                            <c:out value="There is no record found."></c:out>
                                                                            </td>
                                                                        </tr>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <thead>
                                                                        <tr>
                                                                            <th style="width: 10%">Action</th>
                                                                            <th style="width: 20%">Location</th>
                                                                            <th style="width: 20%">Requested By</th>
                                                                            <th style="width: 20%">Visit's To</th>
                                                                            <th style="width: 20%">Visitor's Name</th>
                                                                            <th style="width: 20%">Visitor Coming From</th>
                                                                            <th style="width: 20%">Incoming Date</th>
                                                                            <th style="width: 20%">Meeting Off Date</th>
                                                                            <th style="width: 20%">Outgoing Date</th>
                                                                            <th style="width: 20%">Duration (In-Out)</th>
                                                                            <th style="width: 20%">Duration (Meet-Out)</th>
                                                                            <th style="width: 20%">Status</th>
                                                                        </tr>
                                                                    </thead>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <tbody>
                                                                <c:forEach var="visitorlist" items="${Approverlist}">
                                                                    <tr>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" style="width:70px;height:30px;font-size:12px;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                    Action <span class="caret"></span>
                                                                                </button>
                                                                                <%--<c:if test="${visitorlist[9] ne '-'}">--%>
                                                                                <ul class="dropdown-menu" >
                                                                                    <li>
                                                                                        <a href="#"
                                                                                           onclick="viewClick(${visitorlist[0]},${visitorlist[16]});">
                                                                                            <i class="fa fa-eye"></i>View
                                                                                        </a>
                                                                                    </li>
                                                                                    <c:if test="${visitorlist[12] eq 2 and visitorlist[10] eq '-' and visitorlist[9] ne '-' and visitorlist[14] eq '-'}">
                                                                                        <li>
                                                                                            <a href="#"
                                                                                               data-toggle="modal" onclick="setData(${visitorlist[0]});" data-target="#myModal">
                                                                                                <i class="fa fa-check-circle"></i>Exit
                                                                                            </a>
                                                                                        </li>
                                                                                    </c:if>
                                                                                </ul>
                                                                            </div>
                                                                        </td>
                                                                        <td>${visitorlist[6]}</td>
                                                                        <td>${visitorlist[1]}</td>
                                                                        <td>${visitorlist[3]}(${visitorlist[4]})</td>
                                                                        <td>${visitorlist[2]}</td>
                                                                        <td>${visitorlist[7]}</td>
                                                                        <td>${visitorlist[9]}</td>
                                                                        <td>${visitorlist[14]}</td>
                                                                        <td>${visitorlist[10]}</td>
                                                                        <td>
                                                                            <c:if test="${visitorlist[21] eq null or visitorlist[21] eq ''}">-</c:if>
                                                                            <c:if test="${visitorlist[21] ne null and visitorlist[21] ne ''}">
                                                                                ${visitorlist[21]}
                                                                            </c:if>
                                                                        </td>
                                                                        <td>
                                                                            <c:if test="${visitorlist[22] eq null or visitorlist[22] eq ''}">-</c:if>
                                                                            <c:if test="${visitorlist[22] ne null and visitorlist[22] ne ''}">
                                                                                ${visitorlist[22]}
                                                                            </c:if>
                                                                        </td>
                                                                        <td>
                                                                            <c:if test="${visitorlist[12] eq 1}"><span class="badge" style="font-size:10px; ">Pending</span></c:if> 
                                                                            <c:if test="${visitorlist[12] eq 2}"><span class="label label-success">Confirmed</span></c:if>
                                                                            <c:if test="${visitorlist[12] eq 8}"><span class="label label-warning">Withdrawn</span></c:if>
                                                                            </td>
                                                                        </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
                <%--</form:form>--%>
            </section>

            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 class="modal-title"><b>Exit Visitor</b></h3>
                        </div>
                        <div class="modal-body">
                            <section class="content">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <label class="control-label">Meeting Off Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <input type="hidden" id="mhi" name="modalHiddenId"/>
                                            <div class="input-group date modal_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                <input name="meetOffDate" id="mod" class="form-control" size="16" type="text" value="" readonly="true"/>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>    
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" onclick="passData(document.getElementById('mod').value, document.getElementById('mhi').value)" data-dismiss="modal">Submit</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $('.modal_datetime').datetimepicker({
                            //language:  'fr',
                            weekStart: 1,
                            autoclose: 1,
                            minuteStep: 2,
                            startView: 2,
                            forceParse: 0,
                            showMeridian: 1,
                            endDate: new Date()
                        });
                    </script>
                </div>
            </div>
        </div>
    </body>    
    <script>
        function createNew() {
            window.location = 'visitorManagement.htm?act=createClick&get=b';
        }
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
            jQuery("#employeeId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. ."
            });
        });

    </script>
    <script>
        function selectCompanyName(companyId) {
            window.location = 'visitorManagement.htm?act=readDataForCompany&companyId=' + companyId;
        }
    </script>
    <script>
        function createNew() {
            window.location = 'visitorManagement.htm?act=createClick&get=b';
        }
    </script>
    <script>
        function viewClick(id, empId) {
            window.location = "visitorManagement.htm?act=viewSecurityClick&id=" + id + "&empId=" + empId + "&for=view";
        }
        function setData(id) {
            document.getElementById('mhi').value = id;
        }
        function passData(mod, id) {
            $.post("visitorManagement.htm?act=setOutMeet", {id: id, mod: mod}, function () {
            }).done(function () {
                location.reload();
            }).fail(function () {
                location.reload();
            });
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>