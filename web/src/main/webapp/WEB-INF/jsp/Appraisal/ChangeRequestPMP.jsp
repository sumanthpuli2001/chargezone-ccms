<%-- 
    Document   :
    Created on : Oct 19, 2015, 5:34:20 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <script>
        //$('#managerkraStatus').iCheck('check').isSealed(0);  
        /
//        $('input:radio[name="group2"][value="0"]').attr('checked',true);

    </script>
    <script type='text/javascript'>
// <![CDATA[
//        jQuery(document).ready(function () {
//            alert($('input:radio[name="group1"][value="0"]').attr('checked',true));
//          $('input:radio[name="group1"][value="0"]').attr('checked',false);
//
//        });

// ]]>
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Change Request</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Change Request</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" id="form1" role="form1" action="appraisalPerformance.htm?act=changeRequestSubmit" commandName="appraisalPerformanceMaster" enctype="multipart/form-data" method="post" name='form' >
                                    <form:hidden path="id"></form:hidden>
                                    <input type="hidden" name="appraisalId" id="appraisalId" value="${appraisalId1}">
                                    <input type="hidden" name="userid" id="userid" value="${userid}">
                                    <!--<div class="box box-info collapsed-box ">-->

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
                                                        <input type="Text" id="employeeName" name="employeeName"  class="form-control" readonly value="${employeeMaster[1]}">
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
                                                        <input type="Text" class="form-control" readonly value="${employeeMaster[3]}">
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
                                                        <label>Reporting Manager:</label>
                                                    </div>

                                                    <div class="col-sm-4">
                                                        <input type="Text" class="form-control" readonly value="${reportingManager}">
                                                        <select id="kraCategoryMapHiddenMap" name="kraCategoryMapHiddenMap" class="form-control" style="display: none;" >
                                                            <option value="">--SELECT--</option>
                                                            <c:forEach var="kraCategory" items="${kraCategoryMap}">
                                                                <option value="${kraCategory.key}">${kraCategory.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <!--</div> /.row -->

                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label>Manager Side: <c:if test="${appraisalPerformanceMaster.managerkraStatus eq '0'}"><span style="color: red;font-size: 14px;">Your Request Is Manager Side</span></c:if></label>&nbsp;&nbsp;
                                                <fieldset id="group1">
                                                    <!--<input type="radio" name="status" id="status" value="1" checked="<c:if test="${appraisalPerformanceMaster.managerkraStatus eq '1'}">Lock</c:if>">Lock-->
                                                    <!--<input type="radio" name="status" id="status" value="0" checked="<c:if test="${appraisalPerformanceMaster.managerkraStatus eq '0'}">Unlock</c:if>">Unlock-->
                                                <form:radiobutton path="managerkraStatus" value="1"/>Lock
                                                <form:radiobutton path="managerkraStatus" value="0"/>Unlock
                                            </fieldset>

                                        </div>

                                        <div class="col-sm-4">
                                            <label>Employee Side <c:if test="${appraisalPerformanceMaster.employeeStatus eq '0'}"><span style="color: red;font-size: 14px;">Your Request Is Employee Side</span></c:if></label>&nbsp;&nbsp;
                                                <fieldset id="group2">
                                                    <!--<input type="radio" name="status1" id="status1" value="1" checked="<c:if test="${appraisalPerformanceMaster.employeeStatus eq 1}">Lock</c:if>">Lock-->
                                                    <!--<input type="radio" name="status1" id="status1" value="0" checked="<c:if test="${appraisalPerformanceMaster.employeeStatus eq 0}">Unlock</c:if>">Unlock-->
                                                <form:radiobutton path="employeeStatus" value="1"/>Lock
                                                <form:radiobutton path="employeeStatus" value="0"/>Unlock
                                            </fieldset>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            &nbsp;&nbsp;
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>

                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
