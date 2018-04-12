<%--
    Document   : EmployeePerformanceAppraisalResult
    Created on : Oct 29, 2015, 11:59:35 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Performance Result</title>
    </head>
    <script>
        function editClick1(id, userid, appraisalId, year) {
          
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
//            window.location = 'appraisalPerformance.htm?act=editClick&id=' + id;
            window.location = 'appraisalPerformance.htm?act=editClick1&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }
        function createClick(pmpyear) {
//            alert("aaa=" + pmpyear);
            window.location = 'appraisalPerformance.htm?act=createClick&year=' + pmpyear;
            // window.location = 'userRightMaster.htm?act=createClick&id=' + id;
        }
        function editClickCompetency(id, userid, appraisalId, year) {
            window.location = 'appraisalPerformance.htm?act=editClickCompetencyIdp&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }
        function editClickIdp(id, userid, appraisalId, year) {
            window.location = 'appraisalPerformance.htm?act=editClickIdp&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&year=' + year;
        }
        function pastAppraisalClick(id, userid, appraisalId, pyear) {
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
//            window.location = 'appraisalPerformance.htm?act=editClick&id=' + id;
            window.location = 'appraisalPerformance.htm?act=pastAppraisalClick&id=' + id + '&userid=' + userid + '&appraisalId=' + appraisalId + '&pyear=' + pyear;
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

//        function function saveSubmit11() {
//            alert("Please, Select one or more record(s).");
//            alert(document.getElementById("pmpyear").value);
//            document.getElementById("pmpyear").value;
////            var pmpyear = $('#pmpyear :selected').text();
////            alert(pmpyear);
////            if (pmpyear !== "") {
////                return true;
////            }
//
//
//            return false;
//        }
        $('#button1').click(function () {
//            alert("Sss");
            alert("QQQQ=" + $('#pmpyear :selected').text());
        });
        function createClick1() {
//            Changevalue
//            var pmpyear = document.getElementById("pmpyear").value;
//            after change
             var pmpyear = document.getElementById("cyclename").value;
//            alert("wwww=" + document.getElementById("pmpyear").value);
//            if (confirm('Are you sure you want to Create New PMP')) {
            // Save it!
            createClick(pmpyear);
//            } else {
            return false;
//            }
            // window.location = 'userRightMaster.htm?act=createClick&id=' + id;
        }
    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Appraisal Performance Result: </h1>
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
        <form:form action="appraisalPerformance.htm?act=createClick" method="post" commandName="AppraisalPerformanceMaster"
                   name='form1' onsubmit='return createClick1();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
<!--                                <div class="col-sm-3" id="competencyEId" >
                                    <label>Year:</label>
                                    <select name="pmpyear" id="pmpyear" class="form-control"/>
                                    <option value="">--SELECT--</option>
                                    <%--<c:forEach var="pmpyearMap" items="${pmpyearList}">--%>
                                        <option value="${pmpyearMap.key}">${pmpyearMap.value}</option>
                                    <%--</c:forEach>--%>
                                    </select>
                                </div>-->

                                <!--<button type="button1" class="btn btn-primary" style="float: right" onclick="createClick1($('#pmpyear :selected').text());"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                <!--///////////////////PMP CREATE-->
                                <!--<button type="button1" class="btn btn-primary" style="float: right" onclick="createClick1();"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                <button type="button" class="btn btn-primary" style="float: right" data-toggle="modal" data-target="#myPMPModaL"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
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
                                                                    <th>Cycle Name</th>
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
                                                                <td>${list[2]}</td>
                                                                <!--<td>$//{list[2]}</td>-->
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[9]}</td>
                                                                <!--<td>${list[6]}</td>-->
                                                                <td>
                                                                    <ul class="products-list product-list-in-box">
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Setting By Employee</span></div>
                                                                            <c:if test="${list[11] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[11] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[11] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>

                                                                        </li><!-- /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">KRA Approval By Manager</span></div>
                                                                            <c:if test="${list[12] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[12] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[12] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                            <c:if test="${list[12] eq 'Rework'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                            </c:if>
                                                                        </li><!-- /.item -->
<!--                                                                      
                                                                        </li> /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Employee’s  Self Assessment</span></div>
                                                                            <c:if test="${list[13] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[13] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[13] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                        </li><!-- /.item -->
                                                                        <li class="item">
                                                                            <div class="col-sm-9" style="padding-right: 0px !important;padding-left: 0px !important;"><span class="product-title">Manager’s  Review</span></div>
                                                                            <c:if test="${list[14] eq 'Approved'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-ok" style="font-size: 15px; color: greenyellow;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[14] eq 'Expired'}">
                                                                                <div class="col-sm-3" align="center"><span class="glyphicon glyphicon-remove" style="font-size: 15px; color: red;"></span></div>
                                                                                </c:if>
                                                                                <c:if test="${list[14] eq 'Pendding'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Pending</span></div>
                                                                            </c:if>
                                                                            <c:if test="${list[14] eq 'Rework'}">
                                                                                <div class="col-sm-3" align="center"><span style="color: #3c8dbc">Rework</span></div>
                                                                            </c:if>
                                                                        </li>
                                                                    </ul>
                                                                </td>
                                                                

                                                                <td>
                                                                    <!--                                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                                            Action <span class="caret"></span>
                                                                                                                                        </button>-->
                                                                    <div class="btn-group">
<!--                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="editClick1(${list[1]},${list[7]},${list[0]},${list[8]});">
                                                                            <span class="fa fa-pencil"></span>&nbsp;&nbsp;Action
                                                                        </button>-->
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            <span class="fa fa-pencil"></span>&nbsp;&nbsp;Action
                                                                        </button>
                                                                        <ul class="dropdown-menu">

                                                                            <%--<c:if test="${list[8] eq year}">--%>
                                                                            <li style="width: 100px;">
                                                                                <a href="#"
                                                                                   onclick="editClick1(${list[1]},${list[7]},${list[0]},${list[8]})

                                                                                                   ;">

                                                                                    &nbsp;&nbsp;Edit PMP
                                                                                </a>
                                                                            </li>
                                                                            <%--</c:if>--%>
                                                                            <%--<c:if test="${list[8] ne year}">--%>
                                                                            <!--                                                                            <li style="width: 100px;">
                                                                                                                                                            <a href="#"
                                                                                                                                                               onclick="pastAppraisalClick(//{list[1]},{list[7]},{list[0]},{list[8]});">

                                                                                                                                                                &nbsp;&nbsp;Past PMP
                                                                                                                                                            </a>
                                                                                                                                                        </li>-->
                                                                            <%--</c:if>--%>


                                                                            <!--                                                                            <li style="width: 100px;">
                                                                                                                                                            <a href="#"
                                                                                                                                                               onclick="editClickCompetency(${list[1]},${list[7]},${list[0]},${list[8]})
                                                                            
                                                                                                                                                                               ;">
                                                                                                                                                                &nbsp;&nbsp;Competency
                                                                                                                                                            </a>
                                                                                                                                                        </li>
                                                                                                                                                        <li style="width: 100px;">
                                                                                                                                                            <a href="#"
                                                                                                                                                               onclick="editClickIdp(${list[1]},${list[7]},${list[0]},${list[8]})
                                                                            
                                                                                                                                                                               ;">
                                                                                                                                                                &nbsp;&nbsp;IDP
                                                                                                                                                            </a>
                                                                                                                                                        </li>-->
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
    <div class="container">
        <div class="modal fade" id="myPMPModaL" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Employee PMP Create</h4>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="form-group">
                                <div class="col-sm-4">
                                    <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>
                                    <label>Year :<span style="color: red;font-size: 12px;"></span></label>
                                    <select name="year" class="form-control" id="pmpyearss"  onchange="selectcycleName(this.value);"  required="true">
                                        <option value="">--Select--</option>
                                        <c:forEach var="pmpyearMap" items="${cycleYear}">
                                            <option value="${pmpyearMap}">${pmpyearMap}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-4" id="nameCycle">
                                    <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>
                                    <label>Cycle Name :<span style="color: red;font-size: 12px;"></span></label>
                                    <select name="cyclename" class="form-control" id="cyclename"  required="true">
                                        <option value="">--Select--</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="form-group">
                                <div class=" col-sm-4">
                                    &nbsp;
                                </div>
                                <div class=" col-sm-4">
                                    &nbsp;
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 text-right">
                            <div class="form-group">
                                <div class=" col-sm-8">
                                </div>
                                <div class=" col-sm-4">
                                    <button type="submit" class="btn btn-primary" onclick="createClick1();" >Submit</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="form-group">
                                <div class=" col-sm-4">
                                    &nbsp;
                                </div>
                                <div class=" col-sm-4">
                                    &nbsp;
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
        });</script>
    
    <script>
         function selectcycleName(typeId) {

            var empSubTypeId = document.getElementById("cyclename").value;
//            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("appraisalFillingData.htm?act=readCycleNameAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('nameCycle').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        $(document).ready(function () {
            var empTypeId = document.getElementById("pmpyearss").value;
            selectcycleName(empTypeId);
        });
        
        
    </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>




