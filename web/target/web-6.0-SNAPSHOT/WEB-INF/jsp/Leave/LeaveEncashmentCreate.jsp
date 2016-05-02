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
        <title>Leave Encashment Create</title>
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
    <script>
        function selectLeave(leaveId) {

            document.getElementById('totalLeave').innerHTML = "Fetching ... .. .";
            $.post("leaveEncashment.htm?act=readNoLeaveAjax",
                    {
                        leaveId: leaveId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    document.getElementById('totalLeave').value = responseTxt;
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }
    </script>




    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Leave Encashment Create: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="leaveEncashment.htm?act=createSubmit" method="post" commandName="leaveEncashment"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

            <!--<form class="form-horizontal" role="form" commandName>-->

            <!--Read only entries Starts here-->
            <!--<div class="box box-info collapsed-box ">-->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box-header">

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label>Leave Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-4">
                                                    <form:select path="leaveTypeMaster.id" id="leaveTypeMaster" class="form-control" onchange="selectLeave(this.value)">
                                                        <form:option value="" label="-- Select --" ></form:option>
                                                        <form:options items="${leaveTypemap11}"></form:options>
                                                    </form:select>
                                                    <form:errors path="leaveTypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Total No Of Leave:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                    <form:input  path="totalLeave" class="form-control" readonly="true"/> 
                                                    <form:errors path="totalLeave" cssClass="errorDiv"></form:errors>  
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Enter No Of Encashment Leave:<span style="color: red;font-size: 12px;">*</span></label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                    <form:input  path="noOfLeaveEncashment" class="form-control" onkeypress="return numbersonly(event);"/> 
                                                    <form:errors path="noOfLeaveEncashment" cssClass="errorDiv"></form:errors>  
                                                    </div>
                                                </div>


                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                        <br/> 
                                        <div class="form-group">   
                                            <div class="col-sm-6" style="text-align: center;">
                                                <button type="submit" class="btn btn-primary"  style="width: 100px;"  id="saveSubmit1" >SUBMIT</button>
                                            </div><!-- /.tab-content -->
                                        </div><!-- /.tab-content -->
                                    </div><!-- /.tab-content -->
                                    <hr/>
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
