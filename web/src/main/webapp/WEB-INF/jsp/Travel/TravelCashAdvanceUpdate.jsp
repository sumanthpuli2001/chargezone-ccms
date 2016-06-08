<%--
    Document   : TravelCashAdvanceUpdate
    Created on : Mar 22, 2016, 11:13:41 AM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <link rel="stylesheet" href="StorageYard/CSS/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="StorageYard/JS/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <head>
        <title>Travel Management</title>

        <script>
            function buttonFun1() {
                var className = $('#minusId1').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId1').innerHTML = 'Expand';
                }
            }
            function buttonFun2() {
                var className = $('#minusId2').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId2').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId2').innerHTML = 'Expand';
                }
            }
            function buttonFun3() {
                var className = $('#minusId3').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId3').innerHTML = 'Expand';
                }
            }
            function buttonFun4() {
                var className = $('#minusId4').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId4').innerHTML = 'Expand';
                }
            }
            function buttonFun5() {
                var className = $('#minusId5').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId5').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId5').innerHTML = 'Expand';
                }
            }
            function buttonFun6() {
                var className = $('#minusId6').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId6').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId6').innerHTML = 'Expand';
                }
            }

            function cashRequiredId() {
                var selectedValue = document.getElementById("cashRequired").value;
                if (selectedValue == 'Yes') {
                    $("#cashRequiredYes").show();
                    $("#cashRequiredYesCurrency").show();
                } else {
                    $("#cashRequiredYes").hide();
                }
            }

            $(document).ready(function () {
                cashRequiredId();
            });

        </script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Cash Advance Section :</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Cash Advance Section</li>
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
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content"> 
                           <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                            <form:form action="travelRequestMaster.htm?act=submitCashAdvanceSectionByAdmin" method="post" commandName="travelRequestMaster"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <input type="hidden" name="empAjaxId" id="empAjaxId" value="${employeeMaster[6]}">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Employee No.:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[0]}">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[1]}">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[2]}">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" name="levelId" id="levelId" readonly value="${employeeMaster[3]}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[4]}">
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[5]}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Contact No:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster[8]}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${reportingManager}" readonly>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Cash Advance Required:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5()"><i class="fa fa-plus" id="minusId5"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding" <c:if test="${sessionScope.userRight.cashAdvanceView}">style="pointer-events: none;"</c:if>>
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-3" style="width: 17%">
                                                            <label>Cash Advance Required </label>
                                                        <form:select path="cashRequired" class="form-control" onchange="cashRequiredId()" style="text-align: center">
                                                            <form:option value="" label="--SELECT--"></form:option>
                                                            <form:option value="Yes" label="Yes"></form:option>
                                                            <form:option value="No" label="No"></form:option>
                                                        </form:select>
                                                        <span id="cashRequiredIdError" style="color: red;"></span>
                                                    </div>
                                                    <div id="cashRequiredYes" style="display:none">

                                                        <div class="col-sm-2">
                                                            <label>Amount </label>
                                                            <form:input path="amount" class="form-control"  type="number" min="0"></form:input>
                                                                <span id="amountError" style="color: red;"></span>
                                                            </div>
                                                               
                                                            <div class="col-sm-2">
                                                                <div id="cashRequiredYesCurrency">
                                                                    <label>Currency</label>
                                                                <form:select  class="form-control" path="currency">
                                                                    <form:option value="">--SELECT--</form:option>
                                                                    <c:forEach var="currency1" items="${currencyMap}">
                                                                        <c:if test="${travelRequestMaster.currency eq currency1.key}">
                                                                            <form:option value="${currency1.key}" selected="">${currency1.value}</form:option>
                                                                        </c:if>
                                                                        <c:if test="${travelRequestMaster.currency ne currency1.key}">
                                                                            <form:option value="${currency1.key}" >${currency1.value}</form:option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                                 <div class="col-sm-5">
                                                                <label>Reason Of Advance</label>
                                                                 <form:textarea path="reasonForAdvance" class="form-control" readonly="true"></form:textarea>
                                                            </div>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Approver Comment:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding" <c:if test="${sessionScope.userRight.cashAdvanceView}">style="pointer-events: none;"</c:if>>
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Comment:</label>
                                                    <div class="col-sm-7">
                                                    <form:textarea path="cashAdvanceComment" class="form-control" rows="6" ></form:textarea>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--cash advanced required completes here-->
                                <c:if test="${!sessionScope.userRight.cashAdvanceView}">
                                    <div class="form-group">
                                        <div class="col-sm-12" style="text-align: center">
                                            <button type="submit" class="btn btn-success" data-original-title="" title="" style="width: 100px">Approve</button>
                                        </div>
                                    </div>
                                </c:if>
                            </form:form>
                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
