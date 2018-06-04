<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
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
        function buttonFun7() {
            var className = $('#minusId7').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId7').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId7').innerHTML = 'Expand';
            }
        }
        function buttonFun8() {
            var className = $('#minusId8').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId8').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId8').innerHTML = 'Expand';
            }
        }
        function buttonFun9() {
            var className = $('#minusId9').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId9').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId9').innerHTML = 'Expand';
            }
        }
        function buttonFun10() {
            var className = $('#minusId10').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId10').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId10').innerHTML = 'Expand';
            }
        }

    </script>
    <script>

        function withdraw(id) {

            window.location = 'exitInterviewMaster.htm?act=withdraw&id=' + id;
        }

    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Exit Interview Form (Employee)</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Exit Interview</li>
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
                            <!--form horizontal starts here-->
                            <form:form action="exitInterviewMaster.htm?act=submitExitReturn" method="post" commandName="exitInterviewMaster" name='form1' class="form-horizontal" role="form">
                                <div class="box box-info collapsed-box">
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
                                                        <input type="Text" class="form-control" value="${employeeMaster.employeeId}" readonly="true">
                                                        <input type="hidden" name="empId" value="${employeeMaster.id}"/>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Employee Name:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Designation:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.designationMaster.designationName}" readonly="true">
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Level:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.levelMaster.level}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Department:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.departmentMaster.departmentName}" readonly="true">
                                                    </div>

                                                    <div class="col-sm-2">
                                                        <label>Work Location:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${employeeMaster.locationMaster.location}" readonly="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Reporting Manager:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" value="${reportingLevel1}" readonly="true">
                                                        <input type="hidden" name="approverId" value="${employeeMaster.reportingManagerLevel1}"/>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Date of Joining:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                            <input class="form-control" size="16" type="text" value="${employeeMaster.dateOfJoining}" readonly>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Date of Leaving:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input class="form-control" size="16" type="text" value="${employeeMaster.dateOfLeaving}" readonly>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label>Date of Form Submit:</label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                                            <form:input path="dateOfSubmit" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">1)Please describe the primary reason(s) for leaving your current position with SPC Lifesciences.</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"></label>
                                                        <div class="col-sm-12">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <form:textarea path="reasonLeaving" class="form-control" readonly="true"/></c:when>
                                                            <c:otherwise>
                                                                <form:textarea path="reasonLeaving" class="form-control"/>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <div style="color: red"><form:errors path="reasonLeaving" cssClass="errorDiv"></form:errors></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">2)Which of the below mentioned factors were you dissatisfied with, which triggered your thought of leaving SPC Lifesciences?</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">


                                                    <div class="form-group">
                                                        <label class="col-sm-5 control-label">Type of Work or Profile:</label>
                                                        <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }">  
                                                                <c:if test="${exitInterviewMaster.typeOfWork eq false}">
                                                                    <form:input path="typeOfWork" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.typeOfWork eq true}">
                                                                    <form:input path="typeOfWork" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="typeOfWork" id="typeOfWork" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>     
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Working conditions (setting, schedule, travel, flexibility):</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.workingCondition eq false}">
                                                                    <form:input path="workingCondition" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.workingCondition eq true}">
                                                                    <form:input path="workingCondition" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="workingCondition" id="workingCondition" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>    
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Current Compensation:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.currentCompensation eq false}">
                                                                    <form:input path="currentCompensation" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.currentCompensation eq true}">
                                                                    <form:input path="currentCompensation" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="currentCompensation" id="currentCompensation" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>  
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Grade / Level:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.gradeOrLevel eq false}">
                                                                    <form:input path="gradeOrLevel" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.gradeOrLevel eq true}">
                                                                    <form:input path="gradeOrLevel" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="gradeOrLevel" id="gradeOrLevel" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>  
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Reporting Manager:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.reportingManger eq false}">
                                                                    <form:input path="reportingManger" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.reportingManger eq true}">
                                                                    <form:input path="reportingManger" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="reportingManger" id="reportingManger" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Location:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.location eq false}">
                                                                    <form:input path="location" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.location eq true}">
                                                                    <form:input path="location" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="location" id="location" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Commutation or Transportation Issues:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.transportIssues eq false}">
                                                                    <form:input path="transportIssues" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.transportIssues eq true}">
                                                                    <form:input path="transportIssues" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="transportIssues" id="transportIssues" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-5 control-label">Any Medical / Health Condition:</label>
                                                    <div class="col-sm-5">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <c:if test="${exitInterviewMaster.medicalCondition eq false}">
                                                                    <form:input path="medicalCondition" class="form-control" size="16" value='No' readonly="true" ></form:input>
                                                                </c:if>
                                                                <c:if test="${exitInterviewMaster.medicalCondition eq true}">
                                                                    <form:input path="medicalCondition" class="form-control" size="16" value='Yes' readonly="true" ></form:input>
                                                                </c:if>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:select path="medicalCondition" id="medicalCondition" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>



                                            </div>

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">3)Please provide your candid feedback and rate the following aspects with reference to your job at SPC Lifesciences. (Please use the 1 – 5 scale below)</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Job / Role Clarity:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateJob" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateJob" id="rateJob" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Fairness of Workload:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateWorkload" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateWorkload" id="rateWorkload" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Work Conditions:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateWorkCondition" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateWorkCondition" id="rateWorkCondition" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Current Compensation:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateCompensation" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateCompensation" id="rateCompensation" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Facilities & Tools provided to you:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateFacilites" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateFacilites" id="rateFacilites" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Trainings & Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateLearning" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateLearning" id="rateLearning" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support from Co-workers & Seniors within your team:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateSupportFromSeniors" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateSupportFromSeniors" id="rateSupportFromSeniors" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Reporting Manager – Guidance & Supervision:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateSupervision" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateSupervision" id="rateSupervision" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Quality of Performance Feedback:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateQualityOfPerformance" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateQualityOfPerformance" id="rateQualityOfPerformance" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Feedback about your Job:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="rateFeedbackAboutJob" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="rateFeedbackAboutJob" id="rateFeedbackAboutJob" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>

                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">4)Please rate the following aspects of the organization overall. Use the 1 – 5 scale below.</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Openness & Transparency:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="transparency" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="transparency" id="transparency" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support & Cooperation from Employees (Across all Levels):</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="supportFromEmployee" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="supportFromEmployee" id="supportFromEmployee" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="learning" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="learning" id="learning" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Career development Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="careerDevelopment" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="careerDevelopment" id="careerDevelopment" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Recognition for Job:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="recognisitonForJob" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="recognisitonForJob" id="recognisitonForJob" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Work Life Balance:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="workLife" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="workLife" id="workLife" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Org. Policies & Procedures:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="orgPolicies" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="orgPolicies" id="orgPolicies" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Employee Welfare Facilities:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="employeeWellfare" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="employeeWellfare" id="employeeWellfare" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Overall Organizational Culture:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="orgCulture" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="orgCulture" id="orgCulture" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">5)Please rate your supervisor on the following factors. Use the 1-4 Rating scale below.</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6();"><i class="fa fa-plus" id="minusId6" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide Candid & Constructive Performance Feedback:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="performanceFeedback" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="performanceFeedback" id="performanceFeedback" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Recognize accomplishments:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="accomplishments" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="accomplishments" id="accomplishments" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <!--<div class="form-group">-->
                                            <!--<label class="col-sm-5 control-label">Learning Opportunities:</label>-->
                                            <!--<div class="col-sm-5">-->
                                            <%--<c:choose>--%>
                                            <%--<c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }">--%> 
                                            <%--<form:input path="learningOpportunities" class="form-control" size="16" readonly="true" ></form:input>--%>
                                            <%--</c:when>--%>
                                            <%--<c:otherwise>--%>
                                            <%--<form:select path="learningOpportunities" id="learningOpportunities" class="form-control" >--%>
                                            <%--<form:option value="Excellent" label="Excellent"/>--%>
                                            <%--<form:options items="${status}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <%--</c:otherwise>--%>
                                            <%--</c:choose>--%>
                                            <!--</div>-->
                                            <!--</div>-->
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Clearly communicate expectations:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="cummunicateExpectation" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="cummunicateExpectation" id="cummunicateExpectation" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Fair & Respectful Treatment:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="respectfullTreatment" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="respectfullTreatment" id="respectfullTreatment" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide Learning Opportunities:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="provideLearning" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="provideLearning" id="provideLearning" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Coaching & Mentoring:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="coaching" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="coaching" id="coaching" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Encourage teamwork & cooperation:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="teamWork" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="teamWork" id="teamWork" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Resolve concerns promptly:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="resolveConcern" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="resolveConcern" id="resolveConcern" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Listen to suggestions & feedback:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="listenToFeedback" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="listenToFeedback" id="listenToFeedback" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Provide necessary & timely information:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="provideNecessaryInfo" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="provideNecessaryInfo" id="provideNecessaryInfo" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Support Work-Life Balance:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="sopportWorkLife" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="sopportWorkLife" id="sopportWorkLife" class="form-control" >
                                                                <form:option value="Excellent" label="Excellent"/>
                                                                <form:options items="${status}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                        </div>

                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">6)Which reason made you take decision to leave SPC Lifesciences?  Rate top 3 reasons from the following: (Rate 1,2 &3 only) 
                                        </h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Compensation Offered:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="compensatiionOffered" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="compensatiionOffered" id="compensatiionOffered" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Role / Job matching my expectations:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="jobMatchingExpectation" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="jobMatchingExpectation" id="jobMatchingExpectation" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Higher Responsibilities & Job Enrichment:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="higherResponsibility" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="higherResponsibility" id="higherResponsibility" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Designation & Level:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="designationOrLevel" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="designationOrLevel" id="designationOrLevel" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Brand Consideration:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="brandConsideration" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="brandConsideration" id="brandConsideration" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Location:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="factorLocation" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="factorLocation" id="factorLocation" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label">Time to Commute:</label>
                                                <div class="col-sm-5">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <form:input path="timeToCommute" class="form-control" size="16" readonly="true" ></form:input>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <form:select path="timeToCommute" id="timeToCommute" class="form-control">
                                                                <form:options items="${status1}"></form:options>
                                                            </form:select>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">7)Since when were you considering leaving SPC Lifesciences? What can be done to retain you? Please mention in brief.</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label"></label>

                                                    <div class="col-sm-12" id="">
                                                        <c:choose>
                                                            <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                <form:textarea path="reasonForSustain" class="form-control" readonly="true"/>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:textarea path="reasonForSustain" class="form-control"/>
                                                                <div style="color: red"><form:errors path="reasonForSustain" cssClass="errorDiv"></form:errors></div>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </div>
                                                </div>
                                            </div><!-- /.col -->

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">8)If given a choice or considered at a later date, would you like to re-join us?  
                                            <br>Please tick: Yes | No.If No, Why? (Please mention in the space provided here below)
                                            <div class="box-tools pull-right">
                                                <span id="spanId9">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun9();"><i class="fa fa-plus" id="minusId9" ></i></button>
                                            </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <c:choose>
                                                        <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                            <label class="col-sm-3 control-label"></label>
                                                            <div class="col-sm-10" style="pointer-events: none;">
                                                                <form:radiobutton path="againJoin" value="true"/>Yes
                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                <form:radiobutton path="againJoin" value="false"/>No
                                                            </c:when>
                                                            <c:otherwise>
                                                                <label class="col-sm-3 control-label"></label>
                                                                <div class="col-sm-10">
                                                                    <form:radiobutton path="againJoin" value="true"/>Yes
                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <form:radiobutton path="againJoin" value="false"/>No
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </div>
                                                        <br/>
                                                        <br/>
                                                        <div class="col-sm-12">
                                                            <c:choose>
                                                                <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                    <form:textarea path="notToJoinReason" class="form-control" readonly="true"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:textarea path="notToJoinReason" class="form-control"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">9)Any other Suggestions or Feedback? Please mention in brief.</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId10">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun10();"><i class="fa fa-plus" id="minusId10" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label"></label>
                                                        <div class="col-sm-12">
                                                            <c:choose>
                                                                <c:when test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 1 || exitInterviewMaster.status eq 2 }"> 
                                                                    <form:textarea path="otherFeedback" class="form-control" readonly="true"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:textarea path="otherFeedback" class="form-control"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->

                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <!--
                                                                    <div class="form-group">
                                                                        <input type="hidden" name="tabId" value="${id}"/>
                                    <%--<c:if test="${exitInterviewMaster.status eq 1}">--%>
                                        <div class="col-sm-6" style="text-align: left">
                                         <input type="submit" class="btn btn-primary" style="width: 100px;" name="btnType" value="Submit"  />
                                         </div>
                                        <div class="col-sm-6" style="text-align: right">
                                         <input type="button" class="btn btn-warning" style="width: 100px;" value="Withdraw"  onclick="withdraw(${exitInterviewMaster.id});"/>
                                         </div>
                                    <%--</c:if>--%>
                                 <div class="col-lg-offset-5 col-sm-3">
                                    <%--<c:if test="${exitInterviewMaster.status eq 0 || exitInterviewMaster.status eq 2 || exitInterviewMaster.status eq 3 || exitInterviewMaster.status eq 4}">--%>
                                         <input type="button" class="btn btn-warning" style="width: 100px;" value="Withdraw"  onclick="withdraw(${exitInterviewMaster.id});"/>
                                    <%--</c:if>--%>
                                </div>
                    </div>-->
                                </form:form>
                            </div>


                        </div>
                    </div>
                </div>
        </section>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
