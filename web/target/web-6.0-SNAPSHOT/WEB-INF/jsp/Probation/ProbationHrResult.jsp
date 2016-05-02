<%--
    Document   : ProbationHrResult
    Created on : Dec 21, 2015, 5:55:08 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hr Confirmation List</title>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation To Confirmation Result </h1>
                <div style="float: right"></div>
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
            <form:form action="" method="post" commandName="ptc"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div style="clear: both"></div>
                                    <div class="box-header">
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty hrlist}">
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
                                                                        <!--<th>Date of Joining(DD/MM/YYYY)</th>-->
                                                                        <!--<th>Date of Confirmation(DD/MM/YYYY)</th>-->
                                                                        <th>Date of Joining</th>
                                                                        <th>Date of Confirmation</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${hrlist}" varStatus="status">
                                                                <tr>
                                                                    <!--<td></td>-->
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <c:forEach items="${mapVal}" var="mapVal">

                                                                        <c:if test="${mapVal.key eq list[0]}">
                                                                            <td>${mapVal.value}</td>
                                                                        </c:if>
                                                                    </c:forEach> 
                                                                    <td>
                                                                        <c:if test="${list[6] eq null}"><span class="badge">In probation</span></c:if>
                                                                        <c:if test="${list[6] eq 0}"><span class="badge">Pending for Manager</span></c:if>
                                                                        <c:if test="${list[6] eq 1}"><span class="label label-success">Submited by manager</span></c:if>
                                                                        <c:if test="${list[6] eq 2}"><span class="badge">Submited by functional head</span></c:if>
                                                                        <c:if test="${list[6] eq 3}"><span class="label label-danger">Rejected</span></c:if>
                                                                        <c:if test="${list[6] eq 4}"><span class="label label-warning">Extended</span></c:if>
                                                                        </td>
                                                                        <td>

                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                    Action <span class="caret"></span>
                                                                                </button>
                                                                                <ul class="dropdown-menu">
                                                                                <c:if test="${list[5] ne null}">
                                                                                    <li>
                                                                                        <a href="#"
                                                                                           onclick="viewClick(${list[5]},${list[0]});">
                                                                                            &nbsp;&nbsp;View
                                                                                        </a>
                                                                                    </li>
                                                                                </c:if>
                                                                                <c:if test="${list[5] eq null}">
                                                                                    <li>
                                                                                        <a href="#" data-toggle="modal" onclick="setRecord('${list[0]}')" data-target="#myModal">
                                                                                            &nbsp;&nbsp;Manual Trigger
                                                                                        </a>
                                                                                    </li>
                                                                                </c:if>
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

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Enter Confirmation Date</h4>
                        </div>
                        <form onsubmit="return returnSubmit();"
                              action="probationToConfirmation.htm?act=probationManualTrigger" commandName="ptc"
                              method="post"  name='form' id ="form" class="form-horizontal" role="form">
                            <input type="hidden" name="empIdVal" id="empIdVal" value=""/>

                            <div class="modal-body">
                                <div class="control-group">
                                   
                                        <label for="inputPassword" class="col-sm-4 control-label">
                                            Confirmation Date:<font style="color: red;font-size: 16px;">*</font>
                                        </label>
                                        <div class="controls">
                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                <input id="endDate" name="endDate" class="form-control" readonly="true">
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <div id="errorRemark0" style="color: red;"></div>
                                        </div>
                                   </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" style="width: 100px" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="Save1" type="submit" class="btn btn-primary" >Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>  
        </div>
        <script>
            function viewClick(id, empId) {
                window.location = "probationToConfirmation.htm?act=hrview&id=" + id + "&empId=" + empId;
            }
        </script>

        <script>
//            function manualTriggerClick(empId) {
//                window.location = "probationToConfirmation.htm?act=ManualTriggerpopup&empId=" + empId;
//            }
        </script>
        <script>
            function returnSubmit() {
                var flag = true;
                var date = document.getElementById('Remark0').value;
                if ('' === date) {
                    flag = false;
                    document.getElementById('errorRemark0').innerHTML = 'Please Enter Date.';
                }
                return flag;
            }

        </script>
        <script>
              $('.form_datetime').datetimepicker({
        //language:  'fr',
                  weekStart: 1,
                todayBtn: 1,
                autoclose: 2,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                showMeridian: 1
        });
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <script>
       function setRecord(id){
           document.getElementById("empIdVal").value=id;
       }
        </script>
    </body>
</html>
