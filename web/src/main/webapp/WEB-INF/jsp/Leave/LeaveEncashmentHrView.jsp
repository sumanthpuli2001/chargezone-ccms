<%-- 
    Document   : shortLeaveCreate
    Created on : Jan 1, 2016, 12:27:26 PM
    Author     : Khurshid Khokhar <Khokharkhurshid123@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Encashment</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }

    </script>
    <script>

        function noHours(valueStr)
        {
            var a = document.getElementById("hoursNo").value;
            var x = a.keyCode;
            if (!(a >= 48 || a <= 57))
            {
                document.getElementById("hoursNo").value = '';
                alert("enter only numbers");
                return false;
            }
            else if (a == "" || a == null)
            {
                alert("field is blank");
                return false;
            }
            document.getElementById("hoursNo").value = parseInt(a);
//            alert("done");
            return true;
        }


        function numbersonly(e) {
            var unicode = e.charCode ? e.charCode : e.keyCode;
            if (unicode != 8) { //if the key isn't the backspace key (which we should allow)
                if (unicode < 48 || unicode > 57) //if not a number
                    return false //disable key press
            }
        }
    </script>
   




    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Leave Encashment: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="leaveEncashment.htm?act=approveNRejectSubmit"  method="post" commandName="leaveEncashment"
                    name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
            <form:hidden path="leaveTypeMaster.id"></form:hidden>

                <!--<form class="form-horizontal" role="form" commandName>-->

                <!--Read only entries Starts here-->
                <!--<div class="box box-info collapsed-box ">-->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-header">

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:</label>
                                                    <form:input  path="employeeMasterByCreatorEmpId.employeeName" class="form-control" readonly="true"/> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Leave Type:</label>
                                                    <form:input  path="leaveTypeMaster.leaveType" class="form-control" readonly="true"/> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Total No Of Leave:</label>
                                                    <form:input  path="totalLeave" class="form-control" readonly="true"/> 
                                                    <form:errors path="totalLeave" cssClass="errorDiv"></form:errors>  
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Enter No Of Encashment Leave:</label>
                                                    <form:input  path="noOfLeaveEncashment" class="form-control" readonly="true"/> 
                                                    <form:errors path="noOfLeaveEncashment" cssClass="errorDiv"></form:errors>  
                                                    </div>
                                                </div>


                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <!--Leave Balance Shit In Detail completes Here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Approver Comments:</h3>
                                            <div class="box-tools pull-right">
                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Comments/Remark:</label>
                                                        <div class="col-sm-7">
                                                            <textarea id="hrRemark" name="hrRemark" class="form-control" rows="6"></textarea>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <hr/>
                                    <div class="form-group">
                                        <div class="col-sm-1">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-primary" data-original-title="" title="" value="approve">Approve</button>
                                        </div>
                                        <div class="col-sm-1">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-danger" data-original-title="" title="" value="reject">Reject</button>
                                        </div>
                                        <div class="col-sm-1">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-warning" data-original-title="" title="" value="rework">Rework</button>
                                        </div>
                                    </div>
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                </section>

        </form:form>
        <!--</div>-->
        <!--Employee detail completes here-->
        <!--read only entries ends here-->

        <!--form horizontal ends here-->
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
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
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('#carriedForwardStatus1').on('ifChecked', function (event) {
            $('#chechBoxDivId').show(500);
        });
        $('#carriedForwardStatus1').on('ifUnchecked', function (event) {
            $('#chechBoxDivId').hide(500);
        });


    </script>
</html>
