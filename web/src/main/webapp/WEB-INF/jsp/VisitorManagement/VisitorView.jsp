<%-- 
    Document   : VisitorView
    Created on : Oct 27, 2018, 11:19:17 AM
    Author     : Vinit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Management</title>
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

        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Visitor Management Form : </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Management System</li>
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
                                <form:form action="visitorManagement.htm?act=adminAprrovewithdrawClick" method="post" commandName="visitorManagement"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                    <form:hidden path="id"></form:hidden>
                                        <!--Read only entries Starts here-->   
                                        <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">Employee Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeId" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.departmentMaster.departmentName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.designationMaster.designationName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.levelMaster.level" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.locationMaster.location" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.zydexLocationMaster.zydexLocation" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                 
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Visitor's Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section class="content">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Visits Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <input type="text" name="zydexLocationId" id="zydexLocationId" class="form-control" readonly="true" value="${zydexLocation}"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor Visits Employee:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <input type="text" name="visitorVisitsToEmployeeId" id="visitorVisitsToEmployeeId" class="form-control" readonly="true" value="${empVisitsToString}" />    
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor's Full Name<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <form:input path="visitorName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Organization:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorOrganization" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                        <c:if test="${visitorManagement.requestDate ne null and visitorManagement.requestDate ne ''}">     
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Requested Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="requestDate" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <c:if test="${visitorManagement.incomingDateTime ne null and visitorManagement.incomingDateTime ne ''}">    
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Incoming Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="incomingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <c:if test="${visitorManagement.meetingOffDate ne null and visitorManagement.meetingOffDate ne ''}">    
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Meeting Off Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="meetingOffDate" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <c:if test="${visitorManagement.outgoingDateTime ne null and visitorManagement.outgoingDateTime ne ''}">  
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Outgoing Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="outgoingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor's Contact Number:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <form:input path="visitorContactDetail"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Coming From:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorComingFrom"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Accessories:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="accesories"  class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </section>
                                            </div>
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reason In Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <!-- Custom Tabs -->
                                                            <div class="nav-tabs-custom">
                                                                <div class="tab-content">
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label">Reason:<span style="color: red;font-size: 12px;">*</span></label>
                                                                        <div class="col-sm-7">
                                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </section>
                                            </div> 
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-5 col-sm-4">
                                            <c:if test="${visitorManagement.status ne 8 and visitorManagement.status ne 2}">
                                                <button type="submit" class="btn btn-warning" id="saveSubmit1" style="width: 120px !important;padding:5px;font-size:12px;">Withdraw</button>
                                            </c:if>
                                            <!--<button type="submit" class="btn btn-primary" id="saveSubmit1" style="width: 100px;text-align: center;font-size:16px ;">Submit</button>-->
                                        </div> 
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
//                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0,
                showMeridian: 1,
                startDate: new Date()
            });
        </script>
        <!--        <script>
                    jQuery.noConflict();
                    jQuery(document).ready(function () {
                        jQuery("#visitorVisitsToEmployeeId").tokenInput([{id: "1545", name: "vikas /Vikas Brahmbhatt /HR"}], {
                            preventDuplicates: true,
                            noResultsText: "No Result",
                            tokenLimit: "1",
                            searchingText: "Searching ... .. .",
                            prePopulate: [{id: "1545", name: "vikas /Vikas Brahmbhatt /HR"}]
                        });
                        $('#visitorVisitsToEmployeeId').add().css('readonly',true).add().css('pointer-event',none);
                    });
                    jQuery(document).ready(function () {
        
                        if ($('#mriStatus').val() === "Married") {
                            $("#hideInfo1").show(500);
                            $("#hideInfo2").show(500);
                            $("#otherMaritalStatusId").hide(500);
                        } else {
        
                            $("#hideInfo1").hide(500);
                            $("#hideInfo2").hide(500);
                            $("#otherMaritalStatusId").hide(500);
                        }
                        if ($('#mriStatus').val() === "Other") {
                            $("#hideInfo1").hide(500);
                            $("#hideInfo2").hide(500);
                            $("#otherMaritalStatusId").show(500);
                        }
                    }); //when document loaded it loads based on erlier reporting manager
        //            jQuery(document).ready(function () {
        //                alert("ok");
        //                reportingLevelSet();
        //            });
        
        //            function reportingLevelSet() {
        //
        //                var level = document.getElementById("visitorVisitsToEmployeeId").value;
        //                if (level != null && level != '') {
        //                    $.ajax({
        //                        url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
        //                        type: 'GET',
        //                        success: function (result) {
        //                            var array = result.split("~");
        //                            //blank whole fields before put new data
        //                            document.getElementById("reportingManagerLevel2").value = '';
        //                            document.getElementById("reportingManagerLevel3").value = '';
        //                            document.getElementById("reportingManagerLevel4").value = '';
        //                            document.getElementById("reportingManagerLevel5").value = '';
        //                            document.getElementById("reportingManagerLevel6").value = '';
        //                            document.getElementById("reportingManagerLevel2Name").value = '';
        //                            document.getElementById("reportingManagerLevel3Name").value = '';
        //                            document.getElementById("reportingManagerLevel4Name").value = '';
        //                            document.getElementById("reportingManagerLevel5Name").value = '';
        //                            document.getElementById("reportingManagerLevel6Name").value = '';
        //                            document.getElementById("reportingManagerLevel2").value = array[0];
        //                            document.getElementById("reportingManagerLevel3").value = array[1];
        //                            document.getElementById("reportingManagerLevel4").value = array[2];
        //                            //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for id in databese)
        //                            if ((array[4] == "" || array[4] == null) && (array[5] == "" || array[5] == null)) {
        //                                if (array[2] == "" || array[2] == null) {
        //                                    document.getElementById("reportingManagerLevel6").value = level;
        //                                } else {
        //                                    document.getElementById("reportingManagerLevel5").value = level;
        //                                    document.getElementById("reportingManagerLevel6").value = array[2];
        //                                }
        //                            } else {
        //                                if (array[4] == "" || array[4] == null) {
        //                                    document.getElementById("reportingManagerLevel5").value = level;
        //                                } else {
        //                                    document.getElementById("reportingManagerLevel5").value = array[4];
        //                                }
        //                                document.getElementById("reportingManagerLevel6").value = array[5];
        //                            }
        //                            document.getElementById("reportingManagerLevel2Name").value = array[6];
        //                            document.getElementById("reportingManagerLevel3Name").value = array[7];
        //                            document.getElementById("reportingManagerLevel4Name").value = array[8];
        //                            //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for values display on jsp)
        //                            if ((array[10] == "" || array[10] == null) && (array[11] == "" || array[11] == null)) {
        //                                if (array[6] == "" || array[6] == null) {
        //                                    document.getElementById("reportingManagerLevel6Name").value = array[12];
        //                                    //array[12] is for employee name reporting manager.
        //                                } else {
        //                                    document.getElementById("reportingManagerLevel5Name").value = array[12];
        //                                    document.getElementById("reportingManagerLevel6Name").value = array[6];
        //                                }
        //                            } else {
        //                                if (array[10] == "" || array[10] == null) {
        //                                    document.getElementById("reportingManagerLevel5Name").value = array[12];
        //                                } else {
        //                                    document.getElementById("reportingManagerLevel5Name").value = array[10];
        //                                }
        //                                document.getElementById("reportingManagerLevel6Name").value = array[11];
        //                            }
        //                        }
        //                    });
        //                }
        ////            }
                </script>-->
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>

