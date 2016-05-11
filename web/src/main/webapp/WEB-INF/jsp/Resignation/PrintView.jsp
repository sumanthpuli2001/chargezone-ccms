<%-- 
    Document   : Hrview
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resignation Form</title>
    </head>

    <script>
        function changeFunc() {
            var empid = document.getElementById("employeeMaster").value;
            alert(empid);
            $.ajax({
                method: "POST",
                url: "resignationMaster.htm?act=employeeAjax",
                data: {empId: empid},
                success: function (data, textStatus, jqXHR) {
                    alert(data);
                    var str = data.split("/");
                    document.getElementById("empNo").value = str[0]
                    document.getElementById("dept").value = str[2]
                    document.getElementById("desc").value = str[3]
                    document.getElementById("level1").value = str[4]
                    document.getElementById("manager").value = str[5]
                    document.getElementById("location").value = str[6]
                }
            })
        }
        ;
    </script>
    <script>
        window.print();
    </script>
    <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px;float: left;"/></span>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Resignation Form : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Resignation</li>
            </ol>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--form horizontal starts here-->
                            <form:form method="post" commandName="resignationMaster"
                                       name='form1'  class="form-horizontal" role="form">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box-header">
                                    <h3 class="box-title">Employee Detail:</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <c:forEach var="list" items="${list}">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Employee No.:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="hidden" class="form-control" name="empId" value="${list[0]}">
                                                        <input type="Text" class="form-control" name="empId" value="${list[7]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${list[1]}" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${list[3]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${list[4]}" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${list[2]}" readonly>
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${list[6]}" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </c:forEach>
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box-header">
                                    <h3 class="box-title">Resignation Information:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Resignation Effective Date & Time:</label>
                                                <div class=" col-sm-7">
                                                    <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                        <form:input class="form-control" path="effectiveDatetime"  readonly='true'></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <div style="color: red"><form:errors path="effectiveDatetime" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Relieving Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                        <form:input class="form-control" path="relievingDate"  readonly='true'></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                        </div>
                                                        <span id="RelieveDateError" style="color: red;"></span>
                                                    </div>
                                                    <!--<div style="color: red">
                                                <%--<form:errors path="relievingDate" cssClass="errorDiv"></form:errors>--%>
                                                    </div>-->
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box-header">
                                    <h3 class="box-title">Reason Of Resignation:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-md-2">Reason:</label>
                                                <div class="col-sm-12">
                                                    <c:choose>
                                                        <c:when test="${sessionScope.userRight.hr}">
                                                            <table>
                                                                <tr>
                                                                    <td>${resignationMaster.reason}</td>
                                                                </tr>
                                                            </table>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <table>
                                                                <tr>
                                                                    <td>${resignationMaster.reason}</td>
                                                                </tr>
                                                            </table>
                                                        </c:otherwise> 
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box-header">
                                    <h3 class="box-title">Manager Comment:</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-md-2">Comment:</label>
                                                <div class="col-sm-12">
                                                    <table>
                                                        <tr>
                                                            <td>${resignationMaster.managerComment}</td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box-header">
                                    <h3 class="box-title">HR Comment:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <label class="col-md-2">Comment:</label>
                                                <div class="col-sm-12">
                                                    <table>
                                                        <tr>
                                                            <td>${resignationMaster.hrComment}</td>
                                                        </tr>
                                                    </table>

                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                            </div>
                        </form:form>
                        <!--form horizontal ends here-->
                        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
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
//            startDate: new Date()
    });
//        $('.form_datetime1').datetimepicker({
//            //language:  'fr',
//            weekStart: 1,
//            todayBtn: 1,
//            autoclose: 1,
//            todayHighlight: 1,
//            startView: 2,
//            forceParse: 0,
//            showMeridian: 1
//            
//        });
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>